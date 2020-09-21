package perseverance.li.aop.aspet;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2020-09-18 11:36
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2020-09-18 11:36 : Create by LiYi
 * ---------------------------------------------------------------
 */
@Aspect
@Component
public class LogAspet {

    private Logger logger = LoggerFactory.getLogger(LogAspet.class);

    /**
     * 切面类
     *
     * @Before:前置通知，在方法执行之前完成
     * @After：后置通知，在方法执行完成之后执行
     * @AfterReturing：返回通知：在返回结果之后运行
     * @AfterThrowing：异常通知：出现异常的时候使用
     * @Around：环绕通知
     */

    /**
     * 通用的切面
     */
    @Pointcut("execution(public * perseverance.li.aop.service.ICalculator.*(..))")
    public void pointcut() {

    }

    @Before(value = "pointcut()")
    public void start(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        logger.info("@Before " + signature.getDeclaringTypeName() + " - " + signature.getName() + " 方法开始,参数是 >> "
                + Arrays.asList(args).toString());
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void stop(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        logger.info("@AfterReturning " + signature.getDeclaringTypeName() + " - " + signature.getName() + " 方法结束,return结果 >> " + result);
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void exception(JoinPoint joinPoint, Exception e) {
        Signature signature = joinPoint.getSignature();
        logger.info("@exception " + signature.getDeclaringTypeName() + " - " + signature.getName() + "方法异常,exception >> " + e.getMessage());
    }

    @After("pointcut()")
    public void finallyM(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        logger.info("@After " + signature.getDeclaringTypeName() + " - " + signature.getName() + " 方法全部结束...");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        Object[] args = pjp.getArgs();
        Object result = null;
        try {
            logger.info("@Around " + signature.getDeclaringTypeName() + " - " + signature.getName() + " around ...... start");
            result = pjp.proceed(args);
            logger.info("@Around " + signature.getDeclaringTypeName() + " - " + signature.getName() + " around ...... end >> result : " + result);
        } catch (Throwable throwable) {
            logger.info("@Around " + signature.getDeclaringTypeName() + " - " + signature.getName() + " around exception > " + throwable.getMessage());
            throw throwable;
        } finally {
            logger.info("@Around " + signature.getDeclaringTypeName() + " - " + signature.getName() + " around ...... > finally");
        }
        return result;
    }

}
