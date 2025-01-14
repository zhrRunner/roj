package wiki.zhr.rojbackendserviceclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wiki.zhr.rojbackendmodel.entity.QuestionSubmit;

/**
 * @InterfaceName JudgeService
 * @Description 判题服务
 * @Author hrz
 * @Date 2024/12/23 16:37
 **/
@FeignClient(name = "roj-backend-judge-service", path = "/api/judge/inner")
public interface JudgeFeignClient {

    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    @PostMapping("/do")
    QuestionSubmit doJudge(@RequestParam("questionSubmitId") long questionSubmitId);
}
