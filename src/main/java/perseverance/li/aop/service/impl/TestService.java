package perseverance.li.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import perseverance.li.aop.service.IDbservice;
import perseverance.li.aop.service.ITestService;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2020-09-23 15:29
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2020-09-23 15:29 : Create by LiYi
 * ---------------------------------------------------------------
 */
@Service
public class TestService implements ITestService {

    @Autowired
    private IDbservice dbservice;

    /**
     * 1.当前test开启了事务
     *  emp Propagation.REQUIRED
     *  dept Propagation.REQUIRED
     *  此种情况为两个子事务都归于test的事务管理，当着test updateEmp updateDept 其中一个方法有异常时，数据都会回滚
     *  当子事务中出现异常后，即使在父事务中进行了try catch也会进行回滚
     *
     *
     * 2.当前test开启了事务
     *  emp Propagation.REQUIRES_NEW 无异常
     *  dept Propagation.REQUIRED 异常
     *  此种情况emp会修改数据，dept会数据回滚，emp配置REQUIRES_NEW为开启了一个新事务，原test事务被挂起，待emp事务执行完后原test继续执行，不受原事务影响
     *
     *  emp propagation = Propagation.REQUIRES_NEW
     *  dept Propagation.REQUIRED
     *  当子事务配置为REQUIRES_NEW，test父事务进行了try catch，其它代码不会回滚。 test其它代码异常如果没有try catch，不会导致REQUIRES_NEW代码回滚
     *
     *  3.当前test开启了事务
     *  emp Propagation.NESTED
     *  dept Propagation.REQUIRED
     *  当子事务配置为Propagation.NESTED，test父事务进行了try catch，其它代码不会回滚。test其它代码异常如果没有try catch，会导致REQUIRES_NEW代码回滚
     */
    @Override
    @Transactional
    public void test() {
        try {
            dbservice.updateEmp();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
        dbservice.updateDept();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        int a = 1 / 0;
    }
}
