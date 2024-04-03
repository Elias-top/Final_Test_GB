package view.commands;

import view.View;

public class AddDoingToAnimal extends Command{
    public AddDoingToAnimal(View view)
    {
        super("Добавить действие животному", view);
    }
    public void execute()
    {
        getView().addDoingToAnimal();
    }
}
