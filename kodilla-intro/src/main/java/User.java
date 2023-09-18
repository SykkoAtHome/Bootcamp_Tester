public class User {
    int age;
    String name;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public static void main(String[] args) {
        User[] users = new User[10];
        users[0] = new User("Adam", 17);
        users[1] = new User("Kasia", 27);
        users[2] = new User("Maria", 14);
        users[3] = new User("Olaf", 32);
        users[4] = new User("Hania", 43);
        users[5] = new User("Ewa", 21);
        users[6] = new User("Aga", 19);
        users[7] = new User("Iga", 55);
        users[8] = new User("Kacper", 47);
        users[9] = new User("Michal", 40);

        int sumAge = 0;
        double averageAge = 0;
        for (User i : users) {
            sumAge += i.age;
        }
        averageAge = (double) sumAge / users.length;

        System.out.println("Srednia wieku uzytkownikow: "+ averageAge);
        System.out.println("Uzytkownicy w wieku ponizej sredniej:");

        for (User i : users) {
            if (i.age < averageAge) {
                System.out.println(i.name + " (" + i.age + ")");
            }
        }
    }
}