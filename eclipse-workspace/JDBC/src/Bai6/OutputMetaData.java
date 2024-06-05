package Bai6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OutputMetaData {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/qlsv";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();

            // Retrieve columns information
            ResultSet columns = statement.executeQuery(
                "SELECT TABLE_NAME, COLUMN_NAME, COLUMN_TYPE, IS_NULLABLE, COLUMN_KEY, COLUMN_DEFAULT, EXTRA " +
                "FROM INFORMATION_SCHEMA.COLUMNS " +
                "WHERE TABLE_NAME IN ('lop', 'sinhvien') AND TABLE_SCHEMA = 'qlsv'"
            );

            System.out.println("Columns Information:");
            while (columns.next()) {
                String tableName = columns.getString("TABLE_NAME");
                String columnName = columns.getString("COLUMN_NAME");
                String columnType = columns.getString("COLUMN_TYPE");
                String isNullable = columns.getString("IS_NULLABLE");
                String columnKey = columns.getString("COLUMN_KEY");
                String columnDefault = columns.getString("COLUMN_DEFAULT");
                String extra = columns.getString("EXTRA");

                System.out.println("Table: " + tableName + ", Column: " + columnName +
                                   ", Type: " + columnType + ", Nullable: " + isNullable +
                                   ", Key: " + columnKey + ", Default: " + columnDefault +
                                   ", Extra: " + extra);
            }

            // Retrieve constraints information
            ResultSet constraints = statement.executeQuery(
                "SELECT TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE " +
                "FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS " +
                "WHERE TABLE_NAME IN ('lop', 'sinhvien') AND TABLE_SCHEMA = 'qlsv'"
            );

            System.out.println("\nConstraints Information:");
            while (constraints.next()) {
                String tableName = constraints.getString("TABLE_NAME");
                String constraintName = constraints.getString("CONSTRAINT_NAME");
                String constraintType = constraints.getString("CONSTRAINT_TYPE");

                System.out.println("Table: " + tableName + ", Constraint: " + constraintName +
                                   ", Type: " + constraintType);
            }

            // Retrieve foreign keys information
            ResultSet foreignKeys = statement.executeQuery(
                "SELECT TABLE_NAME, COLUMN_NAME, CONSTRAINT_NAME, REFERENCED_TABLE_NAME, REFERENCED_COLUMN_NAME " +
                "FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE " +
                "WHERE TABLE_NAME IN ('lop', 'sinhvien') AND TABLE_SCHEMA = 'qlsv' " +
                "AND REFERENCED_TABLE_NAME IS NOT NULL"
            );

            System.out.println("\nForeign Keys Information:");
            while (foreignKeys.next()) {
                String tableName = foreignKeys.getString("TABLE_NAME");
                String columnName = foreignKeys.getString("COLUMN_NAME");
                String constraintName = foreignKeys.getString("CONSTRAINT_NAME");
                String referencedTableName = foreignKeys.getString("REFERENCED_TABLE_NAME");
                String referencedColumnName = foreignKeys.getString("REFERENCED_COLUMN_NAME");

                System.out.println("Table: " + tableName + ", Column: " + columnName +
                                   ", Constraint: " + constraintName +
                                   ", References: " + referencedTableName + "(" + referencedColumnName + ")");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

