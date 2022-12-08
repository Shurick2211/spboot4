package com.nimko.shh_pp_bot.bot.command;

import com.nimko.shh_pp_bot.bot.command_service.Command;
import com.nimko.shh_pp_bot.bot.send_service.SendMessService;
import org.telegram.telegrambots.meta.api.objects.Message;

public class StopCommand implements Command {
    private final SendMessService sendMessService;

    public StopCommand(SendMessService sendMessService) {
        this.sendMessService = sendMessService;
    }

    @Override
    public void execute(Message message) {
        String mess = "Зупинка Бота!";
        sendMessService.send(message.getChatId().toString(), mess);
        System.exit(1);
    }
}
