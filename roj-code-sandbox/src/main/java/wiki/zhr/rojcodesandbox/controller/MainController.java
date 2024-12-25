package wiki.zhr.rojcodesandbox.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MainController
 * @Description 用作测试
 * @Author hrz
 * @Date 2024/12/24 09:58
 **/
@RestController("/")
public class MainController {

    @GetMapping("/health")
    public String health() {
        return "ok";
    }
}
