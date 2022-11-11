package GroupProjectCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import GroupProjectCode.Connect;

public class Menu {
	public static boolean userValidation() {
		System.out.println("Hello. \nPlease Enter a email");
		Scanner showChoice = new Scanner(System.in);
		try {

			Connection connection = Connect.getConnection();

			PreparedStatement pstmt = connection.prepareStatement("select * from user where email =?;");

			String userEmail = showChoice.next();

			pstmt.setString(1, userEmail);// insert values into preparedStatment

			ResultSet rs = pstmt.executeQuery();
			rs.close();
			showChoice.close();
			pstmt.close();
			connection.close();
			if (rs.next()) {
				System.out.println("User found");
				return true;

			} else {
				System.out.println("Email was not found");
				return false;
			}

		} catch (Exception e) {
			e.fillInStackTrace();
			showChoice.next();
		
			
		}
		return false;
	}

	public static void main(String[] args) {
		userValidation();
		
	}
}
