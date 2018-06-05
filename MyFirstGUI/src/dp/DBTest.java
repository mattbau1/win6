package dp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {
		try {
			new DBTest();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public DBTest() throws SQLException {

		Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/matthiasbauer/dptest1.accdb;memory=false");

		Statement stmt = conn.createStatement();
		stmt.execute("INSERT INTO Tabelle1(vorname,nachname,ort,plz) Values('hansi2','maier','wien',1120)");

	}

}
