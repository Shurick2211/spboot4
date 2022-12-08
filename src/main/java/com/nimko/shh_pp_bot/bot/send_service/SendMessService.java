package com.nimko.shh_pp_bot.bot.send_service;

import com.nimko.shh_pp_bot.bot.Bot;

public interface SendMessService {
    void send(String chatId, String mess);
    Bot getBot();
}
