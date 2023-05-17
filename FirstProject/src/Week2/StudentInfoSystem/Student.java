package Week2.StudentInfoSystem;

public class Student {
        String name,stuNo;
        int classes;
        Course mat;
        Course fizik;
        Course kimya;
        double average;
        boolean isPass;


        Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
            this.name = name;
            this.classes = classes;
            this.stuNo = stuNo;
            this.mat = mat;
            this.fizik = fizik;
            this.kimya = kimya;
            calcAverage();
            this.isPass = false;
        }


        public void addBulkExamNote(int mat, int fizik, int kimya) {

            if (mat >= 0 && mat <= 100) {
                this.mat.examNote = mat;
            }

            if (fizik >= 0 && fizik <= 100) {
                this.fizik.examNote = fizik;
            }

            if (kimya >= 0 && kimya <= 100) {
                this.kimya.examNote = kimya;
            }

        }

        //HOMEWORK *****
        public void addBulkOralTestNote(int mat, int fizik, int kimya)
        {
            if (mat >= 0 && mat <= 100) {
                this.mat.oralTestNote = mat;
            }

            if (fizik >= 0 && fizik <= 100) {
                this.fizik.oralTestNote = fizik;
            }

            if (kimya >= 0 && kimya <= 100) {
                this.kimya.oralTestNote = kimya;
            }
        }

        public void isPass() {
            if (this.mat.examNote == 0 || this.fizik.examNote == 0 || this.kimya.examNote == 0) {
                System.out.println("Notlar tam olarak girilmemiş");
            } else {
                this.isPass = isCheckPass();
                printNote();
                System.out.println("Ortalama : " + this.average);
                if (this.isPass) {
                    System.out.println("Sınıfı Geçti. ");
                } else {
                    System.out.println("Sınıfta Kaldı.");
                }
            }
        }

        public void calcAverage() {
            //HOMEWORK *****
            this.average = ((fizik.examNote * fizik.examAffectPercent + fizik.oralTestNote * fizik.oralTestAffectPercent) + (mat.examNote * mat.examAffectPercent + mat.oralTestNote * mat.oralTestAffectPercent) + (kimya.examNote * kimya.examAffectPercent + kimya.oralTestNote * kimya.oralTestAffectPercent)) / 3f;
        }

        public boolean isCheckPass() {
            calcAverage();
            return this.average > 55;
        }

        public void printNote(){
            System.out.println("=========================");
            System.out.println("Öğrenci : " + this.name);
            System.out.println("Matematik Notu : " + this.mat.examNote);
            System.out.println("Fizik Notu : " + this.fizik.examNote);
            System.out.println("Kimya Notu : " + this.kimya.examNote);
        }

}
