package model;

import java.time.LocalDate;
import java.util.List;

public interface AnimalsIntefrace {
    void addNewAnimal(String type, LocalDate birthDay, String name);
    
    void getListAnimalsInfo();

    List<String> getListDoingsAnimalInfo(int id);
    void addDoingOfAnimal(int index, String doing);

    List<String> getListTypesAnimals();
//    void removeAnimalFromList(int index);
}
