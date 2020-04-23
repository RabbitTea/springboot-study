package com.sandra.staffmanagement.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sandra.staffmanagement.pojo.Department;
import org.springframework.stereotype.Repository;

/**
 * 部门Dao
 * 这是在没有实际数据库的情境下模拟
 */
@Repository  //被Spring托管
public class DepartmentDao {

    /**
     * 模拟数据库中的数据
     */
    private static Map<Integer, Department> departments = null;

    static {
        // 创建一个部门表
        departments = new HashMap<>();

        departments.put(101, new Department(101, "营销部"));
        departments.put(102, new Department(102, "技术部"));
        departments.put(103, new Department(103, "创新部"));
        departments.put(104, new Department(104, "行政部"));
        departments.put(105, new Department(105, "管理部"));

    }

    /**
     * 获得所有部门信息
     */
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    /**
     * 通过id得到部门
     */
    public Department getDepartment(Integer id) {
        return departments.get(id);
    }
}
