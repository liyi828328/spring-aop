package perseverance.li.aop.service;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2020-09-23 09:58
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2020-09-23 09:58 : Create by LiYi
 * ---------------------------------------------------------------
 */
public interface IDbservice {

    int insertDataToDb();

    int updateEmp();

    int updateDept();

    int delDataToDb();
}
