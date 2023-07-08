package Hotel;

import java.util.ArrayList;
import java.util.List;

public class Otel {
    private String otelAdi;
    private String adres;
    private String eposta;
    private String telefon;
    private int yildiz;
    private List<String> tesisOzellikleri;
    private List<String> pansiyonTipleri;

    public Otel(String otelAdi, String adres, String eposta, String telefon, int yildiz) {
        this.otelAdi = otelAdi;
        this.adres = adres;
        this.eposta = eposta;
        this.telefon = telefon;
        this.yildiz = yildiz;
        this.tesisOzellikleri = new ArrayList<>();
        this.pansiyonTipleri = new ArrayList<>();
    }

    public void addTesisOzelligi(String ozellik) {
        tesisOzellikleri.add(ozellik);
    }

    public void addPansiyonTipi(String tip) {
        pansiyonTipleri.add(tip);
    }

    public String getOtelAdi() {
        return otelAdi;
    }

    public void setOtelAdi(String otelAdi) {
        this.otelAdi = otelAdi;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getYildiz() {
        return yildiz;
    }

    public void setYildiz(int yildiz) {
        this.yildiz = yildiz;
    }

    public List<String> getTesisOzellikleri() {
        return tesisOzellikleri;
    }

    public void setTesisOzellikleri(List<String> tesisOzellikleri) {
        this.tesisOzellikleri = tesisOzellikleri;
    }

    public List<String> getPansiyonTipleri() {
        return pansiyonTipleri;
    }

    public void setPansiyonTipleri(List<String> pansiyonTipleri) {
        this.pansiyonTipleri = pansiyonTipleri;
    }
}