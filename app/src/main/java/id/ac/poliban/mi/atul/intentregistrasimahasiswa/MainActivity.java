package id.ac.poliban.mi.atul.intentregistrasimahasiswa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 1000;
    private String str;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);assert data != null;

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data.getExtras() != null)
            str  = "NIM      : " + data.getStringExtra("nim")    + "\n";
            str += "Nama     : " + data.getStringExtra("nama")   + "\n";
            str += "Alamat   : " + data.getStringExtra("alamat") + "\n";
            str += "Telp     : " + data.getStringExtra("telp")   + "\n";
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btShowInput = findViewById(R.id.btShowInput);
        Button btShowMhs = findViewById(R.id.btShowMhs);

        btShowInput.setOnClickListener(v -> {
            Intent intent = new Intent(this, activity_data_mahasiswa.class);
            startActivityForResult(intent, REQUEST_CODE);
        });


        btShowMhs.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("info")
                    .setMessage(str)
                    .setPositiveButton("OK", null).show();
        });


    }

}
