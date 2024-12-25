package wiki.zhr.rojcodesandbox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName ExecuteCodeRequest
 * @Description TODO
 * @Author hrz
 * @Date 2024/12/23 15:15
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteCodeResponse {

    private List<String> outputList;

    /**
     * 接口信息
     */
    private String message;

    /**
     * 执行状态  0 - 待判题、1 - 判题中、2 - 成功、3 - 失败
     */
    private Integer status;

    /**
     * 判题信息  包括程序的执行结果信息，执行时间，执行内存
     */
    private JudgeInfo judgeInfo;
}
