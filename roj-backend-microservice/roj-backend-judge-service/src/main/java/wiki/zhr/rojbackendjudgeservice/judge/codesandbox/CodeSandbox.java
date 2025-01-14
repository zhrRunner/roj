package wiki.zhr.rojbackendjudgeservice.judge.codesandbox;


import wiki.zhr.rojbackendmodel.codesandbox.ExecuteCodeRequest;
import wiki.zhr.rojbackendmodel.codesandbox.ExecuteCodeResponse;

/**
 * @InterfaceName CodeSandbox
 * @Description 代码沙箱接口定义
 * @Author hrz
 * @Date 2024/12/23 15:12
 **/
public interface CodeSandbox {
    /*
     * @Author Zou hr
     * @Description 执行代码
     * @Date 15:25 2024/12/23
     * @Param [executeCodeRequest]
     * @return wiki.zhr.roj.judge.codesandbox.model.ExecuteCodeResponse
     **/
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
