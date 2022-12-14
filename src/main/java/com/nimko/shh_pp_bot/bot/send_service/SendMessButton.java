package com.nimko.shh_pp_bot.bot.send_service;

import com.nimko.shh_pp_bot.bot.Bot;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class SendMessButton implements SendMessService{

    private final Bot bot;

    public SendMessButton(Bot bot) {
        this.bot = bot;
    }

    @Override
    public void send(String chatId, String mess) {
        String name=mess.trim();
        String [] names=name.split("/");

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableMarkdown(true);
        sendMessage.enableHtml(true);
        String message="Say Hello!";
        sendMessage.setText(message);

        try {
            setButtons(sendMessage, names);
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Send button error", e);
        }
    }

    @Override
    public Bot getBot() {
        return bot;
    }

    public synchronized void setButtons(SendMessage sendMessage, String [] names) {

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardRow;
            for (String name:names){
                keyboardRow = new KeyboardRow();
                keyboardRow.add(new KeyboardButton(name));
                keyboard.add(keyboardRow);
            }

        replyKeyboardMarkup.setKeyboard(keyboard);
    }


}
