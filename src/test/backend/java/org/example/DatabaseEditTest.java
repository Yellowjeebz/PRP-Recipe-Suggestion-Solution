/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import java.sql.Statement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseEditTest {
    @Test void testEditDatabase() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "password";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS test_table (id SERIAL PRIMARY KEY, name VARCHAR(255))");
                // Checking inserting works
                stmt.execute("INSERT INTO test_table (name) VALUES ('Test Name 1'), ('Test Name 2')");
                try (ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM test_table")) {
                    if (rs.next()) {
                        assertEquals(2, rs.getInt("count"), "There should be 2 rows in test_table");
                    }
                }
                stmt.execute("DROP TABLE test_table");
            }
        } catch (Exception e) {
            fail("Database editing operations failed: " + e.getMessage());
        }
    }
}
