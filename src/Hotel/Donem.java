package Hotel;

import java.time.LocalDate;

public class Donem {
    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;

    public Donem(LocalDate baslangicTarihi, LocalDate bitisTarihi) {
        this.baslangicTarihi = baslangicTarihi;
        this.bitisTarihi = bitisTarihi;
    }

    public LocalDate getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(LocalDate baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public LocalDate getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(LocalDate bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }
}
