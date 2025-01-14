package wiki.zhr.rojbackendjudgeservice.judge;

import org.springframework.stereotype.Service;
import wiki.zhr.rojbackendmodel.entity.QuestionSubmit;

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
