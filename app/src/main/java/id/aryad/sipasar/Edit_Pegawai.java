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
import android.widget.Toast;

public class Edit_Pegawai extends AppCompatActivity {

    private EditText edit_nama_pegawai, edit_alamat_pegawai, edit_password_pegawai, edit_ulang_password_pegawai;
    private ImageView img_edit_pegawai;
    private Button btn_update_pegawai, btn_cancel_pegawai, btn_ganti_gambar_pegawai;
    private int SELECT_IMAGE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_pegawai);

        edit_nama_pegawai = (EditText) findViewById(R.id.edit_nama_pegawai);
        edit_alamat_pegawai = (EditText) findViewById(R.id.edit_alamat_pegawai);
        edit_password_pegawai = (EditText)findViewById(R.id.edit_password_pegawai);
        edit_ulang_password_pegawai = (EditText)findViewById(R.id.edit_ulang_password_pegawai);

        img_edit_pegawai = (ImageView)findViewById(R.id.img_edit_pegawai);

        btn_update_pegawai = (Button)findViewById(R.id.btn_update_pegawai);
        btn_cancel_pegawai = (Button)findViewById(R.id.btn_cancel_pegawai);
        btn_ganti_gambar_pegawai =(Button)findViewById(R.id.btn_ganti_gambar_pegawai);

        Intent get_edit_pegawai = getIntent();
        int id_pegawai = get_edit_pegawai.getIntExtra("id_pegawai", 0);
        String username = get_edit_pegawai.getStringExtra("username");
        String password = get_edit_pegawai.getStringExtra("password");
        int status = get_edit_pegawai.getIntExtra("status", 0);
        String nama = get_edit_pegawai.getStringExtra("nama");
        String alamat = get_edit_pegawai.getStringExtra("alamat");
        int foto = get_edit_pegawai.getIntExtra("foto", 0);

        edit_nama_pegawai.setText(nama);
        edit_alamat_pegawai.setText(alamat);
        img_edit_pegawai.setImageResource(foto);
        edit_password_pegawai.setText(password);
        edit_ulang_password_pegawai.setText(password);

        btn_update_pegawai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama_pegawai = edit_nama_pegawai.getText().toString();
                String alamat_pegawai = edit_alamat_pegawai.getText().toString();
                String password_pegawai = edit_password_pegawai.getText().toString();
                String password_ulang_pegawai = edit_ulang_password_pegawai.getText().toString();

                if (password_pegawai.equals(password_ulang_pegawai)){
                    Intent update_pegawai = new Intent(Edit_Pegawai.this, Manager_Profile.class);
                    update_pegawai.putExtra("nama", nama_pegawai);
                    update_pegawai.putExtra("alamat", alamat_pegawai);
                    update_pegawai.putExtra("password", password_pegawai);

                    update_pegawai.putExtra("id_pegawai", id_pegawai);
                    update_pegawai.putExtra("username", username);
                    update_pegawai.putExtra("status", status);
                    update_pegawai.putExtra("foto", foto);
                    startActivity(update_pegawai);
                    Toast.makeText(getApplicationContext(), "Profil Berhasil Diedit", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Isi Password Dengan Benar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_cancel_pegawai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kembali_pegawai = new Intent(Edit_Pegawai.this, Manager_Profile.class);
                kembali_pegawai.putExtra("id_pegawai", id_pegawai);
                kembali_pegawai.putExtra("username", username);
                kembali_pegawai.putExtra("password", password);
                kembali_pegawai.putExtra("status", status);
                kembali_pegawai.putExtra("nama", nama);
                kembali_pegawai.putExtra("alamat", alamat);
                kembali_pegawai.putExtra("foto", foto);
                startActivity(kembali_pegawai);
            }
        });

        btn_ganti_gambar_pegawai.setOnClickListener(new View.OnClickListener() {
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
            img_edit_pegawai.setImageURI(uri);
        }
    }
}