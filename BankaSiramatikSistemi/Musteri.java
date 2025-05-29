package siramatik;

public class Musteri {
    private int siraNumarasi;
    private int islemSuresi;

    public Musteri(int siraNumarasi, int islemSuresi) {
        this.siraNumarasi = siraNumarasi;
        this.islemSuresi = islemSuresi;
    }

    public int getSiraNumarasi() {
        return siraNumarasi;
    }

    public int getIslemSuresi() {
        return islemSuresi;
    }

    @Override
    public String toString() {
        return "Müşteri #" + siraNumarasi + " (İşlem süresi: " + islemSuresi + " ms)";
    }
}
