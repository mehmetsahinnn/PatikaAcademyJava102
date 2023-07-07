package RaceThreads;

import java.util.List;

public class OddThread implements Runnable {
    private final List<List<Integer>> chunks;
    private final List<Integer> oddNumbers;

    public OddThread(List<List<Integer>> chunks, List<Integer> oddNumbers) {
        this.chunks = chunks;
        this.oddNumbers = oddNumbers;
    }

    @Override
    public void run() {
        for (List<Integer> chunk : chunks) {
            for (int index : chunk) {
                if (index % 2 != 0) {
                    synchronized (oddNumbers) {
                        oddNumbers.add(index);
                    }
                }
            }
        }
    }
}
