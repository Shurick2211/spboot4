package com.nimko.shh_pp_bot.bot.send_service;

import com.nimko.shh_pp_bot.bot.Bot;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.InputStream;

@Slf4j
public class SendMusick implements SendMessService{

    private final Bot bot;

    public SendMusick(Bot bot) {
        this.bot = bot;
    }

    @Override
    public void send(String chatId, String mess) {
        SendAudio sendAudio = new SendAudio();
        InputStream rootPath = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(mess);
        sendAudio.setAudio(new InputFile().setMedia(rootPath,"music"));
        sendAudio.setChatId(chatId);
        try {
           bot.execute(sendAudio);
        } catch (TelegramApiException e) {
            log.error("Send Audio error",e);
        }
    }

    public Bot getBot() {
        return bot;
    }
}
