package com.sandra.staffmanagement.controller;

import java.util.Collection;

import com.sandra.staffmanagement.dao.DepartmentDao;
import com.sandra.staffmanagement.dao.EmployeeDao;
import com.sandra.staffmanagement.pojo.Department;
import com.sandra.staffmanagement.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {

        // 正常应该是调用Service层，通过Service调用dao层
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);

        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {

        // 查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {

        System.out.println("save===>" + employee);

        // 添加的操作：调用底层业务方法
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id")Integer id, Model model) {

        System.out.println("toUpdate for id=" + id.toString());

        // 查出原来的数据
        Employee employee = employeeDao.getEmployeeById(id);

        System.out.println("employee is :" + employee);

        model.addAttribute("emp", employee);

        // 查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);

        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {

        employeeDao.save(employee);

        return "redirect:/emps";
    }


    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id")int id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
