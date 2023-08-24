import java.time.LocalTime;

public class StopWatch {

    private LocalTime startTime;
    private LocalTime endTime;

    public StopWatch(){
   }

    public void start(){
       LocalTime startTime = LocalTime.parse("19:33");
       System.out.println("Time: " + startTime.toString());
    }

   public void stop(){
        LocalTime endTime;
   }

   public String elapsedTime(){
//        LocalTime elapsedTime = endTime-startTime;
        return "Yes..";
   }

}
