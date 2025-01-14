package wiki.zhr.rojbackendjudgeservice.judge.codesandbox.impl;


import wiki.zhr.rojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import wiki.zhr.rojbackendmodel.codesandbox.ExecuteCodeRequest;
import wiki.zhr.rojbackendmodel.codesandbox.ExecuteCodeResponse;

/**
 * 第三方代码沙箱（调用网上现成的代码沙箱）
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
