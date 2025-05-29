package siramatik;

public class Main {
    public static void main(String[] args) {
        Banka banka = new Banka();
        banka.musteriOlustur(10); // 10 müşteri oluştur
        banka.giseBaslat(3);      // 3 gişe çalışsın
    }
}
