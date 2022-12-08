package com.nimko.shh_pp_bot.bot.command_service;


import com.google.common.collect.ImmutableMap;
import com.nimko.shh_pp_bot.bot.command.*;
import com.nimko.shh_pp_bot.bot.send_service.SendMessService;
import com.nimko.shh_pp_bot.bot.command.StartCommand;


public class CommandBox {
    private final UnknowCommand unknowCommand;

    private final ImmutableMap<String, Command> commandMap;

    public CommandBox(SendMessService sendMessService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(CommandName.START.getComName(), new StartCommand(sendMessService))
                .put(CommandName.TEST.getComName(), new TestCommand(sendMessService))
                .put(CommandName.HELP.getComName(), new HelpCommand(sendMessService))
                .put(CommandName.NO.getComName(), new NoCommand(sendMessService))
                .put(CommandName.BUTTON.getComName(), new Button(sendMessService))
                .put(CommandName.INLINE.getComName(), new Inline(sendMessService))
                .put(CommandName.STOP.getComName(), new StopCommand(sendMessService))
                .build();
        unknowCommand = new UnknowCommand(sendMessService);

    }
    public Command useCommand(String identification){
        return commandMap.getOrDefault(identification, unknowCommand);
    }
}