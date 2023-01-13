package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;

public class program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();

			st = conn.prepareStatement(
					"UPDATE seller "  
			+ "SET BaseSalary = BaseSalary + ? " 
			+ "WHERE " 
			+ "(DepartmentId = ?)");

			st.setString(1, "2000");
			st.setString(2, "2");

			int rowsAffected = st.executeUpdate();

			System.out.println("Done! rows affected: " + rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
