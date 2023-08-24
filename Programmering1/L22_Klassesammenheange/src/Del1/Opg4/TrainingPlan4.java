package Del1.Opg4;

import java.util.ArrayList;

/**
 * Models a training plan for a Swimmer
 */
public class TrainingPlan4 {
	private char level;
	private int weeklyWaterHours;
	private int weeklyStrengthHours;
	private ArrayList<Swimmer4> swimmers = new ArrayList();
	
	public TrainingPlan4(char level, int weeklyWaterHours, int weeklyStrengthHours) {
		this.level = level;
		this.weeklyWaterHours = weeklyWaterHours;
		this.weeklyStrengthHours = weeklyStrengthHours;
	}
	
	public char getLevel() {
		return level;
	}
	
	public void setLevel(char niveau) {
		this.level = niveau;
	}
	
	public int getWeeklyStrengthHours() {
		return weeklyStrengthHours;
	}
	
	public void setWeeklyStrengthHours(int weeklyStrengthHours) {
		this.weeklyStrengthHours = weeklyStrengthHours;
	}
	
	public int getWeeklyWaterHours() {
		return weeklyWaterHours;
	}
	
	public void setWeeklyWaterHours(int weeklyWaterHours) {
		this.weeklyWaterHours = weeklyWaterHours;
	}

	public ArrayList<Swimmer4> getSwimmers() {
		return new ArrayList<>(swimmers);
	}

	public void addSvimmers(Swimmer4 swimmer) {
		if (!swimmers.contains(swimmer)) {
			this.swimmers.add(swimmer);
		};
	}

	public void removeSwimmer(Swimmer4 swimmer) {
		if (swimmers.contains(swimmer)) {
			swimmers.remove(swimmer);
		}
	}
	public Swimmer4 createSwimmer (String name, int yearGroup, ArrayList<Double> lapTimes, String club){
		Swimmer4 s = new Swimmer4(name,yearGroup,lapTimes,club);
		swimmers.add(s);
		return s;
	}
}
