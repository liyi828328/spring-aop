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
    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

    @Override
    public int sub(int a, int b) {
        int result = a - b;
        return result;
    }

    @Override
    public int mul(int a, int b) {
        int result = a * b;
        return result;
    }

    @Override
    public int div(int a, int b) {
        int result = a / b;
        return result;
    }
}
