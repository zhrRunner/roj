package wiki.zhr.roj.judge.codesandbox;

import wiki.zhr.roj.judge.codesandbox.model.ExecuteCodeRequest;
import wiki.zhr.roj.judge.codesandbox.model.ExecuteCodeResponse;

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
