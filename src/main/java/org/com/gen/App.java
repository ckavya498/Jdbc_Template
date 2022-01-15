package org.com.gen;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	System.out.println( "Hello World!" );
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new com.mysql.cj.jdbc.Driver());
        dataSource.setUrl("jdbc:mysql://localhost:3306/hr1");
        dataSource.setUsername("root");
        dataSource.setPassword("S##48k@qirt");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sqlInsert = "INSERT INTO employee (id, name, salary)"
                + " VALUES (?, ?, ?)";
        jdbcTemplate.update(sqlInsert, "123", "tom", "12345");

        String sqlUpdate = "UPDATE employee set name=? where id=?";
        jdbcTemplate.update(sqlUpdate, "tom", "123");

        String sqlSelect = "SELECT * FROM employee";
        List<Employee> listContact = jdbcTemplate.query(sqlSelect, new RowMapper<Employee>() {

            public Employee mapRow(ResultSet result, int rowNum) throws SQLException {
                Employee employee = new Employee();
                employee.setId(result.getInt("id"));
                employee.setName(result.getString("name"));
                employee.setSalary(result.getInt("salary"));
                return employee;
            }

        });
      for(Employee e : listContact) {
    	  System.out.println(e);
      }
     // String sqlDel = "delete from Employeewhere id=?";
     // jdbcTemplate.update(sqlDel);
    }
}