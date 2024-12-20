package wiki.zhr.roj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import wiki.zhr.roj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import wiki.zhr.roj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import wiki.zhr.roj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import wiki.zhr.roj.model.entity.User;
import wiki.zhr.roj.model.vo.QuestionSubmitVO;
import javax.servlet.http.HttpServletRequest;

/**
* @author hrz
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-12-11 20:51:36
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);


    /**
     * 获取题目提交查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);



    /**
     * 获取题目提交封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目提交封装
     *
     * @param questionSubmitPage
     * @param request
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

}