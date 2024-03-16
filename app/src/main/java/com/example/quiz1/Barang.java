package com.example.quiz1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Barang implements Parcelable {

    private String  nama,kodeBarang,namaBarang,hargaBarang,totalHarga,diskonHarga,diskonMember,jumlahBayar,tipeMember;

    public Barang() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(String hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getDiskonHarga() {
        return diskonHarga;
    }

    public void setDiskonHarga(String diskonHarga) {
        this.diskonHarga = diskonHarga;
    }

    public String getDiskonMember() {
        return diskonMember;
    }

    public void setDiskonMember(String diskonMember) {
        this.diskonMember = diskonMember;
    }

    public String getJumlahBayar() {
        return jumlahBayar;
    }

    public void setJumlahBayar(String jumlahBayar) {
        this.jumlahBayar = jumlahBayar;
    }

    protected Barang(Parcel in) {
        nama = in.readString();
        kodeBarang = in.readString();
        namaBarang = in.readString();
        hargaBarang = in.readString();
        totalHarga = in.readString();
        diskonHarga = in.readString();
        diskonMember = in.readString();
        jumlahBayar = in.readString();
        tipeMember = in.readString();
    }

    public static final Creator<Barang> CREATOR = new Creator<Barang>() {
        @Override
        public Barang createFromParcel(Parcel in) {
            return new Barang(in);
        }

        @Override
        public Barang[] newArray(int size) {
            return new Barang[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getTipeMember() {
        return tipeMember;
    }

    public void setTipeMember(String tipeMember) {
        this.tipeMember = tipeMember;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(kodeBarang);
        dest.writeString(namaBarang);
        dest.writeString(hargaBarang);
        dest.writeString(totalHarga);
        dest.writeString(diskonHarga);
        dest.writeString(diskonMember);
        dest.writeString(jumlahBayar);
        dest.writeString(tipeMember);
    }
}
