import java.util.Arrays;
import java.util.Random;

public class ComparingObjects {
    public static void main(String[] args) {
        Cow[] cows = makeCows((int) (Math.random() * 10) + 1);
        selSort(cows);
        Arrays.stream(cows)
              .forEach(System.out::println);

        Shoe[] shoes = makeShoes((int) (Math.random() * 10) + 1);
        selSort(shoes);
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

    public static void swap(Object[] o, int index1, int index2) {
        Object temp = o[index1];
        o[index1] = o[index2];
        o[index2] = temp;
    }
}
