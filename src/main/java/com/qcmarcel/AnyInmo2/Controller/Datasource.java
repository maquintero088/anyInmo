package com.qcmarcel.AnyInmo2.Controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Datasource {

    private Connection Connection;
    public String ipbase = "", paramuser = "", parampass = "", hostname;
    private String dbname = "myAnyInmo";
    private String passwd = "toor";
    private String dbuser = "qcmarcel";

    public Datasource() {
        try {
            this.hostname = InetAddress.getLocalHost().getHostName();
            //System.out.println(hostname);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
   public Connection PMOdb () {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection = DriverManager.getConnection("jdbc:oracle:thin:@10.25.65.16:1521:HISTPRE", "PMO", "tigo2014");        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Oracle.class.getName()).log(Level.SEVERE, null, ex);
        }        
       return Connection;   
   }   
     */
    public Connection myAnyInmo() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, dbuser, passwd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Connection;
    }

    //
    public ResultSet Resultado(String query) {
        Statement st;
        ResultSet rs = null;
        try {
            st = Connection.createStatement();
            rs = st.executeQuery(query);
            System.out.println(query);
        } catch (SQLException e) {
            Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, "$> " + query, e);
        }
        return rs;
    }

    public void Ejecutar(String query) {
        Statement st;
        try {
            st = Connection.createStatement();
            st.executeUpdate(query);
            System.out.println(query);
            //st.execute("commit");
        } catch (SQLException e) {
            Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, "$> " + query, e);
        }
    }

    public boolean Cerrar() {
        boolean ok = true;
        try {
            Connection.close();
        } catch (SQLException e) {
            ok = false;
            Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, "$> " + ok, e);
        }
        return ok;
    }

}
