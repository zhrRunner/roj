package wiki.zhr.rojbackendjudgeservice.judge;


import org.springframework.stereotype.Service;
import wiki.zhr.rojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import wiki.zhr.rojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import wiki.zhr.rojbackendjudgeservice.judge.strategy.JudgeContext;
import wiki.zhr.rojbackendjudgeservice.judge.strategy.JudgeStrategy;
import wiki.zhr.rojbackendmodel.codesandbox.JudgeInfo;
import wiki.zhr.rojbackendmodel.entity.QuestionSubmit;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
