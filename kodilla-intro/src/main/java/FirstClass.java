public class FirstClass {
    public static void main(String[] args) {
       Notebook Asus = new Notebook(600, 990, 2020);
       Notebook Apple = new Notebook(2550, 1760, 2021);
       Notebook Lenovo = new Notebook(1300, 189, 2023);

       Asus.checkPrice();
       Apple.checkPrice();
       Lenovo.checkPrice();

       Asus.checkWeight();
       Apple.checkWeight();
       Lenovo.checkWeight();

       Asus.checkValue();
       Apple.checkValue();
       Lenovo.checkValue();

    }
}