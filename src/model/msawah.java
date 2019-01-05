/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class msawah extends koneksi {

    public msawah() throws SQLException {
        super();
    }

    public String[] getlisttanaman() throws SQLException {
        String kolom = "jenis_tanaman";
        String query = "SELECT jenis_tanaman FROM `jenis_tanaman` ";
        return getlist(query, kolom);
    }

    public boolean tambahsawah(String data[]) {
        String query = "INSERT INTO `sawah` (`id_sawah`, `nama_sawah`, `biaya_sewa`, `alamat`, `id_jenis_tanaman`) "
                + "VALUES (NULL, '"+data[0]+"', '"+data[1]+"', '"+data[2]+"', '"+data[3]+"');";
        return execute(query);
    }

    public boolean updatesawah(String data[]) {
        String query = "UPDATE `sawah` SET `nama_sawah`='"+data[1]+"',`biaya_sewa`='"+data[2]+"',`alamat`='"+data[3]+"',"
                + "`id_jenis_tanaman`='"+data[4]+"'  WHERE `sawah`.`id_sawah` = "+data[0]+";";
        return execute(query);
    }

    public String[] getsawwah(String idsawah) {
        String kolom[]={"id_sawah","nama_sawah","biaya_sawah","alamat","id_jenis_tanaman"};
        String query = "select * from sawah where id_sawah = " + idsawah;
        return getdataid(query,kolom);
    }

    public DefaultTableModel getdata() throws SQLException {
        String kolom[] = {"kd_barang", "nama barang", "harga_beli", "harga_jual", "harga_jual3", "harga_jual6", "harga_jual12", "stok", "keterangan"};
        String query = "SELECT * FROM `barang` ";
        return getDatatotal(query, kolom);
    }

    public String[] getdatawithid(String kodebarang) throws SQLException {
        String kolom[] = {"kd_barang", "nama barang", "harga_jual", "harga_jual3", "harga_jual6", "harga_jual12", "stok", "keterangan"};
        String query = "SELECT * FROM `barang` where kd_barang = '" + kodebarang + "' ";
        return getdataid(query, kolom);
    }

    public String[] getdataharga(String kodebarang) throws SQLException {
        String kolom[] = {"kd_barang", "harga_jual", "harga_jual3", "harga_jual6", "harga_jual12"};
        String query = "SELECT kd_barang, harga_jual,harga_jual3,harga_jual6,harga_jual12 FROM `barang` where kd_barang = '" + kodebarang + "' ";
        return getdataid(query, kolom);
    }

    public DefaultTableModel getdatasawah() throws SQLException {
        String kolom[] = {"id_sawah", "nama_sawah", "biaya_sewa", "alamat", "jenistanaman"};
        String query = "SELECT * FROM `sawah`";
        return getDatatotal(query, kolom);
    }
    public DefaultTableModel getdatasawah(String cari) throws SQLException {
        String kolom[] = {"id_sawah", "nama_sawah", "biaya_sewa", "alamat", "jenistanaman"};
        String query = "SELECT * FROM `sawah` WHERE `nama_sawah` LIKE \"%"+cari+"%\" or `biaya_sewa` LIKE \"%"+cari+"%\" or `alamat` LIKE \"%"+cari+"%\" or `id_jenis_tanaman` LIKE \"%"+cari+"%\" ";
        return getDatatotal(query, kolom);
    }
}
