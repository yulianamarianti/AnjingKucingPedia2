package com.example.anjingkucingpedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnKucing,btnAnjing,btnAyam;
    Button btnBiodata;
    public static final String JENIS_GALERY_KEY = "JENIS_GALERY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();
    }

    private void inisialisasiView() {
        btnKucing = findViewById(R.id.btn_buka_ras_kucing);
        btnAnjing = findViewById(R.id.btn_buka_ras_anjing);
        btnAyam = findViewById(R.id.btn_ras_ayam);
        btnBiodata = findViewById(R.id.btn_Biodata);
        btnKucing.setOnClickListener(view -> bukaGalery("Kucing"));
        btnAnjing.setOnClickListener(view -> bukaGalery("Anjing"));
        btnAyam.setOnClickListener(view -> bukaGalery("Ayam"));
        btnBiodata.setOnClickListener(view -> bukaBiodataActivity());
    }
    private void bukaGalery(String jenisHewan){
        Log.d("MAIN", "Buka activity galery");
        Intent intent = new Intent( this, DaftarHewanActivity.class);
        intent.putExtra(JENIS_GALERY_KEY, jenisHewan);
        startActivity(intent);
    }
    private void bukaBiodataActivity(){
        Log.d("MAIN","Buka Activity Biodata");
        Intent intent = new Intent(this, BiodataActivity.class);
        startActivity(intent);
    }

}