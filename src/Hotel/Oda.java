package Hotel;

public class Oda {
    private String odaAdi;
    private int yatakSayisi;
    private boolean televizyon;
    private boolean minibar;
    private boolean oyunKonsolu;
    private int metrekare;
    private int stok;

    public Oda(String odaAdi, int yatakSayisi, boolean televizyon, boolean minibar, boolean oyunKonsolu, int metrekare) {
        this.odaAdi = odaAdi;
        this.yatakSayisi = yatakSayisi;
        this.televizyon = televizyon;
        this.minibar = minibar;
        this.oyunKonsolu = oyunKonsolu;
        this.metrekare = metrekare;
        this.stok = 0;
    }

    public void increaseStok(int quantity) {
        stok += quantity;
    }

    public void decreaseStok(int quantity) {
        stok -= quantity;
        if (stok < 0) {
            stok = 0;
        }
    }

    public String getOdaAdi() {
        return odaAdi;
    }

    public void setOdaAdi(String odaAdi) {
        this.odaAdi = odaAdi;
    }

    public int getYatakSayisi() {
        return yatakSayisi;
    }

    public void setYatakSayisi(int yatakSayisi) {
        this.yatakSayisi = yatakSayisi;
    }

    public boolean isTelevizyon() {
        return televizyon;
    }

    public void setTelevizyon(boolean televizyon) {
        this.televizyon = televizyon;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public boolean isOyunKonsolu() {
        return oyunKonsolu;
    }

    public void setOyunKonsolu(boolean oyunKonsolu) {
        this.oyunKonsolu = oyunKonsolu;
    }

    public int getMetrekare() {
        return metrekare;
    }

    public void setMetrekare(int metrekare) {
        this.metrekare = metrekare;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
