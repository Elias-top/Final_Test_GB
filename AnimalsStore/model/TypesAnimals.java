package model;

public enum TypesAnimals {
    Cat("Cat"), 
    Dog("Dog"), 
    Hamster("Hamster"), 
    Donkey("Donkey"), 
    Cammel("Cammel"), 
    Horse("Horse");

    private String title;

    TypesAnimals(String title) {
        this.title = title;
    }
    
    public String getTitle(){
        return title;
    }

    @Override
    public String toString(){
        return title;
    }
}
