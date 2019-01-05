package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.math.BigInteger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class koneksi {

    Connection con;
    Statement stm;
    java.sql.Connection connection;
    String pass = "150996 Aichi"; //password DB, Jika tidak di Password silahkan di Kosongkan.
    String pass1 = ""; //password DB, Jika tidak di Password silahkan di Kosongkan.

    public koneksi() throws SQLException {
        String url = "jdbc:mysql://localhost/dbpembukuan"; //url DB
        String username = "root"; //username DB
        //membuat koneksi ke DB
        this.con = (Connection) DriverManager.getConnection(url, username, pass1);
        this.stm = (Statement) this.con.createStatement();
    }

    public java.sql.Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/dbtoko", "root", pass1);
        } catch (Exception e) {
        }
        return connection;
    }

    //method untuk ekesekusi query Insert, Update, dan Delete
    public void executeQuery(String query) throws SQLException {
        this.stm.execute(query);
    }

    //method untuk ekesekusi query Select
    public ResultSet getResult(String query) throws SQLException {
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }

    public boolean execute(String query) {
        boolean sukseseksekusi;
        try {
            executeQuery(query);
            sukseseksekusi = true;
            System.out.println("query berhasil");
        } catch (SQLException ex) {
            sukseseksekusi = false;
            System.out.println("query salah");
            System.out.println(query);
            System.out.println(query);
        }

        return sukseseksekusi;
    }

    public String[] getdataid(String query, String data[]) {
        String[] getdata = new String[data.length];
        try {
            ResultSet rs = getResult(query);
            if (rs.next()) {
                for (int i = 0; i < data.length; i++) {;
                    getdata[i] = rs.getString(i + 1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getdata;
    }

    public String[] getlist(String query, String kolom) throws SQLException {
        ResultSet rs = getResult(query);
        List<String> datalist = new ArrayList<>();
        while (rs.next()) {
            datalist.add(rs.getString(kolom));
        }
        String getdata[] = new String[datalist.size()];
        getdata = datalist.toArray(getdata);
        return getdata;
    }

    public DefaultTableModel getDatatotal(String query, String kolom[]) throws SQLException {
        DefaultTableModel table = new DefaultTableModel(null, kolom);
        ResultSet rs = getResult(query);
        while (rs.next()) {
            String row[] = new String[kolom.length];
            for (int i = 0; i < row.length; i++) {
                row[i] = rs.getString(i + 1);
            }
            table.addRow(row);
        }
        return table;
    }

    public String getdataidNoaray(String query) throws SQLException {
        ResultSet rs = getResult(query);
        String data = "";
        if (rs.next()) {
            data = rs.getString(1);
        }
        return data;
    }
}
