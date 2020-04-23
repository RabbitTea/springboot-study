package com.sandra.staffmanagement.dao;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sandra.staffmanagement.pojo.Department;
import com.sandra.staffmanagement.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 员工dao
 */
@Repository
public class EmployeeDao {

    /**
     * 模拟数据库中的数据
     */
    private static Map<Integer, Employee> employees = null;

    /**
     * 员工有所属的部门
     */
    @Autowired
    private DepartmentDao departmentDao;

    static {
        /**
         * static静态代码块内部是优先加载的，加载完成后才加载上面的属性等；
         */

        // 创建一个部门表
        employees = new HashMap<>();

        employees.put(1001, new Employee(1001, "aa", "111@163.com", 1, new Department(101, "技术部")));
        employees.put(1002, new Employee(1002, "bb", "222@163.com", 0, new Department(102, "技术部")));
        employees.put(1003, new Employee(1003, "cc", "333@163.com", 1, new Department(103, "技术部")));
        employees.put(1004, new Employee(1004, "dd", "444@163.com", 0, new Department(104, "技术部")));
        employees.put(1005, new Employee(1005, "ee", "555@163.com", 1, new Department(105, "技术部")));

    }

    /**
     * 主键自增
     */
    private static Integer initId = 1006;

    /**
     * 增加员工数据
     * @param employee
     */
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }

    /**
     * 查询全部员工信息
     * @return
     */
    public Collection<Employee> getAll() {
        return employees.values();
    }

    /**
     * 通过id查询员工
     * @param id
     * @return
     */
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    /**
     * 删除一个员工
     * @param id
     */
    public void delete(Integer id) {
        employees.remove(id);
    }
}
