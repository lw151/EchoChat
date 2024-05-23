package com.easychat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.swing.*;

/**
 * @author WeiLI
 * @date 2024/5/23 11:12
 * @desciption:
 */

@SpringBootApplication(scanBasePackages = "com.easychat",exclude = DataSourceAutoConfiguration.class)
@Slf4j
public class EasyChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyChatApplication.class);
        log.info("服务成功启动！！！");
    }
}
