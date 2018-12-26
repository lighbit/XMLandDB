package com.DAO;

/**
 * @author zulkarnaen
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.datakeluarga.Family;

public class InsertRecord {

	@SuppressWarnings("unused")
	public static void SimpanRecord(Family simpan) throws ClassNotFoundException, SQLException {

		String myDriver = "com.mysql.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/karyawaninsentif";
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, "root", "zulka....");
		// the mysql insert statement
		String query = "INSERT INTO `karyawaninsentif`.`record` (`name`, `phone`, `email`, `city`) VALUES (?, ?, ?, ?);";

		String query1 = "INSERT INTO `karyawaninsentif`.`record` (name, phone, email, city)" + "SELECT * FROM (SELECT ?,?,?,?) AS tmp "
				+ "WHERE NOT EXISTS ( SELECT name FROM record " + "WHERE name = ?) LIMIT 1";
		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = conn.prepareStatement(query1);

		preparedStmt.setString(1, simpan.getName());
		preparedStmt.setString(2, simpan.getPhone());
		preparedStmt.setString(3, simpan.getEmail());
		preparedStmt.setString(4, simpan.getCity());
		preparedStmt.setString(5, simpan.getName());

		preparedStmt.execute();

		conn.close();

	}

}
