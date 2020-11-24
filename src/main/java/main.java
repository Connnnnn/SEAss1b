import java.time.LocalDate;
import org.joda.time.DateTime;
import java.util.ArrayList;

class Main {

    public static void main(String[] args) {
        Main main = new Main();

        ArrayList<Student> s = new ArrayList<Student>();
        ArrayList<Course> c = new ArrayList<Course>();
        ArrayList<Modules> m = new ArrayList<Modules>();

        Modules ML = new Modules("Machine Learning", "CT4101", new ArrayList<Student>(), new ArrayList<Course>());
        Modules AI = new Modules("Artificial Intelligence", "CT4121", new ArrayList<Student>(), new ArrayList<Course>());
        Modules GIP = new Modules("Graphics & Image Process", "CT4104", new ArrayList<Student>(), new ArrayList<Course>());
        Modules IR = new Modules("Information Retrieval", "CT4100", new ArrayList<Student>(), new ArrayList<Course>());

        Course BCT = new Course("Computer Science & Information Technology", new ArrayList<Modules>(), new ArrayList<Student>(), new DateTime(2017, 9, 01, 00, 00), new DateTime(2021, 05, 15, 00, 00));
        Course ECE = new Course("Electronic and Electrical Engineering", new ArrayList<Modules>(), new ArrayList<Student>(), new DateTime(2017, 9, 01, 00, 00), new DateTime(2021, 05, 15, 00, 00));
        Course BSC = new Course("Science", new ArrayList<Modules>(), new ArrayList<Student>(), new DateTime(2017, 9, 01, 00, 00), new DateTime(2021, 05, 15, 00, 00));

        Student Conor = new Student("Conor Keaney", 21, "08/12/1998", "17323273", new ArrayList<Course>(), new ArrayList<Modules>());
        Student Eve = new Student("Eve Caulfield", 21, "14/12/1998", "17429466", new ArrayList<Course>(), new ArrayList<Modules>());
        Student Declan = new Student("Declan Walsh", 25, "19/06/1995", "17982384", new ArrayList<Course>(), new ArrayList<Modules>());


        c.add(BCT);
        c.add(ECE);
        c.add(BSC);

        s.add(Conor);
        s.add(Eve);
        s.add(Declan);

        m.add(ML);
        m.add(AI);
        m.add(GIP);
        m.add(IR);

        BCT.AddStudentToCourse(Conor, BCT);
        ECE.AddStudentToCourse(Declan, ECE);
        BSC.AddStudentToCourse(Eve, BSC);

        ML.addModuleToCourse(ML, BCT);
        AI.addModuleToCourse(AI, BCT);
        IR.addModuleToCourse(IR, BSC);
        GIP.addModuleToCourse(GIP, ECE);


        System.out.println("\n" + "---------------Course Information--------------- " + "\n");
        for (Course course : c) {
            System.out.println("Course Name #" + ((int) c.indexOf(course) + 1) + " : " + course.getCourseName());
            System.out.println("\n" + "Modules in Course : ");

            for (Modules mod : course.getModules()) {
                System.out.println(mod.getModName());

                for (Student st : mod.getStudents()) {
                    if (!s.contains(st)) {
                        s.add(st);
                    }
                }
            }

            System.out.println("\n" + "Students in Course : ");
            for (Student student : course.getStudentsEnrolled()) {
                System.out.println(student.getName());

            }
            System.out.println("\n" + "________________________________");
        }

        System.out.println("\n" + "---------------Students Information---------------" + "\n");
        for (Student student : s) {
            System.out.println("Username:" + student.getUsername());

            System.out.println("Modules: ");
            for (Modules module : student.getModules()) {
                System.out.println(module.getModName() + "");
            }

            System.out.println("Course:");
            for (Course course : student.getCourses()) {
                System.out.print(course.getCourseName() + "" + "\n");
            }
            System.out.println("________________________________");
        }

        System.out.println("\n" + "---------------Module Information---------------" + "\n");
        for (Modules mod : m) {
            System.out.println("Module Name: " + mod.getModName());
        }
    }
}





