package id.aryad.sipasar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Admin_Profile extends AppCompatActivity {
    private Button btn_edit_admin, btn_logout_admin;
    private TextView tv_id_admin, tv_username_admin, tv_nama_admin, tv_alamat_admin, tv_status_admin;
    private ImageView img_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_profile);

        Intent get_admin = getIntent();
        int id_pegawai = get_admin.getIntExtra("id_pegawai", 0);
        String username = get_admin.getStringExtra("username");
        String password = get_admin.getStringExtra("password");
        int status = get_admin.getIntExtra("status", 0);
        String nama = get_admin.getStringExtra("nama");
        String alamat = get_admin.getStringExtra("alamat");
        int foto = get_admin.getIntExtra("foto", 0);


        btn_edit_admin = (Button)findViewById(R.id.btn_edit_admin);
        btn_logout_admin = (Button)findViewById(R.id.btn_logout_admin);

        tv_id_admin = (TextView)findViewById(R.id.tv_id_admin);
        tv_username_admin = (TextView)findViewById(R.id.tv_username_admin);
        tv_nama_admin = (TextView)findViewById(R.id.tv_nama_admin);
        tv_alamat_admin =(TextView)findViewById(R.id.tv_alamat_admin);
        tv_status_admin = (TextView)findViewById(R.id.tv_status_admin);

        img_admin = (ImageView)findViewById(R.id.circularImageView_admin);

        tv_id_admin.setText("" + id_pegawai);
        tv_username_admin.setText(username);
        tv_nama_admin.setText(nama);
        tv_alamat_admin.setText(alamat);
        img_admin.setImageResource(foto);
        if (status==1){
            tv_status_admin.setText("Aktif");
        }else{
            tv_status_admin.setText("Nonaktif");
        }

        btn_logout_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout_admin = new Intent(Admin_Profile.this, Login.class);
                logout_admin.putExtra("id_pegawai", id_pegawai);
                logout_admin.putExtra("username", username);
                logout_admin.putExtra("password", password);
                logout_admin.putExtra("status", status);
                logout_admin.putExtra("nama", nama);
                logout_admin.putExtra("alamat", alamat);
                logout_admin.putExtra("foto", foto);
                startActivity(logout_admin);
            }
        });

        btn_edit_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit_admin =  new Intent(Admin_Profile.this, Edit_Admin.class);
                edit_admin.putExtra("id_pegawai", id_pegawai);
                edit_admin.putExtra("username", username);
                edit_admin.putExtra("password", password);
                edit_admin.putExtra("status", status);
                edit_admin.putExtra("nama", nama);
                edit_admin.putExtra("alamat", alamat);
                edit_admin.putExtra("foto", foto);
                startActivity(edit_admin);

            }
        });

    }
}