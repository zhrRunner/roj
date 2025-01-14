package wiki.zhr.rojbackendserviceclient.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import wiki.zhr.rojbackendmodel.dto.question.QuestionQueryRequest;
import wiki.zhr.rojbackendmodel.entity.Question;
import wiki.zhr.rojbackendmodel.entity.QuestionSubmit;
import wiki.zhr.rojbackendmodel.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author hrz
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2024-12-11 20:48:25
*/
@FeignClient(name = "roj-backend-question-service", path = "/api/question/inner")
public interface QuestionFeignClient {

    @GetMapping("/get/id")
    Question getQuestionById(@RequestParam("questionId") long questionId);

    @GetMapping("/question_submit/get/id")
    QuestionSubmit getQuestionSubmitById(@RequestParam("questionId") long questionSubmitId);

    @PostMapping("/question_submit/update")
    boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit);

}
