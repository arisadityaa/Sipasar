package id.aryad.sipasar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Edit_Manager extends AppCompatActivity {
    private EditText edit_nama_manager, edit_alamat_manager, edit_password_manager, edit_ulang_password_manager;
    private ImageView img_edit_manager;
    private Button btn_update_manager, btn_cancel_manager, btn_ganti_gambar_manager;
    private int SELECT_IMAGE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_manager);

        edit_nama_manager = (EditText) findViewById(R.id.edit_nama_manager);
        edit_alamat_manager = (EditText) findViewById(R.id.edit_alamat_manager);
        edit_password_manager = (EditText)findViewById(R.id.edit_password_manager);
        edit_ulang_password_manager = (EditText)findViewById(R.id.edit_ulang_password_manager);

        img_edit_manager = (ImageView)findViewById(R.id.img_edit_manager);

        btn_update_manager = (Button)findViewById(R.id.btn_update_manager);
        btn_cancel_manager = (Button)findViewById(R.id.btn_cancel_manager);
        btn_ganti_gambar_manager =(Button)findViewById(R.id.btn_ganti_gambar_manager);

        Intent get_edit_manager = getIntent();
        int id_pegawai = get_edit_manager.getIntExtra("id_pegawai", 0);
        String username = get_edit_manager.getStringExtra("username");
        String password = get_edit_manager.getStringExtra("password");
        int status = get_edit_manager.getIntExtra("status", 0);
        String nama = get_edit_manager.getStringExtra("nama");
        String alamat = get_edit_manager.getStringExtra("alamat");
        int foto = get_edit_manager.getIntExtra("foto", 0);

        edit_nama_manager.setText(nama);
        edit_alamat_manager.setText(alamat);
        img_edit_manager.setImageResource(foto);
        edit_password_manager.setText(password);
        edit_ulang_password_manager.setText(password);


        btn_update_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama_manager = edit_nama_manager.getText().toString();
                String alamat_manager = edit_alamat_manager.getText().toString();
                String password_manager = edit_password_manager.getText().toString();
                String password_ulang_manager = edit_ulang_password_manager.getText().toString();

                if (password_manager.equals(password_ulang_manager)){
                    Intent update_manager = new Intent(Edit_Manager.this, Manager_Profile.class);
                    update_manager.putExtra("nama", nama_manager);
                    update_manager.putExtra("alamat", alamat_manager);
                    update_manager.putExtra("password", password_manager);
                    update_manager.putExtra("id_pegawai", id_pegawai);
                    update_manager.putExtra("username", username);
                    update_manager.putExtra("status", status);
                    update_manager.putExtra("foto", foto);
                    startActivity(update_manager);
                    Toast.makeText(getApplicationContext(), "Profil Berhasil Diedit", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Isi Password Dengan Benar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_cancel_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kembali_manager = new Intent(Edit_Manager.this, Manager_Profile.class);
                kembali_manager.putExtra("id_pegawai", id_pegawai);
                kembali_manager.putExtra("username", username);
                kembali_manager.putExtra("password", password);
                kembali_manager.putExtra("status", status);
                kembali_manager.putExtra("nama", nama);
                kembali_manager.putExtra("alamat", alamat);
                kembali_manager.putExtra("foto", foto);


                startActivity(kembali_manager);
            }
        });

        btn_ganti_gambar_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pick_image = new Intent();
                pick_image.setType("image/*");
                pick_image.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult (Intent.createChooser(pick_image, "Title"), SELECT_IMAGE_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            Uri uri=data.getData();
            img_edit_manager.setImageURI(uri);
        }
    }
}