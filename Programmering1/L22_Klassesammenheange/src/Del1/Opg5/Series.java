package Del1.Opg5;

import java.util.ArrayList;

public class Series {
    private String title;
    private ArrayList<String> cast = new ArrayList<>();
    private ArrayList<Episode> episodes = new ArrayList<>();

    public Series(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public Episode createEpisode (int number, int lengthMinutes, ArrayList<String> guestActors){
       Episode e = new Episode(number,lengthMinutes,guestActors);
       episodes.add(e);
       return e;
    }

    /**
     * Return the total length (in minutes) of all the
     * episodes in the series.
     */
    public int totalLength(){
        int result = 0;

        for (int i = 0; i < episodes.size(); i++) {
            result =+ episodes.get(i).getLengthMinutes();
        }

        return result;
    }
    /**
     * Return the total list of all guest actors from all
     * episodes.
     */
    public ArrayList<String> getGuestActors(){
        ArrayList<String> resultArr = new ArrayList<>();

        for (int i = 0; i < getGuestActors().size(); i++) {
            resultArr.add(episodes.get(i).getGuestActors().toString());
        }

        return resultArr;
    }
}
