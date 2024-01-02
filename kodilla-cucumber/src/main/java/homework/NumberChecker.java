package homework;

public class NumberChecker {
    public static String checkNumber(int number) {
        String result = "";

        if (number % 3 == 0) {
            result += "Fizz";
        }

        if (number % 5 == 0) {
            result += "Buzz";
        }

        return result.isEmpty() ? "None" : result;
    }
}