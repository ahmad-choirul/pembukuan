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
public class mdetailsawah extends koneksi {

    public mdetailsawah() throws SQLException {
        super();
    }

    public String[] getlisttanaman() throws SQLException {
        String kolom = "jenis_tanaman";
        String query = "SELECT jenis_tanaman FROM `jenis_tanaman` ";
        return getlist(query, kolom);
    }

    public boolean tambahdetailsawah(String data[]) {
        String query = "INSERT INTO `detail_sawah` (`id_detail_sawah`, `id_sawah`, `nama`, `keterangan`, `status`, `besar`, `tanggal`) "
                + "VALUES (NULL, '" + data[0] + "', '" + data[1] + "', '" + data[2] + "', '" + data[3] + "', '" + data[4] + "', CURRENT_TIMESTAMP);";
        return execute(query);
    }

    public boolean hapusdetailsawah(String id) {
        String query = "DELETE FROM `detail_sawah` WHERE `id_detail_sawah` = '"+id+"'";
        return execute(query);
    }

    public boolean updatedetailsawah(String data[]) {
        String query = "UPDATE `detail_sawah` SET `nama`='" + data[1] + "',`keterangan`='" + data[2] + "',`status`='" + data[3] + "',`besar`='" + data[4] + "' WHERE `id_detail_sawah` = '" + data[0] + "'";
        return execute(query);
    }

    public String[] getdetailsawah(String iddetailsawah) {
        String kolom[] = {"id_detail_sawah", "nama", "keterangan", "status", "besar"};
        String query = "select id_detail_sawah,nama,keterangan,status,besar from detail_sawah where id_detail_sawah = " + iddetailsawah;
        return getdataid(query, kolom);
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

    public DefaultTableModel getdana(String status, String id_sawah) throws SQLException {
        String kolom[] = {"id_detail_sawah", "nama", "besar"};
        String query = "SELECT `id_detail_sawah`,`nama`,`besar` FROM `detail_sawah` WHERE `status` = '" + status + "' and `id_sawah` = '" + id_sawah + "'";
        System.out.println(query);
        return getDatatotal(query, kolom);
    }

    public DefaultTableModel getdatasawah(String cari) throws SQLException {
        String kolom[] = {"id_sawah", "nama_sawah", "biaya_sewa", "alamat", "jenistanaman"};
        String query = "SELECT * FROM `sawah` WHERE `nama_sawah` LIKE \"%" + cari + "%\" or `biaya_sewa` LIKE \"%" + cari + "%\" or `alamat` LIKE \"%" + cari + "%\" or `id_jenis_tanaman` LIKE \"%" + cari + "%\" ";
        return getDatatotal(query, kolom);
    }
}
