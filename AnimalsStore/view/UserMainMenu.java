package view;

import java.util.ArrayList;
import java.util.List;

import view.commands.AddAnimalToList;
import view.commands.AddDoingToAnimal;
import view.commands.Command;
import view.commands.Exit;
import view.commands.GetListAnimalsInfo;

public class UserMainMenu {
    private List<Command> commandList;

    public UserMainMenu(View view)
    {
        commandList = new ArrayList<>();
        commandList.add(new AddAnimalToList(view));
        commandList.add(new AddDoingToAnimal(view));
        commandList.add(new GetListAnimalsInfo(view));
        commandList.add(new Exit(view));
    }
    public String print()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список доступных комманд:\n");
        for (int i = 0; i < commandList.size(); i++)
        {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public void execute(int choice)
    {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int size()
    {
        return commandList.size();
    }
}
