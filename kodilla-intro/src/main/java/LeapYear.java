public class LeapYear {
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int yearToCheck = 1997;
        boolean isLeap = isLeapYear(yearToCheck);

        System.out.println(yearToCheck);

        if (isLeap) {
            System.out.println("Leap Year");
        } else {
            System.out.println("Not a Leap Year");
        }
    }
}
