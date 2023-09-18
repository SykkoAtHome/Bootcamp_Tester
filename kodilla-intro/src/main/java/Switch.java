import java.util.Scanner;

public class Switch {
    public enum Color {
        CYAN,
        MAGENTA,
        YELLOW,
        BLACK;
    }
    public static Color colorUserSelection() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select color: C-yan, M-agenta, Y-ellow, blac-K:");
            String userInput = scanner.nextLine().trim().toUpperCase();
            switch (userInput) {
                case "C":
                    return Color.CYAN;
                case "M":
                    return Color.MAGENTA;
                case "Y":
                    return Color.YELLOW;
                case "K":
                    return Color.BLACK;
                default:
                    System.out.println("Wrong color. Try again.");
            }
        }
    }
    public static void main(String[] args) {
        Color userColor = colorUserSelection();
        System.out.println("Selected color: " + userColor);
    }
}


