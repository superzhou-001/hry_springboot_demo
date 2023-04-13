package com.hry.demo.mapper;

import com.hry.demo.pojo.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void save(Employee employee);
}
