package com.suaf.page;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * <br>
 * 手写配置类的话需要排除pagehelp自动配置类
 * @author Suaf
 * @date 2022/6/4 11:42
 * @verson
 */
@SpringBootApplication(exclude= {PageHelperAutoConfiguration.class})
public class App {
    public static void main(String[] args) {
        System.out.println("App start ……");
        SpringApplication.run(App.class,args);
        System.out.println("App start end ……");
    }
}
