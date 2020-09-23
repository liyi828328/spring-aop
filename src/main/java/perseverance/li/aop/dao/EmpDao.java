package perseverance.li.aop.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import perseverance.li.aop.bean.EmpBean;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2020-09-23 10:04
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2020-09-23 10:04 : Create by LiYi
 * ---------------------------------------------------------------
 */
@Component
@Mapper
public interface EmpDao {
    /**
     * 插入emp数据
     *
     * @param empBean
     * @return
     */
    @Insert("INSERT INTO emp (name,age,id_card,dept_no) values (#{name},#{age},#{idCard},#{deptNo})")
    int insertSingleEmp(EmpBean empBean);

    /**
     * 删除
     *
     * @param empId
     * @return
     */
    @Delete("DELETE FROM emp WHERE emp_id = #{empId}")
    int deleteEmp(Integer empId);

    /**
     * 更新
     *
     * @param emp
     * @return
     */
    @Update("UPDATE emp SET name = #{name},age = #{age},id_card = #{idCard},dept_no = #{deptNo} WHERE emp_id = #{empId}")
    int updateEmp(EmpBean emp);
}
