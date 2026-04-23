package experiments;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
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

    private File extractFileLocation() {
        JFileChooser chooser = new JFileChooser();

        chooser.setDialogTitle("Choose where to store CSV data");
        chooser.setSelectedFile(new File("hash1_results.csv"));
        chooser.setFileFilter(new FileNameExtensionFilter("CSV files", "csv"));
        int result = chooser.showSaveDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) {
            System.out.println("File extraction failed!");
            return null;
        }
        File selectedFile = chooser.getSelectedFile();

        if (!selectedFile.getName().toLowerCase().endsWith(".csv")) {
            selectedFile = new File(selectedFile.getAbsolutePath() + ".csv");
        }
        return selectedFile;
    }

    // Export the findings to a basic temp text file for prossesing in python
    // (plotting the results using matplotlib)
    private File exportForPy() {
        File file = extractFileLocation();

        try (PrintWriter writer = new PrintWriter(file)) {

            writer.println("alpha,measuredHit,theoreticalHit,measuredMiss,theoreticalMiss");

            for (Measurement m : measurements) {

                writer.printf(
                        "%.2f,%.5f,%.5f,%.5f,%.5f%n",
                        m.alpha,
                        m.hits,
                        m.theoreticalHits,
                        m.misses,
                        m.theoreticalMisses);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return file;
    }

    // First export the data
    // Then start the plotting service (run python script)
    public void runPlot() {
        File file = exportForPy();
        if (file == null)
            System.out.println("Export failed, quitting now...");
        // Run the python script
        try {
            String python = "python";
            String scriptPath = new File(
                    Objects.requireNonNull(
                            getClass().getClassLoader().getResource("scripts/plot_hash1.py")).toURI())
                    .getAbsolutePath();
            ProcessBuilder pb = new ProcessBuilder(python, scriptPath, file.getAbsolutePath());
            pb.redirectErrorStream(true);

            Process process = pb.start();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            System.out.println("Python exited with code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        conduct();
        runPlot();
    }
}
