package siramatik;

import java.util.Queue;

public class Gise extends Thread {
    private int giseNumarasi;
    private Queue<Musteri> musteriKuyrugu;

    public Gise(int giseNumarasi, Queue<Musteri> musteriKuyrugu) {
        this.giseNumarasi = giseNumarasi;
        this.musteriKuyrugu = musteriKuyrugu;
    }

    @Override
    public void run() {
        while (true) {
            Musteri musteri;
            synchronized (musteriKuyrugu) {   //aynı anda sadece bir thread’in kuyruğa erişmesini sağlıyoruz (senkronizasyon).
                if (musteriKuyrugu.isEmpty()) break;
                musteri = musteriKuyrugu.poll();  // sıradaki müşteriyi al
            }

            System.out.println("Gişe #" + giseNumarasi + " --> " + musteri + " işlemi başladı.");
            try {
                Thread.sleep(musteri.getIslemSuresi()); // işlem süresi kadar bekle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Gişe #" + giseNumarasi + " --> " + musteri + " işlemi tamamlandı.");
        }
    }
}
