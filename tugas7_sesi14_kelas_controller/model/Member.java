package model;

public class Member {
    private String nama;
    private String jenisKelamin;
    private String nomorHP;
    private String alamatRumah;

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setNomorHP(String nomorHP) {
        this.nomorHP = nomorHP;
    }

    public String getNomorHP() {
        return nomorHP;
    }

    public void setAlamatRumah(String alamatRumah) {
        this.alamatRumah = alamatRumah;
    }

    public String getAlamatRumah() {
        return alamatRumah;
    }
}