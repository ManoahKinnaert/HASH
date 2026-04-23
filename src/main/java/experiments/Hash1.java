package experiments;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import core.HashTableProbed;
import util.Measurement;

public class Hash1 {

	ArrayList<Measurement> measurements;

	public Hash1() {
		measurements = new ArrayList<Measurement>();
	}

	public void conduct() {
		int tableSize = 100000;
        int searchesPerAlpha = 20000;

        Random random = new Random();

        for (double alpha = 0.10; alpha <= 0.95; alpha += 0.05) {

            HashTableProbed<Integer, Integer> table = new HashTableProbed<>(tableSize);

            HashSet<Integer> inserted = new HashSet<>();
            ArrayList<Integer> insertedList = new ArrayList<>();

            int targetSize = (int) (alpha * tableSize);

            // Fill in table 
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
            double theoreticalHit = 0.5 * (1 + (1.0 / (1 - alpha)));
           
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
            double theoreticalMiss = 0.5 * (1 + (1.0 / ((1 - alpha) * (1 - alpha))));

			// store the data
			measurements.add(new Measurement(alpha, measuredHit, measuredMiss, theoreticalHit, theoreticalMiss));
		}
	}

    // Export the findings to a basic temp text file for prossesing in python (plotting the results using matplotlib)
    public void exportForPy() {
        try (PrintWriter writer = new PrintWriter("hash1_results.csv")) {

        writer.println("alpha,measuredHit,theoreticalHit,measuredMiss,theoreticalMiss");

        for (Measurement m : measurements) {

            writer.printf(
                "%.2f,%.5f,%.5f,%.5f,%.5f%n",
                m.alpha,
                m.hits,
                m.theoreticalHits,
                m.misses,
                m.theoreticalMisses
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    // First export the data
    // Then start the plotting service (run python script)
    public void runPlot() {
        exportForPy();
        // TODO: run python script
    }

	public void run() {
		conduct();
        runPlot();
	}
}
