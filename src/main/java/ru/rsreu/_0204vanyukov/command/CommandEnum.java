package ru.rsreu._0204vanyukov.command;

import ru.rsreu._0204vanyukov.command.commandsRealisation.flightsCommands.AddFlightCommand;
import ru.rsreu._0204vanyukov.command.commandsRealisation.usersCommands.*;

public enum CommandEnum {
    EMPTY(new EmptyCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    ADD_USER(new AddUserCommand()),
    DELETE_USER(new DeleteUserCommand()),
    BLOCK_USER(new BlockUserCommand()),
    UNBLOCK_USER(new UnblockUserCommand()),
    ADD_FLIGHT(new AddFlightCommand());

    private ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCurrentCommand(){
        return command;
    }
}
