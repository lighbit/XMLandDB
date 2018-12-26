package com.DAO;

/**
 * @author zulkarnaen
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.datakeluarga.Family;

public class InsertFamily {

	@SuppressWarnings("unused")
	public static void SimpanFamily(Family simpan) throws ClassNotFoundException, SQLException {

		String myDriver = "com.mysql.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/karyawaninsentif";
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, "root", "zulka....");
		// the mysql insert statement
		String query = "INSERT INTO `karyawaninsentif`.`family` (`family`, `child`, `parent`, `record_name`) VALUES ( ?, ?, ?, ?);";

		String query1 = "INSERT INTO `karyawaninsentif`.`family` (child, parent, record_name)" + "SELECT * FROM (SELECT ?,?,?) AS tmp "
				+ "WHERE NOT EXISTS ( SELECT parent FROM family " + "WHERE parent = ?) LIMIT 1";
		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = conn.prepareStatement(query1);

		preparedStmt.setString(1, simpan.getChild());
		preparedStmt.setString(2, simpan.getParent());
		preparedStmt.setString(3, simpan.getName());
		preparedStmt.setString(4, simpan.getParent());

		preparedStmt.execute();

		conn.close();

	}
}
