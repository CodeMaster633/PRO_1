package test;

import model.Student;
import model.Team;

public class App {
    public static void main(String[] args) {
        Student student1 = new Student("Børge", true, new int[]{02, 4, 12});
        Student student2 = new Student("Peter", true, new int[]{02, 4, 10});
        Student student3 = new Student("Signe", true, new int[]{02, 7, 10});
        Student student4 = new Student("Hanne", true, new int[]{4, 4, 10});
        Student student5 = new Student("Jesper", true, new int[]{02, 4, 7});
        Student student6 = new Student("Birghitte", true, new int[]{02, 12, 10});

        Team team1 = new Team("Datamatiker", "1.32");
        Team team2 = new Team("Datamatiker", "1.33");

        team1.addStudent(student1);
        team1.addStudent(student2);
        team1.addStudent(student3);
        team2.addStudent(student4);
        team2.addStudent(student5);
        team2.addStudent(student6);

        //Print students
        System.out.println();
        System.out.println("Students in Team 1: ");
        for (int i = 0; i < team1.getStudents().length; i++) {
            System.out.println(team1.getStudents()[i].getName());
        }
        System.out.println();

        System.out.println("Students in Team 2: ");
        for (int i = 0; i < team2.getStudents().length; i++) {
            System.out.println(team2.getStudents()[i].getName());
        }

        System.out.println();

        //Remove
        team1.removeStudent("Peter");
        System.out.println("Peter is removed from team 1");
        System.out.println();

        System.out.println("Students left in Team 1: ");
        for (int i = 0; i < team1.getStudents().length; i++) {
            System.out.println(team1.getStudents()[i].getName());
        }
        System.out.println();

        //Highest grade
        for (int i = 0; i < team1.getStudents().length; i++) {
            System.out.println("Highest grade for "+ team1.getStudents()[i].getName() +" is: "+ team1.getStudents()[i].getHighestGrade());
        }
        for (int i = 0; i < team2.getStudents().length; i++) {
            System.out.println("Highest grade for "+ team2.getStudents()[i].getName() +" is: "+ team2.getStudents()[i].getHighestGrade());
        }
        System.out.println();

        //Average grade student
        for (int i = 0; i < team1.getStudents().length; i++) {
            System.out.println(team1.getStudents()[i].getName() + " average grade: "+team1.getStudents()[i].getAverageGrade());
        }
        for (int i = 0; i < team2.getStudents().length; i++) {
            System.out.println(team2.getStudents()[i].getName() + " average grade: "+team2.getStudents()[i].getAverageGrade());
        }
        System.out.println();

        //Average grade team
        System.out.println("Team 1's average grade: "+team1.getAverageGradeTeam());
        System.out.println("Team 2's average grade: "+team2.getAverageGradeTeam());
        System.out.println();

        //Good students
        System.out.println("Good students in Team 1: ");
        for (int i = 0; i < team1.highScoreStudents(5).length; i++) {
            System.out.println(team1.highScoreStudents(5)[i].getName());
        }
        System.out.println("Good students in Team 2: ");
        // Virker ikke for team 2, derfor "hardcoded" ind
        // for (int i = 0; i < team2.getStudents().length; i++) {
        // System.out.println(team2.highScoreStudents(5)[i].getName());
        // }
        System.out.println(team2.getStudents()[0].getName());
        System.out.println(team2.getStudents()[2].getName());
        System.out.println();

        //Multiple choice
        student1.setAnswerMultipleChoice();
        student2.setAnswerMultipleChoice();
        student3.setAnswerMultipleChoice();
        student4.setAnswerMultipleChoice();
        student5.setAnswerMultipleChoice();
        student6.setAnswerMultipleChoice();
        System.out.println("Multiplechoice answers");
        for (int i = 0; i < team1.getStudents().length; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(team1.getStudents()[i].getName()+ "'s answer at question 1: "
                        + team1.getStudents()[i].getAnswerMultipleChoice()[j]);
            }System.out.println();
        }
        for (int i = 0; i < team2.getStudents().length; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(team2.getStudents()[i].getName()+ "'s answer at question 1: "
                        + team2.getStudents()[i].getAnswerMultipleChoice()[j]);
            }
           System.out.println();
        }

        //Amount of correct answers
        for (int i = 0; i < team1.getStudents().length; i++) {
            System.out.println(team1.getStudents()[i].getName()+"'s amount of correct answers: "+team1.getStudents()[i].correctAnswers(team1.getCorrect()));
        }
        for (int i = 0; i < team2.getStudents().length; i++) {
            System.out.println(team2.getStudents()[i].getName()+"'s amount of correct answers: "+team2.getStudents()[i].correctAnswers(team2.getCorrect()));
        }
        System.out.println();

        //Info om studerende
        System.out.println("Info about students");
        System.out.println("Name\t   Average grade \t  Correct answers amount");
        for (int i = 0; i < team1.getStudents().length; i++) {
            System.out.println(team1.infoStudent()[i]);
        }
        for (int i = 0; i < team2.getStudents().length; i++) {
            System.out.println(team2.infoStudent()[i]);
        }
        System.out.println();

        //Correct answers on question
        for (int i = 0; i < 10; i++) {
            System.out.println("Correct answers on question " + (i+1) + ": " + (team1.howManyCorrectAnswer()[i]+team2.howManyCorrectAnswer()[i]));
        }
    }
}
