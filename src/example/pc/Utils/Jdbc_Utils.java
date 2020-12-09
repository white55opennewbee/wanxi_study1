package example.pc.Utils;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class Jdbc_Utils {
    private static Connection connection;
    private static Properties p;

    private static void readProperty() {
        p = new Properties();
        try {
            //InputStream inputStream = Jdbc_Utils.class.getResourceAsStream("WEB-INF/jdbc_property.properties");
            InputStream inputStream = new FileInputStream("D:\\test1\\web\\properties\\jdbc_property.properties");
            p.load(inputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void init() {
        readProperty();
        try {
            Class.forName((String) p.get("driver"));
            connection = DriverManager.getConnection((String) p.get("url"), (String) p.get("user"), (String) p.get("password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        if (connection == null) {
            init();
        }
        return connection;
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static ResultSet getResultSet(String sql) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = getPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
