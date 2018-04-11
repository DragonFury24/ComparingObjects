import java.util.Arrays;
import java.util.Random;

public class ComparingObjects {
    public static void main(String[] args) {
        Cow[] cows = makeCows((int) (Math.random() * 10) + 1);
        mergeSort(cows, 0, cows.length - 1);
        Arrays.stream(cows)
              .forEach(System.out::println);

        Shoe[] shoes = makeShoes((int) (Math.random() * 10) + 1);
        mergeSort(shoes, 0, shoes.length - 1);
        Arrays.stream(shoes)
              .forEach(System.out::println);
    }

    //Generate a random number of Cows with a random number of spots and weight.
    public static Cow[] makeCows(int numCows) {
        Cow[]  farmCows = new Cow[numCows];
        Random gen      = new Random(21429991);

        //Instantiate @farmCows
        for (int i = 0; i < farmCows.length; i++) {
            farmCows[i] = new Cow(gen.nextInt(15), gen.nextInt(2000) + 1000);
        }

        return farmCows;
    }

    //Instantiate a random number of Shoes with random shoe size and length
    public static Shoe[] makeShoes(int numShoes) {
        Shoe[] shoes = new Shoe[numShoes];
        Random gen   = new Random(21429991);

        //Instantiate @shoes
        for (int i = 0; i < shoes.length; i++) {
            shoes[i] = new Shoe(gen.nextInt(12), gen.nextInt(10) + 5);
        }

        return shoes;
    }

    //Sort array of Comparable objects
    public static void selSort(Comparable[] c) {
        Comparable minValue;
        int        minIndex = 0;

        for (int i = 0; i < c.length; i++) {
            minValue = c[i];

            for (int j = i; j < c.length; j++) {
                if (minValue.compareTo(c[j]) < 0) {
                    minIndex = j;
                    minValue = c[j];
                }
            }

            swap(c, i, minIndex);
        }
    }

    public static void mergeSort(Comparable[] c, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(c,low, middle);
            mergeSort(c, middle + 1, high);
            merge(c, low, middle, high);
        }
    }

    public static void merge(Comparable[] c, int low, int middle, int high) {
        Comparable[] temp = new Comparable[c.length];

        System.arraycopy(c, 0, temp, 0, c.length);

        int i, j, k;
        for (i = low, j = middle + 1, k = low; i <= middle && j <= high; k++) {
            if (temp[i].compareTo(temp[j]) > 0) {
                c[k] = temp[i];
                i++;
            } else {
                c[k] = temp[j];
                j++;
            }
        }

        for ( ; i <= middle; i++, k++) {
            c[k] = temp[i];
        }

    }

    public static void swap(Object[] o, int index1, int index2) {
        Object temp = o[index1];
        o[index1] = o[index2];
        o[index2] = temp;
    }
}
