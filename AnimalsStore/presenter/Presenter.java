package presenter;

import java.time.LocalDate;
import java.util.List;

import file_system.enums.StatusFileFS;
import model.service.Service;

public class Presenter {
    Service service;

    public Presenter(){
        service = new Service();
    }
    public void addNewAnimal(String string, LocalDate birthDay, String name){
        service.addNewAnimal(string, birthDay, name);
    }
    public void getListAnimalsInfo(){
        service.getListAnimalsInfo();
    }
    // public void removeItemFromList(int index){
    //     service.removeItemFromList(index);
    // }
    public List<String> getListDoingsAnimalInfo(int index){
        return service.getListDoingsAnimalInfo(index);
    }

    public void addDoingOfAnimal(int index, String doing){
        service.addDoingOfAnimal(index, doing);
    }
    public StatusFileFS saveAnimalsList(String file_path){
        return service.saveAnimalsList(file_path);
    }
    public StatusFileFS loadAnimalsList(String file_path){
        return service.loadAnimalsList(file_path);
    }
    
}
