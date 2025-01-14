package wiki.zhr.rojbackendjudgeservice.judge.codesandbox.impl;

import lombok.extern.slf4j.Slf4j;
import wiki.zhr.rojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import wiki.zhr.rojbackendmodel.codesandbox.ExecuteCodeRequest;
import wiki.zhr.rojbackendmodel.codesandbox.ExecuteCodeResponse;
import wiki.zhr.rojbackendmodel.codesandbox.JudgeInfo;
import wiki.zhr.rojbackendmodel.enums.JudgeInfoMessageEnum;
import wiki.zhr.rojbackendmodel.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例代码沙箱（仅为了跑通业务流程）
 */
@Slf4j
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
