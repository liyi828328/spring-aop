package perseverance.li.aop.bean;

import java.io.Serializable;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2020-09-03 10:42
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2020-09-03 10:42 : Create by LiYi
 * ---------------------------------------------------------------
 */
public class EmpBean implements Serializable {

    private Integer empId;
    private String name;
    private Integer age;
    private String idCard;
    private Integer deptNo;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }
}
