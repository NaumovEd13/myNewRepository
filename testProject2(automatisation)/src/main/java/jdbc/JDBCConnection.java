package jdbc;

import io.qameta.allure.Step;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
    private static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://10-216-193-68.m1.tinkoff.cloud:5432/data";
    private static final String USER = "admin";
    private static final String PASSWORD = "dummyPass123#";
    private static Connection connection;
    private static Statement statement;

    @Step("Достаем перевод из словаря")
    public static String getTranslationFromDictionary(final String textForTranslation) throws ClassNotFoundException, SQLException {
        Class.forName(POSTGRESQL_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
//        String sql = "INSERT INTO Sandbox.languages VALUES('клавиатура','keyboard')";
//        String sql2 = "INSERT INTO Sandbox.languages VALUES('монитор','monitor')";
//        String sql3 = "INSERT INTO Sandbox.languages VALUES('мышь','mouse')";
//        statement.execute("TRUNCATE TABLE Sandbox.languages");
//        statement.execute(sql);
//        statement.execute(sql2);
//        statement.execute(sql3);
        ResultSet set = statement.executeQuery("SELECT translation FROM Sandbox.languages WHERE text = '" + textForTranslation + "'");
        String result = null;
        if (set.next()) {
            result = set.getString(1);
        }
        statement.close();
        connection.close();
        return result;
    }
}
