public class Username {
    String name;
    double age;
    int height;

    public Username(String name, double age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    public static void main(String[] args) {
        Username user = new Username("Adam", 40.5, 178);
        if (user.age > 30 && user.height > 160) {
            System.out.println("User is older than 30 and taller than 160cm");
        } else {
            System.out.println("User is 30 (or younger) or 160cm (or shorter)");
        }
    }
}
