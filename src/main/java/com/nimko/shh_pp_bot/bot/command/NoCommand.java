package com.nimko.shh_pp_bot.bot.command;

import com.nimko.shh_pp_bot.bot.command_service.Command;
import com.nimko.shh_pp_bot.bot.command_service.CommandBox;
import com.nimko.shh_pp_bot.bot.send_service.SendMessInline;
import com.nimko.shh_pp_bot.bot.send_service.SendMessService;
import org.telegram.telegrambots.meta.api.objects.Message;

public class NoCommand implements Command {
    private final SendMessService sendMessService ;

    public NoCommand(SendMessService sendMessService) {
        this.sendMessService = sendMessService;
    }

    @Override
    public void execute(Message message) {
        CommandBox commandBox = new CommandBox(sendMessService);
        switch (message.getText()) {
            case "Music": {
                commandBox.useCommand("/audio").execute(message);
                break;
            }
            case "Hello": {
                commandBox = new CommandBox(new SendMessInline(sendMessService.getBot()));
                commandBox.useCommand("/inline").execute(message);
                break;
            }           
            case "STOP": {
                commandBox.useCommand("/stopbot").execute(message);
                break;
            }
            default:
                String mess = "Дивись тут -> /help";
                sendMessService.send(message.getChatId().toString(), mess);
        }
    }
}
