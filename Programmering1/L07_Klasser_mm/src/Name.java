import java.util.stream.IntStream;

public class Name {

    private String firstName;
    private String middleName;
    private String lastName;
    private String username;


    public Name(String firstName,String lastName){
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
    }
    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName(){
        return getFirstName() + " " +getMiddleName()+ " " +getLastName();
    }

    public String getUsername(){

        String firstPart = ""+this.firstName.charAt(0)+this.firstName.charAt(1);
        firstPart=firstPart.toUpperCase();

        int secondPart = this.middleName.length();

        String thirdPart = ""+this.lastName.charAt(lastName.length()-1)
                +this.lastName.charAt(lastName.length()-2);

        return firstPart+secondPart+thirdPart;
    }


}
