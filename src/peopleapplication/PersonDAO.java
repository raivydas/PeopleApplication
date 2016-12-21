/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peopleapplication;

/**
 *
 * @author Raivydas
 */

import java.sql.*;
import java.util.*;

public class PersonDAO {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testmysql";
    private static final String USR = "root";
    private static final String PASSWD = "";

    public List<Person> getAllPeopleList() {
        List<Person> peopleList = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USR, PASSWD);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM person";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Person p = new Person(rs.getInt("id"), rs.getString("last_name"));
                peopleList.add(p);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return peopleList;
    }

    public List<Person> getPeopleList(String name) {
        List<Person> peopleList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USR, PASSWD);
            pstmt = conn.prepareStatement("SELECT * FROM person WHERE last_name LIKE ?");
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Person p = new Person(rs.getInt("id"), rs.getString("last_name"));
                peopleList.add(p);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return peopleList;
    }

    public void createPerson(Person newPerson) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String lastName = newPerson.getLastName();

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USR, PASSWD);
            pstmt = conn.prepareStatement("INSERT INTO person VALUES (default, ?)");
            pstmt.setString(1, newPerson.getLastName());
            pstmt.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
