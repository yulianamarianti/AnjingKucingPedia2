package com.example.anjingkucingpedia;

import android.content.Context;

import com.example.anjingkucingpedia.model.Hewan;
import com.example.anjingkucingpedia.model.Kucing;
import com.example.anjingkucingpedia.model.Anjing;
import com.example.anjingkucingpedia.model.Ayam;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private static List<Hewan> hewans = new ArrayList<>();

    private static List<Anjing> initDataAnjing(Context ctx) {
        List<Anjing> anjings = new ArrayList<>();
        anjings.add(new Anjing(ctx.getString(R.string.bulldog_nama), ctx.getString(R.string.bulldog_asal),
                ctx.getString(R.string.buldog_deskrrripsi), R.drawable.dog_bulldog));
        anjings.add(new Anjing(ctx.getString(R.string.Husky_nama), ctx.getString(R.string.Husky_asal),
                ctx.getString(R.string.Husky_deskripsi), R.drawable.dog_husky));
        anjings.add(new Anjing(ctx.getString(R.string.Kintamani_nama), ctx.getString(R.string.Kintamani_asal),
                ctx.getString(R.string.Kintamani_deskripsi), R.drawable.dog_kintamani));
        anjings.add(new Anjing(ctx.getString(R.string.Samoyed_nama), ctx.getString(R.string.Samoyed_asal),
                ctx.getString(R.string.Samoyed_deskripsi), R.drawable.dog_samoyed));
        anjings.add(new Anjing(ctx.getString(R.string.Shepherd_nama), ctx.getString(R.string.Shepherd_asal),
                ctx.getString(R.string.Shepherd_deskripsi), R.drawable.dog_shepherd));
        anjings.add(new Anjing(ctx.getString(R.string.Shiba_nama), ctx.getString(R.string.Shiba_asal),
                ctx.getString(R.string.Shiba_deskripsi), R.drawable.dog_shiba));
        return anjings;
    }

    private static List<Ayam> initDataAyam(Context ctx) {
        List<Ayam> ayams = new ArrayList<>();
        ayams.add(new Ayam(ctx.getString(R.string.Kalkun_nama), ctx.getString(R.string.Kalkun_asal),
                ctx.getString(R.string.Kalkun_deskripsi), R.drawable.img_20211111_wa0046));
        ayams.add(new Ayam(ctx.getString(R.string.Katek_nama), ctx.getString(R.string.Katek_asal),
                ctx.getString(R.string.Katek_deskripsi), R.drawable.img_20211111_wa0047));
        ayams.add(new Ayam(ctx.getString(R.string.Cemani_nama), ctx.getString(R.string.Cemani_asal),
                ctx.getString(R.string.Cemani_deskripsi), R.drawable.img_20211111_wa0048));
        return ayams;
    }

    private static List<Kucing> initDataKucing(Context ctx) {
        List<Kucing> kucings = new ArrayList<>();
        kucings.add(new Kucing(ctx.getString(R.string.Angora_nama), ctx.getString(R.string.Angora_asal),
                ctx.getString(R.string.Angora_deskripsi), R.drawable.cat_angora));
        kucings.add(new Kucing(ctx.getString(R.string.Bengal_nama), ctx.getString(R.string.Bengal_asal),
                ctx.getString(R.string.Bengal_deskripsi), R.drawable.cat_bengal));
        kucings.add(new Kucing(ctx.getString(R.string.Birmani_nama), ctx.getString(R.string.Birmani_asal),
                ctx.getString(R.string.Birmani_deskripsi), R.drawable.cat_birman));
        kucings.add(new Kucing(ctx.getString(R.string.Persia_nama), ctx.getString(R.string.Persia_asal),
                ctx.getString(R.string.Persia_deskripsi), R.drawable.cat_persia));
        kucings.add(new Kucing(ctx.getString(R.string.Siam_nama), ctx.getString(R.string.Siam_asal),
                ctx.getString(R.string.Siam_deskripsi), R.drawable.cat_siam));
        kucings.add(new Kucing(ctx.getString(R.string.Siberia_nama), ctx.getString(R.string.Siberia_asal),
                ctx.getString(R.string.Sibersia_deskripsi), R.drawable.cat_siberian));
        return kucings;
    }

    private static void initAllHewans(Context ctx) {
        hewans.addAll(initDataKucing(ctx));
        hewans.addAll(initDataAnjing(ctx));
        hewans.addAll(initDataAyam(ctx));
    }

    public static List<Hewan> getHewansByTipe(Context ctx, String jenis) {
        List<Hewan> hewansByTipe = new ArrayList<>();
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        for (Hewan h : hewans) {
            if (h.getJenis().equals(jenis)) {
                hewansByTipe.add(h);
            }
        }
        return hewansByTipe;
    }
}

