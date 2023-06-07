package com.mhl.service;

import com.mhl.dao.EmployeeDAO;
import com.mhl.domain.Employee;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    public Employee getEmployeeIdAndPwd(String empId,String pwd){
        Employee employee
                = employeeDAO.querySingle("select * from employee where empId=?and pwd=MD5(?)", Employee.class, empId, pwd);
        return employee;
    }
}
