package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public Connection connect() {
		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf_project", "root", "1234");
			System.out.print("Successfully connected");
			

		} catch (Exception e) {

			System.out.print("connection fail");
			e.printStackTrace();
			System.out.print(e);
		}

		return con;
	}
}
