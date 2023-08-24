package Del1.Opg4;

import java.util.ArrayList;

public class SwimmerApp4 {

    public static void main(String[] args) {

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer4 s1 = new Swimmer4("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer4 s2 = new Swimmer4("Bo", 1995, lapTimes, "Lyseng");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmer4 s3 = new Swimmer4("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");

        ArrayList<Swimmer4> swimmers = new ArrayList<>();
        swimmers.add(s1);
        swimmers.add(s2);
        swimmers.add(s3);

        for (Swimmer4 s : swimmers) {
            System.out.println(s.getName() + "'s bedste tid: " + s.bestLapTime());
        }
        System.out.println();

        TrainingPlan4 plan = new TrainingPlan4('A', 20, 10);

        plan.createSwimmer("Benjamin",1998,lapTimes,"Århus svømmeklub");
        plan.createSwimmer("Mikkel",1994,lapTimes,"Ålborg svømmeklub");

        System.out.println("Trainingplans deltagere: " +plan.getSwimmers().get(0).getName() +", " +plan.getSwimmers().get(1).getName());
        System.out.println("Trainingplans deltagere: " +plan.getSwimmers().get(0).getName() );

    }

}
