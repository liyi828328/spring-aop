package perseverance.li.aop.service.impl;

import org.springframework.stereotype.Service;
import perseverance.li.aop.service.ICalculator;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2020-09-18 11:33
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2020-09-18 11:33 : Create by LiYi
 * ---------------------------------------------------------------
 */
@Service
public class CalculatorImpl implements ICalculator {

    @Override
    public Integer add(Integer a, Integer b) {
        Integer result = a + b;
        return result;
    }

    @Override
    public Integer sub(Integer a, Integer b) {
        Integer result = a - b;
        return result;
    }

    @Override
    public Integer mul(Integer a, Integer b) {
        Integer result = a * b;
        return result;
    }

    @Override
    public Integer div(Integer a, Integer b) {
        Integer result = a / b;
        return result;
    }
}
