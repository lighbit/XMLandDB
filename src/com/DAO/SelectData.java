package com.DAO;

/**
 * @author zulkarnaen
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.datakeluarga.Family;

public class SelectData {

	public static List<Family> ambilData() throws ClassNotFoundException, SQLException {
		List<Family> empList = new ArrayList<Family>();

		Statement statement = null;
		ResultSet resultSet = null;

		String myDriver = "com.mysql.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/karyawaninsentif";
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, "root", "zulka....");
		statement = conn.createStatement();
		String sql = "SELECT a.*, b.* FROM record a JOIN family b WHERE a.NAME=b.record_name";
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			Family emp = new Family();

			emp.setName(resultSet.getString("name"));
			emp.setPhone(resultSet.getString("phone"));
			emp.setEmail(resultSet.getString("email"));
			emp.setCity(resultSet.getString("city"));
			emp.setChild(resultSet.getString("child"));
			emp.setParent(resultSet.getString("parent"));

			empList.add(emp);

		}

		return empList;
	}
}
