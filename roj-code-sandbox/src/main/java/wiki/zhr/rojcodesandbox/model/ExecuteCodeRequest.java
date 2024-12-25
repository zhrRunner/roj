package wiki.zhr.rojcodesandbox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName ExecuteCodeRequest
 * @Description 执行代码的请求，包含发送给代码沙箱的参数
 * @Author hrz
 * @Date 2024/12/23 15:15
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteCodeRequest {
    /*
     * 一组输入
     */
    private List<String> inputList;

    /*
     * 代码
     */
    private String code;

    /*
     * 判题语言
     */
    private String language;

}
