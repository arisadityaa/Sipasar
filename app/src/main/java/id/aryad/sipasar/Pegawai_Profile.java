package id.aryad.sipasar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Pegawai_Profile extends AppCompatActivity {
    private Button btn_edit_pegawai, btn_logout_pegawai;
    private TextView tv_id_pegawai, tv_username_pegawai, tv_nama_pegawai, tv_alamat_pegawai, tv_status_pegawai;
    private ImageView img_pegawai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pegawai_profile);

        Intent get_pegawai = getIntent();
        int id_pegawai = get_pegawai.getIntExtra("id_pegawai", 0);
        String username = get_pegawai.getStringExtra("username");
        String password = get_pegawai.getStringExtra("password");
        int status = get_pegawai.getIntExtra("status", 0);
        String nama = get_pegawai.getStringExtra("nama");
        String alamat = get_pegawai.getStringExtra("alamat");
        int foto = get_pegawai.getIntExtra("foto", 0);


        tv_id_pegawai = (TextView) findViewById(R.id.tv_id_pegawai);
        tv_username_pegawai = (TextView) findViewById(R.id.tv_username_pegawai);
        tv_nama_pegawai = (TextView) findViewById(R.id.tv_nama_pegawai);
        tv_alamat_pegawai = (TextView) findViewById(R.id.tv_alamat_pegawai);
        tv_status_pegawai = (TextView) findViewById(R.id.tv_status_pegawai);

        btn_edit_pegawai = (Button)findViewById(R.id.btn_edit_pegawai);
        btn_logout_pegawai = (Button)findViewById(R.id.btn_logout_pegawai);

        img_pegawai = (ImageView)findViewById(R.id.circularImageView_pegawai);

        tv_id_pegawai.setText(""+id_pegawai);
        tv_username_pegawai.setText(username);
        tv_nama_pegawai.setText(nama);
        tv_alamat_pegawai.setText(alamat);

        if (status==1){
            tv_status_pegawai.setText("Aktif");
        }else{
            tv_status_pegawai.setText("Nonaktif");
        }

        img_pegawai.setImageResource(foto);



        btn_logout_pegawai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout_pegawai = new Intent(Pegawai_Profile.this, Login.class);
                logout_pegawai.putExtra("id_pegawai", id_pegawai);
                logout_pegawai.putExtra("username", username);
                logout_pegawai.putExtra("password", password);
                logout_pegawai.putExtra("status", status);
                logout_pegawai.putExtra("nama", nama);
                logout_pegawai.putExtra("alamat", alamat);
                logout_pegawai.putExtra("foto", foto);
                startActivity(logout_pegawai);
            }
        });

        btn_edit_pegawai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit_pegawai = new Intent(Pegawai_Profile.this, Edit_Manager.class);
                edit_pegawai.putExtra("id_pegawai", id_pegawai);
                edit_pegawai.putExtra("username", username);
                edit_pegawai.putExtra("password", password);
                edit_pegawai.putExtra("status", status);
                edit_pegawai.putExtra("nama", nama);
                edit_pegawai.putExtra("alamat", alamat);
                edit_pegawai.putExtra("foto", foto);
                startActivity(edit_pegawai);
            }
        });


    }
}