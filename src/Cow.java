public class Cow implements Comparable {
    private int numSpots;
    private int weight;

    public Cow(int numSpots, int weight) {
        this.numSpots = numSpots;
        this.weight = weight;
    }

    public int getNumSpots() {
        return numSpots;
    }

    public int getWeight() {
        return weight;
    }

    public int compareTo(Object o) {
        Cow temp = ((Cow) o);

        if (temp.getNumSpots() > this.numSpots)
            return 1;

        if (temp.getNumSpots() < this.numSpots)
            return -1;

        return 0;
    }

    public String toString() {
        return "Number of Spots: " + numSpots + ", " + "Weight: " + weight;
    }
}
