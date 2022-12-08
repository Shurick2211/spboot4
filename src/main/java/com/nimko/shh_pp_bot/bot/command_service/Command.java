package com.nimko.shh_pp_bot.bot.command_service;


import org.telegram.telegrambots.meta.api.objects.Message;

public interface Command {

    void execute(Message message);
}
