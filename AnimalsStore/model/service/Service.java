package model.service;

import java.time.LocalDate;
import java.util.List;

import file_system.FS;
import file_system.OOS;
import file_system.enums.StatusFileFS;
import model.AnimalsList;

public class Service {
    private AnimalsList animalsList;
    private FS fileOperationsOOS;

    public Service(){
        animalsList = new AnimalsList();
        fileOperationsOOS = new FS(new OOS());
    }
    public void addNewAnimal(String type, LocalDate birthDay, String name){
        animalsList.addNewAnimal(type, birthDay, name);
    }
    public void getListAnimalsInfo(){
        animalsList.getListAnimalsInfo();
    }
    // public void removeItemFromList(int index){
    //     toyMachine.removeItemFromList(index);
    // }
    // public boolean startLottery(int index){
    //     return toyMachine.startLottery(index);
    // }
    public List<String> getListDoingsAnimalInfo(int id){
       return animalsList.getListDoingsAnimalInfo(id);
    }

    public void addDoingOfAnimal(int index, String doing){
        animalsList.addDoingOfAnimal(index, doing);
    }
    public StatusFileFS saveAnimalsList(String file_path){
        if(fileOperationsOOS.Save(animalsList, file_path) == StatusFileFS.FileSaved)
        {
            System.out.println("Файл со списком животных успешно был сохранен");
            return StatusFileFS.FileSaved;
        }
        else
        {
            System.out.println("Произошла ошибка, файл со списком животных не был сохранен");
        }
        return StatusFileFS.FileNotSaved;
    }
    public StatusFileFS loadAnimalsList(String file_path){
        if(fileOperationsOOS.IsFileExist(file_path) == true)
        {
            System.out.println("Файл с списком животных успешно был загружен");
            animalsList = (AnimalsList) fileOperationsOOS.Read(file_path);
            return StatusFileFS.FileLoaded;
        }
        else if (fileOperationsOOS.IsFileExist(file_path) == false)
        {
            return StatusFileFS.NoSuchFile;
        }
        return StatusFileFS.NoSuchFile;
    }
}
