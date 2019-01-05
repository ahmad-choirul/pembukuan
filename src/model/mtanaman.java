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
public class mtanaman extends koneksi {

    public mtanaman() throws SQLException {
        super();
    }


    public boolean tambahtanaman(String data) {
        String query = "INSERT INTO `jenis_tanaman` (`id_jenis_tanaman`, `jenis_tanaman`) VALUES (NULL, '"+data+"');";
        return execute(query);
    }

    public boolean hapusdetailsawah(String id) {
        String query = "DELETE FROM `jenis_tanaman` WHERE `id_jenis_tanaman` = '"+id+"'";
        return execute(query);
    }

    public boolean updatedetailsawah(String id,String tanaman) {
        String query = "UPDATE `jenis_tanaman` SET `jenis_tanaman` = '"+tanaman+"' WHERE `jenis_tanaman`.`id_jenis_tanaman` = "+id+";";
        return execute(query);
    }

    public DefaultTableModel getdatatanaman() throws SQLException {
        String kolom[] = {"id_jenis_tanaman", "jenis_tanaman"};
        String query = "SELECT * FROM `jenis_tanaman` ";
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
