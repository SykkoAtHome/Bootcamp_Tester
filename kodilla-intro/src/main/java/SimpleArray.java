public class SimpleArray {
    public static void main(String[] args) {
        String[] parts1 = new String[] {"Tablet", "Mouse", "CPU"};
        String[] parts2 = new String[3];
        parts2[0] = "Tablet";
        parts2[1] = "Mouse";
        parts2[2] = "CPU";

        int numberOfElements1 = parts1.length;
        int numberOfElements2 = parts2.length;

        String pcPart1 = parts1[0];
        String pcPart2 = parts2[2];

        System.out.println(pcPart1);
        System.out.println(pcPart2);

        System.out.println("My table contains " +numberOfElements1+" elements");


    }
}