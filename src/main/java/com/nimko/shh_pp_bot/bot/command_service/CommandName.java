package com.nimko.shh_pp_bot.bot.command_service;

public enum CommandName {
    START("/start"),
    TEST("/test"),
    AUDIO("/audio"),
    HELP("/help"),
    BUTTON("BUTTON"),
    INLINE("/inline"),
    STOP("/stopbot"),
    NO("NO");

    private final String comName;

    CommandName(String commandName) {
        this.comName = commandName;
    }
    public String getComName(){
        return comName;
    }
}
