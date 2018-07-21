package top.smartpos.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = {"top.smartpos.blog.mappers"})
@SpringBootApplication
public class DevopsSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(DevopsSpringApplication.class, args);
    }
}
