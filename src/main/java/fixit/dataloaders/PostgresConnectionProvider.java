package fixit.dataloaders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionProvider implements IConnectionProvider
{
    private static String dbUrl = "jdbc:postgresql://localhost:5433/fixitgis";
    private static String dbUsername = "postgres";
    private static String dbPassword = "postgres";
    private static Connection dbconnection = null;

    @Override
    public Connection getConnection() throws SQLException
    {
        if(dbconnection == null)
            dbconnection =  DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        return dbconnection;
    }
}
