package RaceThreads;

import java.util.List;

public class EvenThread implements Runnable {
    private final List<List<Integer>> chunks;
    private final List<Integer> evenNumbers;

    public EvenThread(List<List<Integer>> chunks, List<Integer> evenNumbers) {
        this.chunks = chunks;
        this.evenNumbers = evenNumbers;
    }

    @Override
    public void run() {
        for (List<Integer> chunk : chunks) {
            for (int index : chunk) {
                if (index % 2 == 0) {
                    synchronized (evenNumbers) {
                        evenNumbers.add(index);
                    }
                }
            }
        }
    }
}
