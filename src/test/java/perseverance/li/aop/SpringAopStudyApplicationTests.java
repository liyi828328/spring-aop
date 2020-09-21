package perseverance.li.aop;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import perseverance.li.aop.service.ICalculator;

@SpringBootTest
class SpringAopStudyApplicationTests {

    private Logger logger = LoggerFactory.getLogger(SpringAopStudyApplicationTests.class);

    @Autowired
    private ICalculator calculator;

    @Test
    void contextLoads() {

        //perseverance.li.aop.service.impl.CalculatorImpl$$EnhancerBySpringCGLIB$$4f40ea52
        //proxy-target-class 设置为true后，使用cglib做动态代理
        logger.info("calculator : " + calculator.getClass());

        int result = calculator.add(1, 1);
        logger.info("add result : " + result);

        logger.info("-----------");

        int result1 = calculator.div(10, 7);
        logger.info("div result : " + result1);

        logger.info("-----------");

        int result2 = calculator.div(10, 0);
        logger.info("div result : " + result2);
    }

}
