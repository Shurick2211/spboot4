package com.nimko.shh_pp_bot.bot.command;


import com.nimko.shh_pp_bot.bot.command_service.Command;
import com.nimko.shh_pp_bot.bot.send_service.SendMessService;
import com.nimko.shh_pp_bot.bot.send_service.SendMusick;
import org.telegram.telegrambots.meta.api.objects.Message;

public class AudioCommand implements Command {
    private final SendMessService sendMessService;
    public AudioCommand(SendMessService sendMessService) {
        this.sendMessService = new SendMusick(sendMessService.getBot());
    }

    @Override
    public void execute(Message message) {
        sendMessService.send(message.getChatId().toString(),"audio.mp3");
    }
}
