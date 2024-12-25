package wiki.zhr.rojcodesandbox.model;

import lombok.Data;

/**
 * 进程执行信息
 */
@Data
public class ExecuteMessage {

    /*
     *  程序退出码
     */
    private Integer exitValue;

    /*
     * 正常输出
     */
    private String message;

    /*
     * 异常输出
     */
    private String errorMessage;

    /*
     * 程序执行时间
     */
    private Long time;

    /*
     * 程序消耗内存
     */
    private Long memory;
}
