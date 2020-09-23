package perseverance.li.aop.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import perseverance.li.aop.bean.DeptBean;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2020-09-23 10:05
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2020-09-23 10:05 : Create by LiYi
 * ---------------------------------------------------------------
 */
@Component
@Mapper
public interface DeptDao {

    /**
     * 插入dept数据
     *
     * @param deptBean
     * @return
     */
    @Insert("INSERT INTO dept (dept_no,dept_name) values (#{deptNo},#{deptName})")
    int insertSingleDept(DeptBean deptBean);

    /**
     * 删除
     *
     * @param deptId
     * @return
     */
    @Delete("DELETE FROM dept WHERE dept_id = #{deptId}")
    int deleteDept(Integer deptId);

    /**
     * 更新
     *
     * @param deptBean
     * @return
     */
    @Update("UPDATE dept SET dept_no = #{deptNo},dept_name = #{deptName} WHERE dept_id = #{deptId}")
    int updateDept(DeptBean deptBean);
}
