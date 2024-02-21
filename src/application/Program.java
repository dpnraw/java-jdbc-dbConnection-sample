package application;

import java.sql.ResultSet;

import database.DatabaseConnection;

public class Program {

	public static void main(String[] args) {
		/*
		 * JFrame frame = new JFrame("Life Sync"); frame.setSize(400, 200);
		 * frame.setLocationRelativeTo(null); frame.setVisible(true);
		 * JOptionPane.showMessageDialog(frame, "Hello Java");
		 * JOptionPane.showMessageDialog(frame, "You have less amount, please recharge",
		 * "Apocalyptic message", JOptionPane.WARNING_MESSAGE);
		 */

		// create a database connection class object
		DatabaseConnection dbConnection = new DatabaseConnection();
		// prepare query
		String query = "select * from users";

		// call connect method and cast to resultset from rowset
		ResultSet results = (ResultSet) dbConnection.connect(query);

		// loop the result
		try {
			while (results.next()) {
				System.out.println("Users are: " + results.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		System.out.println("Running application.....");

	}

}
