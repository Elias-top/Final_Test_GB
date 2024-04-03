package view.commands;

import view.View;

public class GetListAnimalsInfo extends Command{
    public GetListAnimalsInfo(View view)
    {
        super("Посмотреть список животных", view);
    }
    public void execute()
    {
        getView().getListAnimalsInfo();
    } 
}
