package GroupProjectCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Menu {
	public static void findEmail() {
		System.out.println("Hello. \nPlease Enter a email");
		Scanner showChoice = new Scanner(System.in);
		try {
			Connection connection = Connect.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("select * from user where email =?;");
			String userEmail = showChoice.next();
			pstmt.setString(1, userEmail);// insert values into preparedStatment
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("User found");
			} else {
				System.out.println("Email was not found");
			}
			rs.close();
			showChoice.close();
			pstmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			showChoice.next();
		}
	}

	public static void createUser() {
		Scanner sc = new Scanner(System.in);
		String email = "";
		String password = "";
		System.out.println("Enter email:");
		email = sc.nextLine().trim();// get username and trim whitespace
		System.out.println("Enter password:");
		password = sc.nextLine().trim();// get password and trim whitespace
		System.out.println("Enter first name: ");
		String firstName = sc.next();
		System.out.println("Enter last name: ");
		String lastName = sc.next();
		// System.out.println("Username: "+email+" Password: "+password );
		try {

			if (email.equals("") || password.equals("")) {
				throw new InvalidUsernameOrPassword();
			} else {

			}

			Connection con = Connect.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("INSERT INTO USER (email,password,first_name,last_name) VALUES(?,?,?,?)");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setString(3, firstName);
			pstmt.setString(4, lastName);
			if (pstmt.executeUpdate() > 0) {
				System.out.println("User Created.");
			} else {
				System.out.println("User not Created.");
			}

			sc.close();
			con.close();
			pstmt.close();

		} catch (InvalidUsernameOrPassword inv) {
			System.out.println("username or password is invalid");
		} catch (Exception e) {

			e.printStackTrace();
		}

		sc.close();

	}

	public static void main(String[] args) {
		System.out.println("1 - New User");
		System.out.println("2 - Exsiting User");
		System.out.println("3 - Exit");
		Scanner sc = new Scanner(System.in);
		int userIn = sc.nextInt();
		if (userIn == 1) {
			createUser();
		} else if (userIn == 2) {
			findEmail();

		} else if (userIn == 3) {
			System.out.println("Good Bye.");
		}
		sc.close();
	}

}
