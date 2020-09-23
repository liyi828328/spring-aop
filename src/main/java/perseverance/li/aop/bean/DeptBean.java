package perseverance.li.aop.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2020-09-03 11:28
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2020-09-03 11:28 : Create by LiYi
 * ---------------------------------------------------------------
 */
public class DeptBean implements Serializable {

    private Integer deptId;
    private Integer deptNo;
    private String deptName;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
