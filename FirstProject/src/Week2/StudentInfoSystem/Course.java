package Week2.StudentInfoSystem;

public class Course {
        Teacher courseTeacher;
        String name;
        String code;
        String prefix;
        public int examNote;
        public int oralTestNote;
        public float oralTestAffectPercent;
        public float examAffectPercent;

        public Course(String name, String code, String prefix, int oralTestAffectPercent) {
            this.name = name;
            this.code = code;
            this.prefix = prefix;
            this.examNote = 0;
            this.oralTestAffectPercent = oralTestAffectPercent / 100f;
            this.examAffectPercent = (100 - oralTestAffectPercent) / 100f;
        }

        public void addTeacher(Teacher t) {
            if (this.prefix.equals(t.branch)) {
                this.courseTeacher = t;
                System.out.println("İşlem başarılı");
            } else {
                System.out.println(t.name + " Akademisyeni bu dersi veremez.");
            }
        }

        public void printTeacher() {
            if (courseTeacher != null) {
                System.out.println(this.name + " dersinin Akademisyeni : " + courseTeacher.name);
            } else {
                System.out.println(this.name + " dersine Akademisyen atanmamıştır.");
            }
        }
}
