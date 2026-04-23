package util;

public class Measurement {
    double alpha;
    double hits;
    double misses;

    public Measurement(double alpha, double hits, double misses) {
        this.alpha = alpha;
        this.hits = hits;
        this.misses = misses;
    }

    public double getAlpha() { return alpha; }
    public double getHits() { return hits; }
    public double getMisses() { return misses; }
}
