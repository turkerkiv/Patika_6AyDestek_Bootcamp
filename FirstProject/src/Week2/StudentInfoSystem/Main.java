package Week2.StudentInfoSystem;

public class Main {
    public static void main(String[] args) {
        Course mat = new Course("Mat", "184134913", "MAT", 30);
        Course kimya = new Course("Kimya", "134134", "KIM", 25);
        Course fizik = new Course("Fizik", "141341", "FIZ", 35);

        Teacher t1 = new Teacher("Türker", "2349825", "MAT");
        Teacher t2 = new Teacher("Lütfü", "543534", "FIZ");
        Teacher t3 = new Teacher("Mustafa", "3635624", "KIM");

        mat.addTeacher(t1);
        kimya.addTeacher(t3);
        fizik.addTeacher(t2);

        Student st1 = new Student("Kemal", 4, "1212", mat, fizik, kimya);
        st1.addBulkExamNote(50,25,75);
        st1.addBulkOralTestNote(100,100,100);
        st1.isPass();
    }
}
