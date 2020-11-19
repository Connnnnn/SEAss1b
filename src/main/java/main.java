import java.time.LocalDate;
import org.joda.time.DateTime;
import java.util.ArrayList;

class Main {

    public static void main(String[] args){
        Main main = new Main();

        ArrayList<Student> s = new ArrayList<Student>();
        ArrayList<Course> c = new ArrayList<Course>();

        Modules ML = new Modules("Machine Learning", "CT4101", new ArrayList<Student>(), new ArrayList<Course>());
        Modules AI = new Modules("Artificial Intelligence", "CT4121", new ArrayList<Student>(), new ArrayList<Course>());
        Modules GIP = new Modules("Graphics & Image Process", "CT4104", new ArrayList<Student>(), new ArrayList<Course>());
        Modules IR = new Modules("Information Retrieval", "CT4100", new ArrayList<Student>(), new ArrayList<Course>());

        Course BCT = new Course("Computer Science & Information Technology", new ArrayList<Modules>(), new ArrayList<Student>(), new DateTime(2017,9,01), new DateTime(2021,05,15));
        Course ECE = new Course("Electronic and Electrical Engineering", new ArrayList<Modules>(), new ArrayList<Student>(), new DateTime(2017,9,01),new DateTime(2021,05,15));
        Course BSC = new Course("Science", new ArrayList<Modules>(), new ArrayList<Student>(), new DateTime(2017,9,01),new DateTime(2021,05,15));

        /*
         Course BCT = new Course("Computer Science & Information Technology", new ArrayList<Modules>(), new ArrayList<Student>(), LocalDate.of(2017,9,01),LocalDate.of(2021,05,15));
        Course ECE = new Course("Electronic and Electrical Engineering", new ArrayList<Modules>(), new ArrayList<Student>(), LocalDate.of(2017,9,01),LocalDate.of(2021,05,15));
        Course BSC = new Course("Science", new ArrayList<Modules>(), new ArrayList<Student>(), LocalDate.of(2017,9,01),LocalDate.of(2021,05,15));


         */
        c.add(BCT);
        c.add(ECE);
        c.add(BSC);

        Student Conor = new Student("Conor Keaney", 21,"08/12/1998" ,"17323273", new ArrayList<Course>(), new ArrayList<Modules>());
        Student Eve = new Student("Eve Caulfield", 21,"14/12/1998" ,"17429466", new ArrayList<Course>(), new ArrayList<Modules>());
        Student Declan = new Student("Declan Walsh", 25,"19/06/1995" ,"17982384", new ArrayList<Course>(), new ArrayList<Modules>());

        s.add(Conor);
        s.add(Eve);
        s.add(Declan);



        main.addStudentsToModule(ML, Conor);
        main.addStudentsToModule(AI, Conor);
        main.addStudentsToModule(GIP, Conor);
        main.addStudentsToModule(ML, Eve);
        main.addStudentsToModule(IR, Eve);
        main.addStudentsToModule(ML, Declan);
        main.addStudentsToModule(IR, Declan);

        main.addModulesToCourse(ML,BCT);
        main.addModulesToCourse(AI,BCT);
        main.addModulesToCourse(IR,BCT);
        main.addModulesToCourse(GIP,BCT);
        main.addModulesToCourse(ML,ECE);
        main.addModulesToCourse(AI,BCT);
        main.addModulesToCourse(ML,BSC);
        main.addModulesToCourse(GIP,BCT);


        for (Course course : c){
            System.out.println("Course Name #" + ((int) c.indexOf(course)+1) +" : "+ course.getCourseName());
            System.out.println("\n" + "Modules in Course : ");

            for(Modules mod :course.getModules()){
                System.out.println(mod.getModName());

                for(Student st : mod.getStudents()){
                    s.add(st);

                }
            }
        }

        for(Student student : s){

        }
    }


    public void addStudentToCourse(Student s, Course c){
        ArrayList<Course> activeCourses = s.getCourses();
        if(activeCourses.contains(c)==true){
            return;
        }
        else{
            activeCourses.add(c);
            s.setCourses(activeCourses);
        }
    }

    public void addModulesToCourse(Modules m, Course c){
        if(m.getCoursesAssociated().contains(c)){
            return;
        }
        else{
            ArrayList<Course> moduleCourse = m.getCoursesAssociated();
            moduleCourse.add(c);
            m.setCoursesAssociated(moduleCourse);

            ArrayList<Modules> courseModules = c.getModules();
            courseModules.add(m);
            c.setModules(courseModules);

            ArrayList<Student> studentsInModule = m.getStudents();
            ArrayList<Student> studentsInCourse = c.getStudentsEnrolled();


            for(Student sm : studentsInModule){
                studentsInCourse.add(sm);
            }
            c.setStudentsEnrolled(studentsInCourse);
        }

    }

    public void addStudentsToModule(Modules m, Student s){

        if(s.getModules().contains(m)){
            return;
        }
        else{
            ArrayList<Student> moduleStudents = m.getStudents();
            ArrayList<Modules> studentModules = s.getModules();

            moduleStudents.add(s);
            studentModules.add(m);

            m.setStudents(moduleStudents);
            s.setModules(studentModules);
        }
    }


}

