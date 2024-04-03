package view.commands;

import view.View;

public class AddAnimalToList extends Command{
    public AddAnimalToList(View view)
    {
        super("Добавить животное", view);
    }
    public void execute()
    {
        getView().addAnimalToList();
    }
}
