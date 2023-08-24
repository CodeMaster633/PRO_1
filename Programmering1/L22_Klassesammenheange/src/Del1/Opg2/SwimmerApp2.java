package Del1.Opg2;

import java.util.ArrayList;

public class SwimmerApp2 {

    public static void main(String[] args) {

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer2 s1 = new Swimmer2("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer2 s2 = new Swimmer2("Bo", 1995, lapTimes, "Lyseng");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmer2 s3 = new Swimmer2("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");

        ArrayList<Swimmer2> swimmers = new ArrayList<>();
        swimmers.add(s1);
        swimmers.add(s2);
        swimmers.add(s3);

        for (Swimmer2 s : swimmers) {
            System.out.println(s.getName() + "'s bedste tid: " + s.bestLapTime());
        }
        System.out.println();

        TrainingPlan2 plan = new TrainingPlan2('A', 20, 10);
        plan.addSvimmers(s1);
        plan.addSvimmers(s2);

        System.out.println("Trainingplans deltagere: " +plan.getSwimmers().get(0).getName() + ", " + plan.getSwimmers().get(1).getName());

    }

}
