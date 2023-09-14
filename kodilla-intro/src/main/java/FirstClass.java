public class FirstClass {
    public static void main(String[] args) {
//       Notebook Asus = new Notebook(600, 990, 2020);
//       Notebook Apple = new Notebook(2550, 1760, 2021);
//       Notebook Lenovo = new Notebook(1300, 189, 2023);
//
//       Asus.checkPrice();
//       Apple.checkPrice();
//       Lenovo.checkPrice();
//
//       Asus.checkWeight();
//       Apple.checkWeight();
//       Lenovo.checkWeight();
//
//       Asus.checkValue();
//       Apple.checkValue();
//       Lenovo.checkValue();

       Grades Polski = new Grades();
       Grades Matma = new Grades();
       Polski.addGrade(5);
       Polski.addGrade(3);
       Polski.addGrade(4);
       Matma.addGrade(1);
       Polski.addGrade(1);
       Matma.addGrade(3);
       System.out.println("Polski.lastGrade: " +Polski.lastGrade());
       System.out.println("Matma.lastGrade: "+Matma.lastGrade());
       System.out.println("Polski.averageGrade: " +Polski.averageGrade());
       System.out.println("Matma.averageGrade: " +Matma.averageGrade());


    }
}