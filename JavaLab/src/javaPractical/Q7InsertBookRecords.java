package javaPractical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Q7InsertBookRecords {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/library";
        String username = "root";
        String password = "";

        String query = "INSERT INTO book (id, title, author, publisher, price) VALUES " +
                "(1, 'Java Programming', 'James Gosling', 'Tech Press', 45.99), " +
                "(2, 'Effective Java', 'Joshua Bloch', 'Pearson', 55.50), " +
                "(3, 'Head First Java', 'Kathy Sierra', 'OReilly', 40.00), " +
                "(4, 'Clean Code', 'Robert Martin', 'Prentice Hall', 50.00), " +
                "(5, 'Spring in Action', 'Craig Walls', 'Manning', 60.00)";

        try {
        	Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.executeUpdate();
            System.out.println("Records inserted successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
