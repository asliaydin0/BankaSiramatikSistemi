package siramatik;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Banka {
    private Queue<Musteri> musteriKuyrugu = new LinkedList<>();
    private List<Gise> giseListesi = new ArrayList<>();

    public void musteriOlustur(int musteriSayisi) {
        Random random = new Random();
        for (int i = 1; i <= musteriSayisi; i++) {
            int islemSuresi = 1000 + random.nextInt(4000); // 1-5 saniye arası
            musteriKuyrugu.add(new Musteri(i, islemSuresi));
        }
    }

    public void giseBaslat(int giseSayisi) {
        for (int i = 1; i <= giseSayisi; i++) {
            Gise gise = new Gise(i, musteriKuyrugu);
            giseListesi.add(gise);
            gise.start(); // thread başlatılıyor
        }

        for (Gise gise : giseListesi) {
            try {
                gise.join(); // tüm gişelerin bitmesini bekle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Tüm işlemler tamamlandı.");
    }
}

