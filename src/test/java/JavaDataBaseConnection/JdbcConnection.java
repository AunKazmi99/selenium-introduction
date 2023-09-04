package JavaDataBaseConnection;

import java.sql.*;

public class JdbcConnection {

    public static void main(String[] args) throws SQLException {
        //Connection URL:
        //  "jdbc:mysql://" +host+":"+port+"/databasename";
        String host = "localhost";
        String port = "3306";
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo",
                "root", "root");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from credentials where scenario = 'zerobalancecard'");
        while (resultSet.next())
        {
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("password"));
        }
    }
}