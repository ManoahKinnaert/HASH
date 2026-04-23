package experiments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import core.HashTableProbed;

public class Hash1 {
	public void conduct() {
		int tableSize = 100000;
        int searchesPerAlpha = 20000;

        Random random = new Random();

        System.out.println("alpha,measuredHit,theoreticalHit,measuredMiss,theoreticalMiss");

        for (double alpha = 0.10; alpha <= 0.95; alpha += 0.05) {

            HashTableProbed<Integer, Integer> table = new HashTableProbed<>(tableSize);

            HashSet<Integer> inserted = new HashSet<>();
            ArrayList<Integer> insertedList = new ArrayList<>();

            int targetSize = (int) (alpha * tableSize);

            // Fill in table upto 
            while (table.size() < targetSize) {

                int value = random.nextInt(Integer.MAX_VALUE);

                if (!inserted.contains(value)) {
                    inserted.add(value);
                    insertedList.add(value);
                    table.put(value, value);
                }
            }

			// Measure hits
            long totalHitProbes = 0;

            for (int i = 0; i < searchesPerAlpha; i++) {

                int key = insertedList.get(random.nextInt(insertedList.size()));

                totalHitProbes += table.getProbesForSearch(key);
            }

            double measuredHit = (double) totalHitProbes / searchesPerAlpha;

			// Measure misses
			long totalMissProbes = 0;
            int missesDone = 0;

            while (missesDone < searchesPerAlpha) {

                int key = random.nextInt(Integer.MAX_VALUE);

                if (!inserted.contains(key)) {

                    totalMissProbes += table.getProbesForSearch(key);
                    missesDone++;
                }
            }

            double measuredMiss = (double) totalMissProbes / searchesPerAlpha;

		}
	}

	public void run() {
	}
}
