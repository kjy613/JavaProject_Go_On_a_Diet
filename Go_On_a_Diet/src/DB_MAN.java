// SQL Member
import java.sql.*;
import java.io.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
class DB_MAN {
    String strDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String strURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Member;";
    String strUser = "sa";
    String strPWD = "inha1958";
    
    Connection DB_con;
    Statement DB_stmt;
    ResultSet DB_rs;
    ResultSet DB_rs2;
    
        public void dbOpen() throws IOException{
    try{ Class.forName(strDriver); // Load JDBC Driver
    // MS JDBC Driver does not validate TLS certificate to SQL server
    strURL += "encrypt=true;trustServerCertificate=true;";
    DB_con = DriverManager.getConnection(strURL, strUser, strPWD); // Setting DSN Properties in driver
    DB_stmt = DB_con.createStatement();
    
    }catch(Exception e){
        System.out.println("SQLException : " + e.getMessage());
    }
    }
    public void dbClose() throws IOException{
    try{
        DB_stmt.close();
        DB_con.close();
    }catch(SQLException e){
        System.out.println("SQLException : "+e.getMessage());
    }
    }
}
