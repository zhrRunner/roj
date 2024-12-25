package wiki.zhr.roj.judge.strategy;


import lombok.Data;
import wiki.zhr.roj.model.dto.question.JudgeCase;
import wiki.zhr.roj.judge.codesandbox.model.JudgeInfo;
import wiki.zhr.roj.model.entity.Question;
import wiki.zhr.roj.model.entity.QuestionSubmit;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;  // 执行的输入

    private List<String> outputList;  // 执行的结果输出

    private List<JudgeCase> judgeCaseList;  // 题目的用例

    private Question question;

    private QuestionSubmit questionSubmit;

}
