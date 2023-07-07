package RaceThreads;

import java.util.ArrayList;
import java.util.List;

public class Main implements Runnable {
    private volatile int orderNo;
    private final Object LOCK = new Object();

    public Main() {
        this.orderNo = 0;
    }

    @Override
    public void run() {
        synchronized (LOCK) {
            this.orderNo = this.orderNo + 1;
            StringBuilder builder = new StringBuilder();
            builder.append(Thread.currentThread().getName());
            builder.append(" thread got ");
            builder.append(this.orderNo);
            builder.append(" from Qmatic!");
            System.out.println(builder.toString());
        }

    }

    static List<Integer> arrayList = new ArrayList<>();
    static List<Integer> odd = new ArrayList<>();
    static List<Integer> even = new ArrayList<>();


    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        int chunkSize = arrayList.size() / 4;
        List<List<Integer>> chunks = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i += chunkSize) {
            List<Integer> chunk = arrayList.subList(i, Math.min(i + chunkSize, arrayList.size()));
            chunks.add(chunk);
        }

        for (int i = 0; i < chunks.size(); i++) {
            System.out.println("Parça " + (i + 1) + " boyutu: " + chunks.get(i).size());
        }


        Thread[] threads = new Thread[2];


        OddThread oddThread = new OddThread(chunks, odd);
        threads[0] = new Thread(oddThread);


        EvenThread evenThread = new EvenThread(chunks, even);
        threads[1] = new Thread(evenThread);

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Çift Sayılar: " + even);
        System.out.println("Tek Sayılar: " + odd);
    }

}
