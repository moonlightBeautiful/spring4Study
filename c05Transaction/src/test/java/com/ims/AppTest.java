package com.ims;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.sql.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bank?serverTimezone=UTC", "root", "root");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from t_count");
        while (rs.next()) {
            System.out.print(rs.getString(2));
        }
    }
}
