package wiki.zhr.rojbackendmodel.dto.question;

import lombok.Data;

/**
 * @ClassName JudgeConfig
 * @Description 题目配置
 * @Author hrz
 * @Date 2024/12/12 16:44
 **/
@Data
public class JudgeConfig {

    /**
     * 时间限制（ms）
     */
    private Long timeLimit;

    /**
     * 内存限制（KB）
     */
    private Long memoryLimit;

    /**
     * 堆栈限制（KB）
     */
    private Long stackLimit;
}
