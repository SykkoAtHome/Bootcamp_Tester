public class FirstClass {
    public static void main(String[] args) {
//       Notebook asus = new Notebook(600, 990, 2020);
//       Notebook apple = new Notebook(2550, 1760, 2021);
//       Notebook lenovo = new Notebook(1300, 189, 2023);
//
//       asus.checkPrice();
//       apple.checkPrice();
//       lenovo.checkPrice();
//
//       asus.checkWeight();
//       apple.checkWeight();
//       lenovo.checkWeight();
//
//       asus.checkValue();
//       apple.checkValue();
//       lenovo.checkValue();

       Grades polski = new Grades();
       Grades matma = new Grades();
       polski.addGrade(5);
       polski.addGrade(3);
       polski.addGrade(4);
       matma.addGrade(1);
       polski.addGrade(1);
       matma.addGrade(3);
       System.out.println("Polski.lastGrade: " +polski.lastGrade());
       System.out.println("Matma.lastGrade: "+matma.lastGrade());
       System.out.println("Polski.averageGrade: " +polski.averageGrade());
       System.out.println("Matma.averageGrade: " +matma.averageGrade());


    }
}