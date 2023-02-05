package id.aryad.sipasar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static id.aryad.sipasar.R.id.img_edit_admin;


public class Edit_Admin extends AppCompatActivity {
    private EditText edit_nama_admin, edit_alamat_admin, edit_password_admin, edit_ulang_password_admin;
    private ImageView img_edit_admin;
    private Button btn_update_admin, btn_cancel_admin, btn_ganti_gambar_admin;
    private int SELECT_IMAGE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_admin);

        edit_nama_admin = (EditText)findViewById(R.id.edit_nama_admin);
        edit_alamat_admin = (EditText)findViewById(R.id.edit_alamat_admin);
        edit_password_admin = (EditText)findViewById(R.id.edit_password_admin);
        edit_ulang_password_admin = (EditText)findViewById(R.id.edit_ulang_password_admin);
        img_edit_admin = (ImageView)findViewById(R.id.img_edit_admin);

        btn_update_admin = (Button)findViewById(R.id.btn_update_admin);
        btn_cancel_admin = (Button)findViewById(R.id.btn_cancel_admin);
        btn_ganti_gambar_admin = (Button)findViewById(R.id.btn_ganti_gambar_admin);

        Intent get_edit_admin = getIntent();
        int id_pegawai = get_edit_admin.getIntExtra("id_pegawai", 0);
        String username = get_edit_admin.getStringExtra("username");
        String password = get_edit_admin.getStringExtra("password");
        int status = get_edit_admin.getIntExtra("status", 0);
        String nama = get_edit_admin.getStringExtra("nama");
        String alamat = get_edit_admin.getStringExtra("alamat");
        int foto = get_edit_admin.getIntExtra("foto", 0);

        edit_nama_admin.setText(nama);
        edit_alamat_admin.setText(alamat);
        edit_password_admin.setText(password);
        edit_ulang_password_admin.setText(password);
        img_edit_admin.setImageResource(foto);

        btn_update_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama_admin = edit_nama_admin.getText().toString();
                String alamat_admin = edit_alamat_admin.getText().toString();
                String password_admin = edit_password_admin.getText().toString();
                String ulang_password_admin = edit_ulang_password_admin.getText().toString();

                if (password_admin.equals(ulang_password_admin)){
                    Intent update_admin = new Intent(Edit_Admin.this, Admin_Profile.class);
                    update_admin.putExtra("nama", nama_admin);
                    update_admin.putExtra("alamat", alamat_admin);
                    update_admin.putExtra("password", password_admin);
                    update_admin.putExtra("id_pegawai", id_pegawai);
                    update_admin.putExtra("username", username);
                    update_admin.putExtra("status", status);
                    update_admin.putExtra("foto", foto);
                    startActivity(update_admin);
                    Toast.makeText(getApplicationContext(), "Profil Berhasil Diedit", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Isi Password Dengan Benar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_cancel_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kembali_admin = new Intent(Edit_Admin.this, Admin_Profile.class);
                kembali_admin.putExtra("id_pegawai", id_pegawai);
                kembali_admin.putExtra("username", username);
                kembali_admin.putExtra("password", password);
                kembali_admin.putExtra("status", status);
                kembali_admin.putExtra("nama", nama);
                kembali_admin.putExtra("alamat", alamat);
                kembali_admin.putExtra("foto", foto);
                startActivity(kembali_admin);
            }
        });

        btn_ganti_gambar_admin.setOnClickListener(new View.OnClickListener() {
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
            img_edit_admin.setImageURI(uri);
        }
    }
}