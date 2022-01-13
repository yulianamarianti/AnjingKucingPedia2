package com.example.anjingkucingpedia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anjingkucingpedia.model.Anjing;
import com.example.anjingkucingpedia.model.Ayam;
import com.example.anjingkucingpedia.model.Hewan;
import com.example.anjingkucingpedia.model.Kucing;

import java.util.List;

public class DaftarHewanActivity extends AppCompatActivity {
    public final static String HEWAN_TERPILIH ="hewan_obj_key";
    List<Hewan> hewans;
    ListView listView;
    String jenisHewan;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_hewan);
        Intent intent = getIntent();
        jenisHewan = intent.getStringExtra(MainActivity.JENIS_GALERY_KEY);
        TextView txjudul = findViewById(R.id.text_title_daftar);
        txjudul.setText("DAFTAR BERBAGAI RAS "+jenisHewan.toUpperCase());
        hewans = DataProvider.getHewansByTipe(this,jenisHewan);
        //judul
        TextView txJudul = findViewById(R.id.text_title_daftar);
        String judul="";
        if(hewans.get(0)instanceof Anjing){
            judul= getString(R.string.judul_list_Anjing);
        }else  if(hewans.get(0)instanceof Kucing){
            judul=getString(R.string.judul_list_Kucing);
        }else if(hewans.get(0)instanceof Ayam){
            judul=getString(R.string.judul_list_Ayam);
        }
        txJudul.setText(judul);
        setupListView();
    }
    private void setupListView(){
        listView = findViewById(R.id.listview_daftar_hewan);
        DaftarHewanAdapter adapter = new DaftarHewanAdapter(this,hewans);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }
    private AdapterView.OnItemClickListener onListClik =new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Hewan terpilih = hewans.get(position);
            bukaProfileHewan(terpilih);
        }
    };
    private void bukaProfileHewan(Hewan hewanTerpilih){
        Log.d("MAIN", "Buka activity galery");
        Intent intent = new Intent(this, ProfilActivity.class);
        intent.putExtra(HEWAN_TERPILIH, hewanTerpilih);
        startActivity(intent);
    }
}
