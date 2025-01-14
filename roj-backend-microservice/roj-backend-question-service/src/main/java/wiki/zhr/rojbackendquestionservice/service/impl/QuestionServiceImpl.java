package wiki.zhr.rojbackendquestionservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import wiki.zhr.rojbackendcommon.common.ErrorCode;
import wiki.zhr.rojbackendcommon.constant.CommonConstant;
import wiki.zhr.rojbackendcommon.exception.BusinessException;
import wiki.zhr.rojbackendcommon.exception.ThrowUtils;
import wiki.zhr.rojbackendcommon.utils.SqlUtils;
import wiki.zhr.rojbackendmodel.dto.question.QuestionQueryRequest;
import wiki.zhr.rojbackendmodel.entity.Question;
import wiki.zhr.rojbackendmodel.entity.User;
import wiki.zhr.rojbackendmodel.vo.QuestionVO;
import wiki.zhr.rojbackendmodel.vo.UserVO;
import wiki.zhr.rojbackendquestionservice.mapper.QuestionMapper;
import wiki.zhr.rojbackendquestionservice.service.QuestionService;
import wiki.zhr.rojbackendserviceclient.service.UserFeignClient;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
* @author hrz
* @description 针对表【question(题目)】的数据库操作Service实现
* @createDate 2024-12-11 20:48:25
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService {

    @Resource
    private UserFeignClient userFeignClient;


    /*
     * @Author Zou hr
     * @Description 校验题目是否合法
     * @Date 17:28 2024/12/12
     * @Param [question, add]
     * @return void
     **/
    @Override
    public void validQuestion(Question question, boolean add) {
        if (question == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String title = question.getTitle();
        String content = question.getContent();
        String tags = question.getTags();
        String answer = question.getAnswer();
        String judgeCase = question.getJudgeCase();
        String judgeConfig = question.getJudgeConfig();
        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(title, content, tags), ErrorCode.PARAMS_ERROR);
        }
        // 非创建时，比如update时，add为false，此时不用每个参数都要有
        // 有参数则校验
        if (StringUtils.isNotBlank(title) && title.length() > 80) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "标题过长");
        }
        if (StringUtils.isNotBlank(content) && content.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "内容过长");
        }
        if (StringUtils.isNotBlank(answer) && answer.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "答案过长");
        }
        if (StringUtils.isNotBlank(judgeCase) && judgeCase.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "判题用例过长");
        }
        if (StringUtils.isNotBlank(judgeConfig) && judgeConfig.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "判题配置过长");
        }
    }

    /**
     * 获取题目查询条件
     *
     * @param questionQueryRequest
     * @return queryWrapper
     */
    @Override
    public QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest) {
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();  // mybatis-plus 查询包装类
        if (questionQueryRequest == null) { // 如果请求对象为空，直接返回空的查询包装类
            return queryWrapper;
        }
        Long id = questionQueryRequest.getId();
        String title = questionQueryRequest.getTitle();
        String content = questionQueryRequest.getContent();
        List<String> tags = questionQueryRequest.getTags();
        String answer = questionQueryRequest.getAnswer();
        Long userId = questionQueryRequest.getUserId();
        String sortField = questionQueryRequest.getSortField();
        String sortOrder = questionQueryRequest.getSortOrder();

        // 拼接查询条件
        queryWrapper.like(StringUtils.isNotBlank(title), "title", title);  // 标题模糊查询,StringUtils.isNotBlank() 不为空时返回 true，然后进行模糊查询，否则不进行模糊查询
        queryWrapper.like(StringUtils.isNotBlank(content), "content", content);
        queryWrapper.like(StringUtils.isNotBlank(answer), "answer", answer);
        if (CollectionUtils.isNotEmpty(tags)) {  // 如果标签列表不为空,collectionUtils是apache的工具类，判断集合是否为空，换成colelctions的isEmpty()方法也可以
            for (String tag : tags) {
                queryWrapper.like("tags", "\"" + tag + "\"");   // 标签列表模糊查询,这里的模糊查询是用like，但是标签列表是一个字符串，所以要加上双引号
            }
        }
        queryWrapper.eq(ObjectUtils.isNotEmpty(id), "id", id);
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId), "userId", userId);
        queryWrapper.eq("isDelete", false);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);   //  sqlUtils.validSortField()用来校验排序字段是否合法
        return queryWrapper;
    }

    /**
     * 获取题目的查询封装类（脱敏）
     *
     * @param question, request
     * @return
     */
    @Override
    public QuestionVO getQuestionVO(Question question, HttpServletRequest request) {
        QuestionVO questionVO = QuestionVO.objToVo(question);
        // 1. 关联查询用户信息
        Long userId = question.getUserId();
        User user = null;
        if (userId != null && userId > 0) {
            user = userFeignClient.getById(userId);
        }
        UserVO userVO = userFeignClient.getUserVO(user);
        questionVO.setUserVO(userVO);
        return questionVO;
    }

    /**
     * 获取题目的查询封装类（脱敏）
     *
     * @param questionPage, request
     * @return
     */
    @Override
    public Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request) {
        // 为什么要返回VO对象？因为VO对象是前端展示的对象，包含了用户信息，而Question对象只是题目的信息，有些信息是不能展示给前端的，相当于做了一个数据的脱敏
        List<Question> questionList = questionPage.getRecords();  // 根据controller传来的分页对象，得到题目列表
        Page<QuestionVO> questionVOPage = new Page<>(questionPage.getCurrent(), questionPage.getSize(), questionPage.getTotal());
        if (CollectionUtils.isEmpty(questionList)) {
            return questionVOPage;
        }
        // 1. 关联查询用户信息
        // 获取用户id集合，去重，是因为一个用户可能创建了多个题目
        Set<Long> userIdSet = questionList.stream().map(Question::getUserId).collect(Collectors.toSet());
        // map集合，key是用户id，value是用户，讲道理一个id对应一个用户，但是这里用了list是因为groupingBy方法返回的是一个list
        Map<Long, List<User>> userIdUserListMap = userFeignClient.listByIds(userIdSet).stream()
                .collect(Collectors.groupingBy(User::getId));
        // 填充信息
        List<QuestionVO> questionVOList = questionList.stream().map(question -> {
            QuestionVO questionVO = QuestionVO.objToVo(question);  // 将题目对象转换为VO对象
            Long userId = question.getUserId();  // 获取用户id
            User user = null;
            if (userIdUserListMap.containsKey(userId)) {
                user = userIdUserListMap.get(userId).get(0);
            }
            questionVO.setUserVO(userFeignClient.getUserVO(user));
            return questionVO;
        }).collect(Collectors.toList());
        questionVOPage.setRecords(questionVOList);  // 将VOrecord列表设置到分页对象中
        return questionVOPage;
    }
}




