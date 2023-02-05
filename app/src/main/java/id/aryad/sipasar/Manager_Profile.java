package id.aryad.sipasar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Manager_Profile extends AppCompatActivity {
    private Button btn_edit_manager, btn_logout_manager;
    private TextView tv_id_manager, tv_username_manager, tv_nama_manager, tv_alamat_manager, tv_status_manager;
    private ImageView img_manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_profile);

        Intent get_manager = getIntent();
        int id_pegawai = get_manager.getIntExtra("id_pegawai", 0);
        String username = get_manager.getStringExtra("username");
        String password = get_manager.getStringExtra("password");
        int status = get_manager.getIntExtra("status", 0);
        String nama = get_manager.getStringExtra("nama");
        String alamat = get_manager.getStringExtra("alamat");
        int foto = get_manager.getIntExtra("foto", 0);



        tv_id_manager = (TextView) findViewById(R.id.tv_id_manager);
        tv_username_manager = (TextView) findViewById(R.id.tv_username_manager);
        tv_nama_manager = (TextView) findViewById(R.id.tv_nama_manager);
        tv_alamat_manager = (TextView) findViewById(R.id.tv_alamat_manager);
        tv_status_manager = (TextView) findViewById(R.id.tv_status_manager);

        btn_edit_manager = (Button)findViewById(R.id.btn_edit_manager);
        btn_logout_manager = (Button)findViewById(R.id.btn_logout_manager);

        img_manager = (ImageView)findViewById(R.id.circularImageView_manager);

        tv_id_manager.setText(""+id_pegawai);
        tv_username_manager.setText(username);
        tv_nama_manager.setText(nama);
        tv_alamat_manager.setText(alamat);
        if (status==1){
            tv_status_manager.setText("Aktif");
        }else{
            tv_status_manager.setText("Nonaktif");
        }

        img_manager.setImageResource(foto);

        btn_logout_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout_manager = new Intent(Manager_Profile.this, Login.class);
                logout_manager.putExtra("id_pegawai", id_pegawai);
                logout_manager.putExtra("username", username);
                logout_manager.putExtra("password", password);
                logout_manager.putExtra("status", status);
                logout_manager.putExtra("nama", nama);
                logout_manager.putExtra("alamat", alamat);
                logout_manager.putExtra("foto", foto);
                startActivity(logout_manager);
            }
        });

        btn_edit_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit_manager = new Intent(Manager_Profile.this, Edit_Manager.class);
                edit_manager.putExtra("id_pegawai", id_pegawai);
                edit_manager.putExtra("username", username);
                edit_manager.putExtra("password", password);
                edit_manager.putExtra("status", status);
                edit_manager.putExtra("nama", nama);
                edit_manager.putExtra("alamat", alamat);
                edit_manager.putExtra("foto", foto);
                startActivity(edit_manager);
            }
        });



    }
}