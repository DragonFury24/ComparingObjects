public class Shoe implements Comparable {
    private int size; //Shoe size
    private int length; //Shoe length

    public Shoe(int size, int length) {
        this.size = size;
        this.length = length;
    }

    public int compareTo(Object o) {
        Shoe temp = ((Shoe) o);

        if (temp.getSize() > this.size)
            return 1;

        if (temp.getSize() < this.size)
            return -1;

        return 0;
    }

    public int getSize() {
        return size;
    }

    public int getLength() {
        return length;
    }

    public String toString() {
        return "Shoe size: " + size + ", " + "Shoe length: " + length;
    }
}
