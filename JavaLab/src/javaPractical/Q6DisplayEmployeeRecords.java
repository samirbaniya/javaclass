package javaPractical;

import java.sql.*;

public class Q6DisplayEmployeeRecords {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/testdb";
        String username = "root";
        String password = "";

        String query = "SELECT * FROM employee";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("ID \t Name\t\t Post\t\tSalary");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String post = resultSet.getString("post");
                double salary = resultSet.getDouble("salary");

                System.out.println(id + "\t " + name + "\t " + post + "\t" + salary);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
