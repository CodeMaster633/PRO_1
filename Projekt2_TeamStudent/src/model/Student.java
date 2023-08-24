package model;

import java.util.Random;

public class Student {

    private String name;
    private boolean active;
    private int[] grades;
    private char[] answerMultipleChoice = new char[10];


    public Student(String name,boolean active,int[] grades){
        this.name=name;
        this.active=active;
        this.grades=grades;
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public int getHighestGrade(){
        int highestGrade = 0;
        for(int i = 0;i<grades.length;i++){
            if(grades[i]>highestGrade){
                highestGrade=grades[i];
            }
        }
        return highestGrade;
    }

    public double getAverageGrade(){
        double gradeSum=0;
        for (int i = 0; i < grades.length; i++) {
            gradeSum = gradeSum + getGrades()[i];
        }

        double averageGrade = gradeSum/grades.length;

        return averageGrade;
    }

    public void setAnswerMultipleChoice() {
        Random random = new Random();
        char[] choices = {'A', 'B', 'C', 'D'};
        for (int i = 0; i < answerMultipleChoice.length; i++) {
            answerMultipleChoice[i] = choices[random.nextInt(choices.length)];
        }
    }

//    public void setAnswerMultipleChoice(){
//
//        char[] answers = {'A','B','C','D'};
//
//        for (int i = 0; i < 10; i++) {
//            int r = (int) (Math.random()*4);
//            this.answerMultipleChoice[i] = answers[r];
//        }
//    }

    public char[] getAnswerMultipleChoice() {
        return answerMultipleChoice;
    }

    public int correctAnswers(char[] correct){
        int result = 0;

        for (int i = 0; i < 10; i++) {
            if(correct[i]==getAnswerMultipleChoice()[i]){
                result++;
            }
        }

        return result;
    }
}
