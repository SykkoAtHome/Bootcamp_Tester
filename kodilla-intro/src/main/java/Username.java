public class Username {
    String name;
    double age;
    int height;

    public Username(String name, double age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    public String userValidation(Username user) {
        if (user.age > 30 && user.height > 160) {
            return "User is older than 30 and taller than 160cm";
        } else {
            return "User is 30 (or younger) or 160cm (or shorter)";
        }
    }
    public static void main(String[] args) {
        Username user = new Username("Adam", 40.5, 178);
        String validation = user.userValidation(user);
        System.out.println(validation);
    }
}
