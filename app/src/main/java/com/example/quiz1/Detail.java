package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Detail extends AppCompatActivity {

    public static final String keyObj = "KEY_OBJ";
    private TextView selamat,tipeMember,kodeBarang,namaBarang,hargaBarang,totalHarga,diskonHarga,diskonMember,jumlahBayar;
    private String selamat1,tipeMember1,kodeBarang1,namaBarang1,hargaBarang1,totalHarga1,diskonHarga1,diskonMember1,jumlahBayar1;
    private Button btnShare;
    @SuppressLint("StringFormatInvalid")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DecimalFormat formatter = new DecimalFormat("#,###.##");

        selamat = findViewById(R.id.tvSelamat);
        tipeMember = findViewById(R.id.tvTipeMember);
        kodeBarang = findViewById(R.id.tvKodeBarang);
        namaBarang = findViewById(R.id.tvNamaBarang);
        hargaBarang = findViewById(R.id.tvHargaBarang);
        totalHarga = findViewById(R.id.tvTotalHarga);
        diskonHarga = findViewById(R.id.tvDiskonHarga);
        diskonMember = findViewById(R.id.tvDiskonMember);
        jumlahBayar = findViewById(R.id.tvJumlahBayar);
        btnShare = findViewById(R.id.btnShare);

        Barang barang;
        if (Build.VERSION.SDK_INT > 33){
            barang = getIntent().getParcelableExtra(keyObj, Barang.class);
        }else {
            barang = getIntent().getParcelableExtra(keyObj);
        }

        selamat1 = getString(R.string.selamat, barang.getNama());
        tipeMember1 = getString(R.string.tipe_member, barang.getTipeMember());
        kodeBarang1 = getString(R.string.kode_barang1, barang.getKodeBarang());
        namaBarang1 = getString(R.string.nama_barang, barang.getNamaBarang());
        hargaBarang1 = getString(R.string.harga, barang.getHargaBarang());
        totalHarga1 = getString(R.string.total_harga, formatter.format(Double.parseDouble(barang.getTotalHarga())));
        diskonHarga1 = getString(R.string.harga_diskon, formatter.format(Double.parseDouble(barang.getDiskonHarga())));
        diskonMember1 = getString(R.string.member_diskon, formatter.format(Double.parseDouble(barang.getDiskonMember())));
        jumlahBayar1 = getString(R.string.jumlah_bayar, formatter.format(Double.parseDouble(barang.getJumlahBayar())));

        selamat.setText(selamat1);
        tipeMember.setText(tipeMember1);
        kodeBarang.setText(kodeBarang1);
        namaBarang.setText(namaBarang1);
        hargaBarang.setText(hargaBarang1);
        totalHarga.setText(totalHarga1);
        diskonHarga.setText(diskonHarga1);
        diskonMember.setText(diskonMember1);
        jumlahBayar.setText(jumlahBayar1);

        btnShare.setOnClickListener(click -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String shareMessage = "Nama :" + barang.getNama() +
                                  "\nTipe Member: "+ barang.getTipeMember() +
                                "\nKode Barang: " + barang.getKodeBarang() +
                                "\nNama Barang: " + barang.getNamaBarang() +
                                "\nHarga Barang: " + barang.getHargaBarang() +
                                "\nTotal Harga: " + formatter.format(Double.parseDouble(barang.getTotalHarga())) +
                                "\nDiskon Harga: " + formatter.format(Double.parseDouble(barang.getDiskonHarga()))+
                                "\nDiskon Member: " + formatter.format(Double.parseDouble(barang.getDiskonMember())) +
                                "\nJumlah Bayar: " + formatter.format(Double.parseDouble(barang.getJumlahBayar()));
            intent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(intent, "Bagikan melalui"));
        });
    }
}