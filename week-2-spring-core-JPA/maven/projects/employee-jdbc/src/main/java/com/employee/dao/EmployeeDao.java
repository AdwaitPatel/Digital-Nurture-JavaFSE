package com.employee.dao;

import com.employee.model.Employee;

import java.sql.SQLException;


/**
 * Data Access Object interface for Employee entity.
 * Defines CRUD operations contract.
 */

// planning for Employee
public interface EmployeeDao {

    Employee createEmployee(Employee emp) throws SQLException;
    Employee getEmployeeById(int id) throws SQLException;
    Employee deleteEmployeeById(int id) throws SQLException;

}


