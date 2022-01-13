package com.example.anjingkucingpedia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anjingkucingpedia.model.Anjing;
import com.example.anjingkucingpedia.model.Ayam;
import com.example.anjingkucingpedia.model.Hewan;
import com.example.anjingkucingpedia.model.Kucing;

public class ProfilActivity extends AppCompatActivity {
    Hewan hewan;
    TextView txJudul, txJenis, txAsal, txDeskripsi;
    ImageView ivFotoHewan;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_ras);
        Intent intent = getIntent();
        hewan = (Hewan) intent.getSerializableExtra(DaftarHewanActivity.HEWAN_TERPILIH);
        inisialisasiView();
        tampilkanProfil(hewan);
    }
    private void inisialisasiView() {
        txJudul = findViewById(R.id.txJudul);
        txJenis = findViewById(R.id.txJenis);
        txAsal = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoHewan = findViewById(R.id.gambarHewan);

    }
    private void tampilkanProfil(Hewan hewan) {
        Log.d("Profil", "Menampilkan" + hewan.getJenis());
        if(hewan instanceof Anjing){
            txJudul.setText(getString(R.string.jenis_Anjing));
        }else if(hewan instanceof Ayam){
            txJudul.setText(getString(R.string.jenis_Ayam));
        }else if (hewan instanceof Kucing){
            txJudul.setText(getString(R.string.jenis_Kucing));
        }
        txJenis.setText(hewan.getRas());
        txAsal.setText(hewan.getAsal());
        txDeskripsi.setText(hewan.getDeskripsi());
        ivFotoHewan.setImageDrawable(this.getDrawable(hewan.getDrawableRes()));
    }
}

