package ru.mti.edu.jdbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class JdbcRunner {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// -Djdbc.drivers=oracle.jdbc.driver.OracleDriver
//			OracleDriver driver = new OracleDriver();
			
			Properties jdbcSettings = new Properties();
			jdbcSettings.load(Files.newInputStream(Paths.get(
//					System.getenv("users.dir")
					"src", "ru", "mti", "edu", "jdbc"
					, "jdbc.properties").toAbsolutePath()));
			try (Connection connection = DriverManager.getConnection(
						jdbcSettings.getProperty("jdbc.url"), 
						jdbcSettings.getProperty("jdbc.user"), 
						jdbcSettings.getProperty("jdbc.password"))) {
				connection.setAutoCommit(false);
				PreparedStatement deleteStat = connection.prepareStatement("delete from emp where empno = ?");
				deleteStat.setInt(1, 7936);
				int rowCount = deleteStat.executeUpdate();
				if (rowCount > 0) {
					System.out.println("Removing was successful and " + rowCount + " rows affected");
				}
				deleteStat.close();
				
				PreparedStatement createStat = connection.prepareStatement(
						"insert into emp(empno, ename, job, hiredate, sal, comm, deptno) " +
							"values (?, ?, ?, ?, ?, ?, ?)");
				createStat.setInt(1, 7936);
				createStat.setString(2, "PETROV");
				createStat.setString(3, "CLERK");
				java.sql.Date hireDate = new Date(new SimpleDateFormat("dd.MM.yyyy").parse("07.08.2017").getTime());
				createStat.setDate(4, hireDate);
				createStat.setInt(5, 2000);
				createStat.setInt(6, 100);
				createStat.setInt(7, 10);
				rowCount = createStat.executeUpdate();
				if (rowCount > 0) {
					System.out.println("Adding was successful");
				}
				createStat.close();
				
				Statement stat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_UPDATABLE);
				try (ResultSet rs = stat.executeQuery("select * from emp, dept " +
								"where emp.deptno = dept.deptno " +
								"order by emp.empno desc")) {
					rs.beforeFirst();
					while(rs.next()) {
						String line = rs.getString("ename") + " | " + rs.getInt("sal") + " | " +rs.getString("loc");
						System.out.println(line);
					}
				}
				stat.close();
				connection.commit();
				
				CallableStatement cStatement = connection.prepareCall("{ call raise_application_error(-20002, 'SQL Exception caused!') }");
				cStatement.execute();
				cStatement.close();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
