package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnimalsList implements Serializable, AnimalsIntefrace{
    private List<Animal> animalsList;
    private int id;
    public AnimalsList(){
        animalsList = new ArrayList<>();
    }

    public void addNewAnimal(String type, LocalDate birthDay, String name){  
        id += 1; 
        animalsList.add(new Animal(id, type, birthDay, name));
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

    // public void removeItemFromList(int index){
    //     Animal need_to_delete = null;
    //     for(Animal itemToy : toysList){
    //         if(itemToy.getId() == index){
    //             need_to_delete = itemToy;
    //         }
    //     }
    //     toysList.remove(need_to_delete);
    // }
}
