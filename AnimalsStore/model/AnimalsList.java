package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.typesAnimals.Camel;
import model.typesAnimals.Cat;
import model.typesAnimals.Dog;
import model.typesAnimals.Donkey;
import model.typesAnimals.Hamster;
import model.typesAnimals.Horse;

public class AnimalsList implements Serializable, AnimalsIntefrace{
    private List<Animal> animalsList;
    private List<TypesAnimals> animalsTypesList;

    private int id;
    public AnimalsList(){
        animalsList = new ArrayList<>();
        animalsTypesList = new ArrayList<>();
        animalsTypesList.add(new Hamster());
        animalsTypesList.add(new Cat());
        animalsTypesList.add(new Dog());
        animalsTypesList.add(new Camel());
        animalsTypesList.add(new Donkey());
        animalsTypesList.add(new Horse());
    }

    public List<String> getListTypesAnimals(){
        return GetStringTypesAnimals();
    }

    public TypesAnimals getTypeByStringName(String type_str){
        for (TypesAnimals type_descr : animalsTypesList)
        {
            if(type_str == type_descr.getDescription())
            {
                return type_descr;
            }
        }
        return null;
    }

    private List<String> GetStringTypesAnimals(){
        List<String> stringTypes = new ArrayList<>();
        for (int i = 0; i < animalsTypesList.size(); i++)
        {
            stringTypes.add(animalsTypesList.get(i).getDescription());
        }

        return stringTypes;
    }

    public void addNewAnimal(String type_string, LocalDate birthDay, String name){  
        id += 1; 
        TypesAnimals typeAnimal = getTypeByStringName(type_string);
        animalsList.add(new Animal(id, typeAnimal, birthDay, name));
    }

    public void getListAnimalsInfo(){
        for(Animal itemAnimal : animalsList){
            System.out.println(itemAnimal);
        }
    }

    public List<String> getListDoingsAnimalInfo(int id){
        for(Animal itemAnimal : animalsList){
            if(itemAnimal.getId() == id){
                return itemAnimal.getDoings();
            }
        }
        return null;
    }

    public void addDoingOfAnimal(int index, String doing){
        for(Animal itemAnimal : animalsList){
            if(itemAnimal.getId() == index){
                itemAnimal.addDoing(doing);
            }
        }
    }
}
