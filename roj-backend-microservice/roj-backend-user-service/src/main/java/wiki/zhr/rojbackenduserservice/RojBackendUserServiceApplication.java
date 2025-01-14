package wiki.zhr.rojbackenduserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("wiki.zhr.rojbackenduserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("wiki.zhr")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"wiki.zhr.rojbackendserviceclient.service"})
public class RojBackendUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RojBackendUserServiceApplication.class, args);
    }

}
