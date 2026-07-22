package com.employee.dao;

import com.employee.dbUtil.DBConnection;
import com.employee.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public Employee createEmployee(Employee emp) {

        String q = "INSERT INTO employee (name, email) VALUES (?, ?)";

        try(Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());

            int rowUpdated = ps.executeUpdate();
            if (rowUpdated > 0) return emp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Employee getEmployeeById(int id)  {

        Employee employee = new Employee();

        String q = "SELECT * FROM employee WHERE id = ?";

        try(Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);

            ResultSet empData = ps.executeQuery();

            if (empData.next()) {
                employee.setId(empData.getInt("id"));
                employee.setName(empData.getString("name"));
                employee.setEmail(empData.getString("email"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return employee;
    }

    @Override
    public Employee deleteEmployeeById(int id)  {

        Employee employee = new Employee();

        String q = "DELETE FROM employee WHERE id = ?";

        try(Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);

            ResultSet empData = ps.executeQuery();

            if (empData.next()) {
                employee.setId(empData.getInt("id"));
                employee.setName(empData.getString("name"));
                employee.setEmail(empData.getString("email"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return employee;
    }
}
