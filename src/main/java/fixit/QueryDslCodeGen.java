package fixit;

import com.mysema.query.sql.codegen.MetaDataExporter;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QueryDslCodeGen {

    public static void main(String[] args) throws SQLException {

        String dbUrl = "jdbc:postgresql://localhost:5433/fixitgis";
        String dbUsername = "postgres";
        String dbPassword = "postgres";

        java.sql.Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        MetaDataExporter exporter = new MetaDataExporter();
        exporter.setPackageName("com.myproject.domain");

        exporter.setTargetFolder(new File("generated"));
        exporter.export(connection.getMetaData());
    }
}
