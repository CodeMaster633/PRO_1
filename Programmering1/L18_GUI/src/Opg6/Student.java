package Opg6;

public class Student {

    private String name;
    private int age;
    private boolean active;

    public Student(){
this.age=0;
    }

    public Student(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean getActive() {
        return active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
