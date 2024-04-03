package view;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import presenter.Presenter;

public class ConsoleUI implements View{
    private Scanner scanner;
    private boolean inProgress;
    String file_path = "AnimalsList.out";
    String file_log_path = "LogFile.txt";
    private Presenter presenter;
    private UserMainMenu userMainMenu;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        userMainMenu = new UserMainMenu(this);
        presenter = new Presenter();
        load();
    }

    public void start(){
        inProgress = true;
        while(inProgress){
            printUserMenu();
            scanUserMenuInput();
        }
    }

    private void scanUserMenuInput(){
        String choiceStr = scanner.nextLine();
        if(checkTextForInt(choiceStr))
        {
            int choice = Integer.parseInt(choiceStr);
            if(checkCommandList(choice))
            {
                userMainMenu.execute(choice);
            }
        }
    }

    public void addAnimalToList(){
        int temp_index = 1;
        LocalDate birthDay = null;

        try{
            List<String> listTypes = presenter.getListTypesAnimals();

            System.out.println("Выберите тип животного: \n");
            for(String printTypes : listTypes){
                System.out.println(temp_index + " "+printTypes);
                temp_index ++;
            }
            int choice_type = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите дату рождения в формате (yyyy-MMM-dd)");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
            try{
                birthDay = LocalDate.from(formatter.ISO_LOCAL_DATE.parse(scanner.nextLine()));
            }catch (Exception e) {
                System.out.println(e);
                return;
            }

            System.out.println("Введите кличку животного: ");
            String name = scanner.nextLine();

            presenter.addNewAnimal(listTypes.get(choice_type - 1), birthDay, name);
        }catch (NumberFormatException e){
            System.out.println("Введены некорректные данные ");
        }
    }

    public void addDoingToAnimal(){
        try{
            getListAnimalsInfo();
            System.out.println("Выберите id животного для добавления действия: ");
            int animalID = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите новое действие для животного: ");
            String nameOfDoing = scanner.nextLine();

            presenter.addDoingOfAnimal(animalID, nameOfDoing);
        }catch (NumberFormatException e){
            System.out.println("Введены некорректные данные ");
        }
    }

    public void getListAnimalsInfo(){
        presenter.getListAnimalsInfo();
    }

    private void printUserMenu(){
        System.out.println(userMainMenu.print());
    }

    public void exit(){
        save();
        this.inProgress = false;
    }

    private void save()
    {
        presenter.saveAnimalsList(file_path);
    }

    private void load()
    {
        presenter.loadAnimalsList(file_path);
    }

    private void error() {
        System.out.println("Введено неверное значение!");
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            error();
            return false;
        }
    }

    private boolean checkCommandList(int itemNum)
    {
        if (itemNum <= userMainMenu.size()){
            return true;
        } else {
            error();
            return false;
        }
    }
}
