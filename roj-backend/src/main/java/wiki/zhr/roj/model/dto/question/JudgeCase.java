package wiki.zhr.roj.model.dto.question;

import lombok.Data;

/**
 * @ClassName JudgeCase
 * @Description 题目用例
 * @Author hrz
 * @Date 2024/12/12 16:42
 **/
@Data
public class JudgeCase {

    /**
     * 输入用例
     */
    private String input;

    /**
     * 输出用例
     */
    private String output;
}
