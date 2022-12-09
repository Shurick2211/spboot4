package com.nimko.shh_pp_bot.bot;


import com.nimko.shh_pp_bot.bot.command_service.CommandBox;
import com.nimko.shh_pp_bot.bot.command_service.CommandName;
import com.nimko.shh_pp_bot.bot.send_service.SendMess;
import com.nimko.shh_pp_bot.model.Person;
import com.nimko.shh_pp_bot.repo.DataBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Slf4j
public class Bot extends TelegramLongPollingBot {
    @Value("${bot.token}")
    private String botToken;
    @Value("${bot.name}")
    private String botName;

    @Autowired
    private DataBase db;

    @Override
    public void onUpdateReceived(Update update) {
        CommandBox commandBox = new CommandBox(new SendMess(this));
        if(update.hasMessage()) {
            String message = update.getMessage().getText().trim();
            log.info(message);
            if (message.startsWith("/")) {
                String identification = message.split(" ")[0].toLowerCase();
                commandBox.useCommand(identification).execute(update.getMessage());
            } else {
                commandBox.useCommand(CommandName.NO.name()).execute(update.getMessage());
            }
        } else
        if(update.hasCallbackQuery() && update.getCallbackQuery().getData().equals("list")){
            long chatId = update.getCallbackQuery().getFrom().getId();
            db.save(new Person(chatId,
                    update.getCallbackQuery().getFrom().getFirstName(),
                    update.getCallbackQuery().getFrom().getLastName(),
                    update.getCallbackQuery().getFrom().getUserName()
                    ));
            String mess = db.findAll().stream()
                    .map(Person::toString)
                    .reduce((x,y) -> x.replace("null","")
                            + "\n" + y.replace("null",""))
                    .orElse("");
            new SendMess(this).send(String.valueOf(chatId),mess);
        }

    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

}
