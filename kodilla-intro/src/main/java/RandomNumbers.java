import java.util.Random;
public class RandomNumbers {
    public static void main(String[] args) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int limit = 5000;
        int sum = 0;
        int couter = 0;
        Random rand = new Random();

        while (sum <= limit) {
            int randomInt = rand.nextInt(31);
            sum += randomInt;

            if (randomInt < min) {
                min = randomInt;
            }
            if (randomInt > max) {
                max = randomInt;
            }
            couter++;
        }
        System.out.println("Najmniejsza wylosowana liczba: " +min);
        System.out.println("Najwieksza wylosowana liczba: " +max);
        System.out.println("Laczna ilosc wylosowanych liczb: " +couter);


    }

}
