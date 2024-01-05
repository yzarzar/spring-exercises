package com.trainging.org.springBootJDBC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/insert")
    public String insertData() {
        jdbcTemplate.execute("INSERT INTO employee VALUES (102, 'Nitin', 'niting@gmail.com', 100000, 'Pune')");
        jdbcTemplate.execute("INSERT INTO employee VALUES (103, 'Sara', 'sara@example.com', 80000, 'New York')");
        jdbcTemplate.execute("INSERT INTO employee VALUES (104, 'Raj', 'raj@hotmail.com', 120000, 'Mumbai')");
        jdbcTemplate.execute("INSERT INTO employee VALUES (105, 'Aisha', 'aisha@yahoo.com', 95000, 'London')");
        jdbcTemplate.execute("INSERT INTO employee VALUES (106, 'Kumar', 'kumar@gmail.com', 110000, 'Chennai')");
        jdbcTemplate.execute("INSERT INTO employee VALUES (107, 'Priya', 'priya@outlook.com', 85000, 'Bangalore')");
        jdbcTemplate.execute("INSERT INTO employee VALUES (108, 'Mohan', 'mohan@gmail.com', 105000, 'Hyderabad')");
        jdbcTemplate.execute("INSERT INTO employee VALUES (109, 'Zara', 'zara@gmail.com', 90000, 'Delhi')");
        jdbcTemplate.execute("INSERT INTO employee VALUES (110, 'Amit', 'amit@yahoo.com', 115000, 'Kolkata')");
        jdbcTemplate.execute("INSERT INTO employee VALUES (111, 'Lina', 'lina@example.com', 98000, 'Jaipur')");

        return "Data inserted successfully";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        String sql = "SELECT * FROM employee";
        List<Employee> employees = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
        return employees;
    }

    @PutMapping("/employees/{empid}")
    public String updateEmployee(@PathVariable int empid, @RequestBody Employee updatedEmployee) {
        String sql = "UPDATE employee SET name=?, email=?, salary=?, address=? WHERE empid=?";
        jdbcTemplate.update(
                sql,
                updatedEmployee.getName(),
                updatedEmployee.getEmail(),
                updatedEmployee.getSalary(),
                updatedEmployee.getAddress(),
                empid
        );
        return "Employee with ID " + empid + " updated successfully";
    }

   @DeleteMapping("/employees/{empId}")
   public String deleteEmployee(@PathVariable int empId) {
        String sql = "DELETE FROM employee WHERE empId=?";
        jdbcTemplate.update(sql, empId);
        return "Employee with ID : " + empId + " deleted successfully";
   }
}
