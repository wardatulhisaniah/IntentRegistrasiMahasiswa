package id.ac.poliban.mi.atul.intentregistrasimahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class activity_data_mahasiswa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_mahasiswa);

        EditText etnim = findViewById(R.id.etNim);
        EditText etnama = findViewById(R.id.etNama);
        EditText etAlamat = findViewById(R.id.etAlamat);
        EditText ettelp = findViewById(R.id.etTelp);
        Button btSend = findViewById(R.id.btSend);

        btSend.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("nama", etnama.getText().toString());
            intent.putExtra("nim", etnim.getText().toString());
            intent.putExtra("alamat", etAlamat.getText().toString());
            intent.putExtra("telp", ettelp.getText().toString());
            setResult(RESULT_OK, intent);
            finish();

        });

        if(getSupportActionBar() != null)
            getSupportActionBar().setTitle("Input Data");
    }
}