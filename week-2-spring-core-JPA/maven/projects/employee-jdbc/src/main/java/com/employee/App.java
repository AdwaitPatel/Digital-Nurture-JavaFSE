package com.employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.employee.dao.EmployeeDao;
import com.employee.dao.EmployeeDaoImpl;
import com.employee.dbUtil.DBConnection;
import com.employee.model.Employee;


public class App {
    public static void main( String[] args ) throws SQLException {

//        ResourceBundle bundle = ResourceBundle.getBundle("application");
//        String u = bundle.getString("db.util");


        Connection con = DBConnection.getConnection();

        // add new employee

//        Employee e1 = new Employee();
//        e1.setName("David");
//        e1.setEmail("david123@gmail.com");
        EmployeeDao empDao = new EmployeeDaoImpl();
//        empDao.createEmployee(e1);

        // get employee with id
        Employee emp = empDao.getEmployeeById(2);
        System.out.println(emp);



    }
}
