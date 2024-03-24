package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private EditText name,kodeBarang,jumlahBarang;
    private Button btnProses;
    private RadioButton rbGold,rbSilver,rbBiasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.etName);
        kodeBarang = findViewById(R.id.etKodeBarang);
        jumlahBarang = findViewById(R.id.etJumlahBarang);
        btnProses = findViewById(R.id.btnProses);
        rbGold = findViewById(R.id.rbGold);
        rbSilver = findViewById(R.id.rbSilver);
        rbBiasa = findViewById(R.id.rbBiasa);

        btnProses.setOnClickListener(click -> {

            if (kodeBarang.getText().toString().equals("LV3")){
                double jumlah = Double.parseDouble(jumlahBarang.getText().toString());
                String total = hitungTotalHarga(6666666, jumlah);
                String diskonHarga = cekJumlahBarangDiatas10(Double.parseDouble(total));
                String diskonMember = "";
                String jumlahBayar = "";
                String tipeMember = "";

                if (rbGold.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.1);
                    tipeMember = "Gold";
                } else if (rbSilver.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.05);
                    tipeMember = "Silver";
                } else if (rbBiasa.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.02);
                    tipeMember = "Biasa";
                }

                jumlahBayar = hitungJumlahBayar(Double.parseDouble(total), Double.parseDouble(diskonMember), Double.parseDouble(diskonHarga));

                Barang barang = new Barang();
                barang.setNama(name.getText().toString());
                barang.setNamaBarang("Lenovo V14 Gen 3");
                barang.setKodeBarang("LV3");
                barang.setHargaBarang("6.666.666");
                barang.setTotalHarga(total);
                barang.setDiskonHarga(diskonHarga);
                barang.setDiskonMember(diskonMember);
                barang.setJumlahBayar(jumlahBayar);
                barang.setTipeMember(tipeMember);

                Intent intent = new Intent(this, Detail.class);
                intent.putExtra(Detail.keyObj, barang);
                startActivity(intent);

            } else if (kodeBarang.getText().toString().equals("AAE")) {

                double jumlah = Double.parseDouble(jumlahBarang.getText().toString());
                String total = hitungTotalHarga(8676981, jumlah);
                String diskonHarga = cekJumlahBarangDiatas10(Double.parseDouble(total));
                String diskonMember = "";
                String jumlahBayar = "";
                String tipeMember = "";

                if (rbGold.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.1);
                    tipeMember = "Gold";
                } else if (rbSilver.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.05);
                    tipeMember = "Silver";
                } else if (rbBiasa.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.02);
                    tipeMember = "Biasa";
                }

                jumlahBayar = hitungJumlahBayar(Double.parseDouble(total), Double.parseDouble(diskonMember), Double.parseDouble(diskonHarga));

                Barang barang = new Barang();
                barang.setNama(name.getText().toString());
                barang.setNamaBarang("Acer Aspire E14");
                barang.setKodeBarang("AAE");
                barang.setHargaBarang("8.676.981");
                barang.setTotalHarga(total);
                barang.setDiskonHarga(diskonHarga);
                barang.setDiskonMember(diskonMember);
                barang.setJumlahBayar(jumlahBayar);
                barang.setTipeMember(tipeMember);

                Intent intent = new Intent(this, Detail.class);
                intent.putExtra(Detail.keyObj, barang);
                startActivity(intent);

            } else if (kodeBarang.getText().toString().equals("MP3")) {

                double jumlah = Double.parseDouble(jumlahBarang.getText().toString());
                String total = hitungTotalHarga(28999999, jumlah);
                String diskonHarga = cekJumlahBarangDiatas10(Double.parseDouble(total));
                String diskonMember = "";
                String jumlahBayar = "";
                String tipeMember = "";

                if (rbGold.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.1);
                    tipeMember = "Gold";
                } else if (rbSilver.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.05);
                    tipeMember = "Silver";
                } else if (rbBiasa.isChecked()) {
                    diskonMember = hitungDiskonMember(Double.parseDouble(total),0.02);
                    tipeMember = "Biasa";
                }

                jumlahBayar = hitungJumlahBayar(Double.parseDouble(total), Double.parseDouble(diskonMember), Double.parseDouble(diskonHarga));

                Barang barang = new Barang();
                barang.setNama(name.getText().toString());
                barang.setNamaBarang("Macbook Pro M3");
                barang.setKodeBarang("MP3");
                barang.setHargaBarang("28.999.999");
                barang.setTotalHarga(total);
                barang.setDiskonHarga(diskonHarga);
                barang.setDiskonMember(diskonMember);
                barang.setJumlahBayar(jumlahBayar);
                barang.setTipeMember(tipeMember);

                Intent intent = new Intent(this, Detail.class);
                intent.putExtra(Detail.keyObj, barang);
                startActivity(intent);
            }

        });
    }

    private String hitungTotalHarga(double harga, double jumlah){
        double totalHarga = harga * jumlah;
        return String.valueOf(totalHarga);
    }

    private String cekJumlahBarangDiatas10(Double total){
        String diskonHarga = "0";
        if(total > 10000000){
            diskonHarga = "100000";
            return diskonHarga;
        }
        return diskonHarga;
    }

    private String hitungDiskonMember(double total, double diskon){
        double hargaSetelahDiskon = total * (1 - diskon);
        double diskonMember = total - hargaSetelahDiskon;
        return String.valueOf(diskonMember);
    }

    private String hitungJumlahBayar(double total, double diskonMember, double diskon){
        double totalBayar = total - diskonMember - diskon;
        return String.valueOf(totalBayar);
    }

}