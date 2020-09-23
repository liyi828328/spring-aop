package perseverance.li.aop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import perseverance.li.aop.bean.DeptBean;
import perseverance.li.aop.bean.EmpBean;
import perseverance.li.aop.dao.DeptDao;
import perseverance.li.aop.dao.EmpDao;
import perseverance.li.aop.service.IDbservice;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2020-09-23 10:01
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2020-09-23 10:01 : Create by LiYi
 * ---------------------------------------------------------------
 */
@Service
public class DbServiceImpl implements IDbservice {

    private Logger logger = LoggerFactory.getLogger(DbServiceImpl.class);
    @Autowired
    private EmpDao empDao;
    @Autowired
    private DeptDao deptDao;

    /**
     * 事务介绍
     * propagation 传播行为
     *  REQUIRED
     *      如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
     *  REQUIRES_NEW
     *      新建事务，如果当前存在事务，把当前事务挂起。
     *  SUPPORTS
     *      支持当前事务，如果当前没有事务，就以非事务方式执行。
     *  MANDATORY
     *      使用当前的事务，如果当前没有事务，就抛出异常。
     *  NOT_SUPPORTED
     *      以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
     *  NEVER
     *      以非事务方式执行，如果当前存在事务，则抛出异常。
     *  NESTED
     *      如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
     * <p>
     * isolation 隔离级别
     *  READ_UNCOMMITTED
     *      未提交读:在一个事务中，可以读取到其他事务未提交的数据变化，这种读取其他会话还没提交的事务，叫做脏读现象，在生产环境中切勿使用。
     *  READ_COMMITTED
     *      已提交读:在一个事务中，可以读取到其他事务已经提交的数据变化，这种读取也就叫做不可重复读，因为两次同样的查询可能会得到不一样的结果。
     *  REPEATABLE_READ
     *      可重复读:MySQL默认隔离级别，在一个事务中，直到事务结束前，都可以反复读取到事务刚开始时看到的数据，并一直不会发生变化，避免了脏读、不可重复读现象，但是它还是无法解决幻读问题。
     *  SERIALIZABLE
     *      串行化:这是最高的隔离级别，它强制事务串行执行，避免了前面说的幻读现象，简单来说，它会在读取的每一行数据上都加锁，所以可能会导致大量的超时和锁争用问题。
     *
     * timeout 超时时间
     *  事务执行的超时时间
     *
     * readOnly 只读事务
     *  readOnly = true ,设置为true时为只读事务，不允许对数据进行修改，否则抛出异常
     *
     * 设置哪些异常回滚
     *  rollbackFor = {Exception.class}
     *  rollbackForClassName = {"java.lang.Exception"}
     *
     * 设置哪些异常不会回滚
     *  noRollbackFor = {ArithmeticException.class}
     *  noRollbackForClassName = {"java.lang.ArithmeticException"}
     *
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 10)
    public int insertDataToDb() {
        EmpBean emp = new EmpBean();
        emp.setName("张珊珊");
        emp.setAge(18);
        emp.setIdCard("131028198909384913");
        emp.setDeptNo(1001);
        int empLine = empDao.insertSingleEmp(emp);
        logger.info("insert emp line : " + empLine);

        //int  a =1 /0;
        //如果设置此异常不回滚，则上面sql会成功插入 noRollbackForClassName = {"java.lang.ArithmeticException"}

        DeptBean deptBean = new DeptBean();
        deptBean.setDeptNo(1001);
        deptBean.setDeptName("产品部");
        int deptLine = deptDao.insertSingleDept(deptBean);
        logger.info("insert dept line : " + deptLine);

        return empLine + deptLine;
    }

    int test = 33333111;

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public int updateEmp() {
        EmpBean emp = new EmpBean();
        emp.setName("test" + test);
        emp.setAge(test);
        emp.setIdCard("test" + test);
        emp.setDeptNo(test);
        emp.setEmpId(16);
        int line = empDao.updateEmp(emp);
        logger.info("update emp line : " + line);
//        int a = 1 / 0;
        return line;
    }


    @Override
    @Transactional
    public int updateDept() {
        DeptBean deptBean = new DeptBean();
        deptBean.setDeptNo(test);
        deptBean.setDeptName("test" + test);
        deptBean.setDeptId(6);
        int line = deptDao.updateDept(deptBean);
        logger.info("update dept line : " + line);
//        int a = 1 / 0;
        return line;
    }

    @Override
    public int delDataToDb() {
        return 0;
    }
}
