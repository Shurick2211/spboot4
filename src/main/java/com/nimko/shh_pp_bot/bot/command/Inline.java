package com.nimko.shh_pp_bot.bot.command;

import com.nimko.shh_pp_bot.bot.command_service.Command;
import com.nimko.shh_pp_bot.bot.send_service.SendMessService;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Inline implements Command {
    private final SendMessService sendMessService;

    public Inline(SendMessService sendMessService) {
        this.sendMessService = sendMessService;
    }


    @Override
    public void execute(Message message) {
        String mess = "Подивитися хто сказав Hello!";
        sendMessService.send(message.getChatId().toString(), mess);
    }
}
