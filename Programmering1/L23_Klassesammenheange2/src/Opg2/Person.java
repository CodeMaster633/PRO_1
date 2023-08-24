package Opg2;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private ArrayList<Gift> gifts = new ArrayList<>();

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String str = name;
        return str;
    }

    public void addGift(Gift gift){
        if(!gifts.contains(gift)){
            gifts.add(gift);
        }
    }

    public void removeGift(Gift gift){
        if(gifts.contains(gift)){
            gifts.remove(gift);
        }
    }

    public ArrayList<Gift> getGift(){
        return new ArrayList<>(gifts);
    }

    public double giftsValue (){
        double value=0;

        for (int i = 0; i < gifts.size(); i++) {
            value+=gifts.get(i).getPrice();
        }

        return value;
    }

    public ArrayList<Person> givenBy (){
        ArrayList<Person> result = new ArrayList<>();

        for (int i = 0; i < gifts.size(); i++) {
            result.add(gifts.get(i).getPerson());
        }

        return result;
    }

}
