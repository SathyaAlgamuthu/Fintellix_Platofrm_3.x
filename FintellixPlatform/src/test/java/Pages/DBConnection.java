package Pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	Connection con;
	Statement stmt;
	String url;
	String user;
	String password;

	public void SQLconnection_establish(String url, String user, String password) throws Exception {
		int val = 0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, user, password);
		System.out.println("Connection establised");
		stmt = con.createStatement();
		ResultSet MaxofUserid = stmt.executeQuery("select max(USERID)FROM VYASAUSERS");
		if (MaxofUserid.next()) {
			val = MaxofUserid.getInt(1);
			System.out.println(val);
		}
		ResultSet rs = stmt
				.executeQuery("select USERNAME, USERID, USERCREATIONDATE FROM VYASAUSERS order by USERID desc");
		while (rs.next())
			System.out.println(rs.getString(1) + "  " + rs.getString(2));

	}
}
