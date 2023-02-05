package id.aryad.sipasar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    private Button login;
    private EditText username, password;
    private ArrayList<Profile_Model> authArrList;
    private boolean isNotAvail;
    private String in_usr, in_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login = (Button) findViewById(R.id.btn_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        authArrList = new ArrayList<>();
        authArrList.add(new Profile_Model(1,"aryaadmin", "pass123","Admin", 1, "Arya Wirawan", "Bukit Jimbaran", R.drawable.admin));
        authArrList.add(new Profile_Model(2,"aryamanager","pass123" ,"Manager", 1, "Arya Aditya", "Jalan Sudirman", R.drawable.manager));
        authArrList.add(new Profile_Model(3,"aryapegawai", "pass123","Pegawai", 1, "Aditya Wirawan", "Jalan Raya Sesetan", R.drawable.pegawai));
        authArrList.add(new Profile_Model(4, "aryanonaktif", "pass123","Admin", 0, "Aris Aditya", "Jalan Krnyeri", R.drawable.user_icon));



        Intent get_update = getIntent();
        int get_id_pegawai = get_update.getIntExtra("id_pegawai", 0);
        String get_username = get_update.getStringExtra("username");
        String get_password = get_update.getStringExtra("password");
        int get_status = get_update.getIntExtra("status", 0);
        String get_nama = get_update.getStringExtra("nama");
        String get_alamat = get_update.getStringExtra("alamat");
        int get_foto = get_update.getIntExtra("foto", 0);

        for (Profile_Model update:authArrList){
            if(update.id_pegawai==get_id_pegawai){
                update.setUsername(get_username);
                update.setPassword(get_password);
                update.setNama(get_nama);
                update.setAlamat(get_alamat);
                update.setFoto(get_foto);
            }
        }



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isNotAvail=false;
                in_usr = username.getText().toString();
                in_pass = password.getText().toString();

                if(in_usr.equals("") || in_pass.equals("")){
                    Toast.makeText(getApplicationContext(), "Isi Data Dengan Lengkap!", Toast.LENGTH_LONG).show();
                }else {
                    for (Profile_Model user:authArrList){
                        if (user.username.equals(in_usr)){
                            if (user.password.equals(in_pass)){
                                if (user.role.equals("Admin")){
                                    isNotAvail=false;
                                    if (user.status==1){
                                        Intent intent_admin = new Intent(Login.this, Admin_Profile.class);
                                        intent_admin.putExtra("id_pegawai", user.id_pegawai);
                                        intent_admin.putExtra("username", user.username);
                                        intent_admin.putExtra("password", user.password);
                                        intent_admin.putExtra("status", user.status);
                                        intent_admin.putExtra("nama", user.nama);
                                        intent_admin.putExtra("alamat", user.alamat);
                                        intent_admin.putExtra("foto", user.foto);
                                        startActivity(intent_admin);
                                        Toast.makeText(getApplicationContext(), "Selamat Datang " +user.nama, Toast.LENGTH_SHORT).show();
                                        break;
                                    }else {
                                        Toast.makeText(getApplicationContext(), "Akun Admin Sudah Tidak Aktif", Toast.LENGTH_LONG).show();
                                        break;
                                    }

                                }else if (user.role.equals("Manager")) {
                                    isNotAvail=false;
                                    if (user.status==1){
                                        Intent intent_manager = new Intent(Login.this, Manager_Profile.class);
                                        intent_manager.putExtra("id_pegawai", user.id_pegawai);
                                        intent_manager.putExtra("username", user.username);
                                        intent_manager.putExtra("password", user.password);
                                        intent_manager.putExtra("status", user.status);
                                        intent_manager.putExtra("nama", user.nama);
                                        intent_manager.putExtra("alamat", user.alamat);
                                        intent_manager.putExtra("foto", user.foto);
                                        startActivity(intent_manager);
                                        Toast.makeText(getApplicationContext(), "Selamat Datang " +user.nama, Toast.LENGTH_SHORT).show();
                                        break;
                                    }else {
                                        Toast.makeText(getApplicationContext(), "Akun Manager Sudah Tidak Aktif", Toast.LENGTH_LONG).show();
                                        break;
                                    }
                                }else {
                                    isNotAvail = false;
                                    if (user.status==1){
                                        Intent intent_pegawai = new Intent(Login.this, Pegawai_Profile.class);
                                        intent_pegawai.putExtra("id_pegawai", user.id_pegawai);
                                        intent_pegawai.putExtra("username", user.username);
                                        intent_pegawai.putExtra("password", user.password);
                                        intent_pegawai.putExtra("status", user.status);
                                        intent_pegawai.putExtra("nama", user.nama);
                                        intent_pegawai.putExtra("alamat", user.alamat);
                                        intent_pegawai.putExtra("foto", user.foto);
                                        startActivity(intent_pegawai);
                                        Toast.makeText(getApplicationContext(), "Selamat Datang " +user.nama, Toast.LENGTH_SHORT).show();
                                        break;
                                    }else {
                                        Toast.makeText(getApplicationContext(), "Akun Pegawai Sudah Tidak Aktif", Toast.LENGTH_LONG).show();
                                        break;
                                    }
                                }
                            }else {
                                isNotAvail=false;
                                Toast.makeText(getApplicationContext(), "Password Salah!", Toast.LENGTH_LONG).show();
                                break;
                            }
                        }else {
                            isNotAvail = true;
                        }
                    }if (isNotAvail == true){
                        Toast.makeText(getApplicationContext(), "Akun Tidak Terdaftar", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}