package wiki.zhr.roj.judge;


import org.springframework.stereotype.Service;
import wiki.zhr.roj.judge.strategy.DefaultJudgeStrategy;
import wiki.zhr.roj.judge.strategy.JavaLanguageJudgeStrategy;
import wiki.zhr.roj.judge.strategy.JudgeContext;
import wiki.zhr.roj.judge.strategy.JudgeStrategy;
import wiki.zhr.roj.model.dto.questionsubmit.JudgeInfo;
import wiki.zhr.roj.model.entity.QuestionSubmit;

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
