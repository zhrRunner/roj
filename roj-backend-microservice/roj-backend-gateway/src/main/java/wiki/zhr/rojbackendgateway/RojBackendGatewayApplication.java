package wiki.zhr.rojbackendgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})   // 由于网关不需要数据库，所以排除数据库自动配置，不排除会报错
@EnableDiscoveryClient
public class RojBackendGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(RojBackendGatewayApplication.class, args);
    }

}
