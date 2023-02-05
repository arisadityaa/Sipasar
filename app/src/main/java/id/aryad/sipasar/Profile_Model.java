package id.aryad.sipasar;

import android.widget.ImageView;

import java.util.ArrayList;

public class Profile_Model {
    public int id_pegawai;
    public String username;
    public String password;
    public String role;
    public int status;
    public String nama;
    public String alamat;
    public int foto;


    public Profile_Model(int id_pegawai, String username, String password, String role, int status, String nama, String alamat, int foto){
      this.id_pegawai = id_pegawai;
      this.username = username;
      this.password = password;
      this.role = role;
      this.status = status;
      this.nama = nama;
      this.alamat = alamat;
      this.foto = foto;
    }

    public int getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(int id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

