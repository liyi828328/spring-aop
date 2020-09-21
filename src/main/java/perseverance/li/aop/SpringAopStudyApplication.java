package perseverance.li.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAspectJAutoProxy 引入aop后自动开启，无需在配置
public class SpringAopStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopStudyApplication.class, args);
    }

}
