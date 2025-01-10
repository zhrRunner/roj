package wiki.zhr.rojcodesandbox;


import org.springframework.stereotype.Component;
import wiki.zhr.rojcodesandbox.model.ExecuteCodeRequest;
import wiki.zhr.rojcodesandbox.model.ExecuteCodeResponse;

/**
 * Java 原生代码沙箱实现（直接复用模板方法）
 */
@Component
public class JavaNativeCodeSandbox extends JavaCodeSandboxTemplate {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        return super.executeCode(executeCodeRequest);
    }
}
