package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Detail extends AppCompatActivity {

    public static final String keyObj = "KEY_OBJ";
    private TextView selamat,tipeMember,kodeBarang,namaBarang,hargaBarang,totalHarga,diskonHarga,diskonMember,jumlahBayar;
    private Button btnShare;
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

        selamat.setText("Selamat Datang " + barang.getNama());
        tipeMember.setText("Tipe Member " + barang.getTipeMember());
        kodeBarang.setText("Kode Barang " + barang.getKodeBarang());
        namaBarang.setText("Nama Barang " + barang.getNamaBarang());
        hargaBarang.setText("Harga Barang Rp" + barang.getHargaBarang());
        totalHarga.setText("Total Harga Barang Rp" + formatter.format(Double.parseDouble(barang.getTotalHarga())));
        diskonHarga.setText("Diskon Harga Rp" + formatter.format(Double.parseDouble(barang.getDiskonHarga())));
        diskonMember.setText("Diskon Member Rp" + formatter.format(Double.parseDouble(barang.getDiskonMember())));
        jumlahBayar.setText("Jumlah Bayar Rp" + formatter.format(Double.parseDouble(barang.getJumlahBayar())));

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