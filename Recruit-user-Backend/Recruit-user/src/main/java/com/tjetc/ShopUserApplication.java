package com.tjetc;

import com.tjetc.config.WebSocketServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class })
@EnableTransactionManagement
@MapperScan("com.tjetc.dao")
public class ShopUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopUserApplication.class,args);
        //服务启动时，启动netty整合websocket服务
        try {
            new WebSocketServer(8082).run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
