package perseverance.li.aop;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import perseverance.li.aop.service.ICalculator;
import perseverance.li.aop.service.IDbservice;
import perseverance.li.aop.service.ITestService;

@SpringBootTest
class SpringAopStudyApplicationTests {

    private Logger logger = LoggerFactory.getLogger(SpringAopStudyApplicationTests.class);

    @Autowired
    private ICalculator calculator;
    @Autowired
    private IDbservice dbservice;
    @Autowired
    private ITestService testService;

    @Test
    void contextLoads() {

        //perseverance.li.aop.service.impl.CalculatorImpl$$EnhancerBySpringCGLIB$$4f40ea52
        //proxy-target-class 设置为true后，使用cglib做动态代理
        logger.info("calculator : " + calculator.getClass());

        Integer result = calculator.add(1, 1);
        logger.info("test add result : " + result);

//        logger.info("-----------");
//
//        int result1 = calculator.div(10, 7);
//        logger.info("div result : " + result1);
//
        logger.info("-----------");
//
        Integer result2 = calculator.div(10, 0);
        logger.info("div result : " + result2);
    }

    @Test
    void test01() {
        int line = dbservice.insertDataToDb();
        logger.info("insert line : " + line);
    }

    @Test
    void test02() {
        testService.test();
    }

}
