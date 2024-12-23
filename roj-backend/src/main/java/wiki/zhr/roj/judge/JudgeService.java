package wiki.zhr.roj.judge;

import org.springframework.stereotype.Service;
import wiki.zhr.roj.model.entity.QuestionSubmit;

/**
 * @InterfaceName JudgeService
 * @Description 判题服务
 * @Author hrz
 * @Date 2024/12/23 16:37
 **/
@Service
public interface JudgeService {

    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
