package model;

public class Team {
    private String name;
    private String room;
    private Student[] students = new Student[32];
    private int studentsAmount = 0;
    private final char[] correct = {'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void addStudent(Student student) {
        students[studentsAmount] = student;
        studentsAmount++;
    }

    public Student[] getStudents() {
        Student[] studentsList = new Student[studentsAmount];

        for (int i = 0; i < studentsAmount; i++) {
            studentsList[i] = students[i];
        }

        return studentsList;
    }

    public void removeStudent(String name) {

        Student[] studentsList = new Student[studentsAmount];
        int studentPlace = 0;

        for (int i = 0; i < studentsAmount; i++) {
            if (students[i].getName() == name) {
                studentPlace = i;
                studentsAmount = studentsAmount - 1;
            }
        }

        for (int j = 0; j < studentPlace; j++) {
            studentsList[j] = students[j];
        }

        for (int k = studentPlace; k < studentsAmount; k++) {
            studentsList[k] = students[k + 1];
        }

        students = studentsList;
    }

    public double getAverageGradeTeam() {

        double teamGradeSum = 0;
        double averageGradeTeam = 0;

        for (int i = 0; i < studentsAmount; i++) {
            teamGradeSum = teamGradeSum + students[i].getAverageGrade();
        }

        averageGradeTeam = teamGradeSum / studentsAmount;

        return averageGradeTeam;
    }

    public Student[] highScoreStudents(double minAverage) {

        Student[] goodStudents = new Student[32];
        int goodStudentsAmount = 0;

        for (int i = 0; i < students.length -1; i++) {
            if (students[i].getAverageGrade() > minAverage) {
                goodStudents[goodStudentsAmount] = students[i];
                goodStudentsAmount++;
            }
        }

        Student[] studentsList = new Student[studentsAmount];

        for (int i = 0; i < goodStudentsAmount; i++) {
            studentsList[i] = goodStudents[i];
        }

        return studentsList;
    }

    public char[] getCorrect() {
        return correct;
    }

    public String[] infoStudent(){
        String[] studentInfo = new String[studentsAmount];
        for (int i = 0; i < studentsAmount; i++) {
            Student student = students[i];
            double avgGrade = student.getAverageGrade();
            int numCorrect = student.correctAnswers(correct);
            String info = String.format("%-10s| %10.2f       | %4d", student.getName(), avgGrade, numCorrect);
            studentInfo[i] = info;
        }
        return studentInfo;
    }

//    public String[] infoStudent() {
//
//        String[] info = new String[studentsAmount];
//
//        for (int i = 0; i < studentsAmount; i++) {
//            info[i] = "Name: " + students[i].getName()
//                    + "\t\t\tAverage grade: " + students[i].getAverageGrade()
//                    + "\t\tAmount correct: " + students[i].correctAnswers(correct);
//        }
//
//        return info;
//    }

    public int[] howManyCorrectAnswer(){

        int[] correctAmount = new int[correct.length];

        for (int i = 0; i < studentsAmount; i++) {
            Student student = students[i];
            for (int j = 0; j < correct.length; j++) {
                if(student.getAnswerMultipleChoice()[j]==correct[j]){
                    correctAmount[j]++;
                }

            }
        }
        return correctAmount;
    }
}
