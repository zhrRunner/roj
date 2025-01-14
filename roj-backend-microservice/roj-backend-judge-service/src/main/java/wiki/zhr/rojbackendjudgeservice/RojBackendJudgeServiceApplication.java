package wiki.zhr.rojbackendjudgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import wiki.zhr.rojbackendjudgeservice.rabbitmq.InitRabbitMq;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("wiki.zhr")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"wiki.zhr.rojbackendserviceclient.service"})
public class RojBackendJudgeServiceApplication {

    public static void main(String[] args) {
        // 初始化消息队列，先注释掉，改用 Bean 的方式初始化消息队列（InitRabbitMqBean.java）
//        InitRabbitMq.doInit();
        SpringApplication.run(RojBackendJudgeServiceApplication.class, args);
    }

}
