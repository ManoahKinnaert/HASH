package util;

public class Measurement {
    public double alpha;
    public double hits;
    public double misses;
    public double theoreticalHits;
    public double theoreticalMisses;

    public Measurement(double alpha, double hits, double misses, double theoreticalHits, double theoreticalMisses) {
        this.alpha = alpha;
        this.hits = hits;
        this.misses = misses;
        this.theoreticalHits = theoreticalHits;
        this.theoreticalMisses = theoreticalMisses;
    }
}
