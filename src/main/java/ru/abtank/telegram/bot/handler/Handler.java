package ru.abtank.telegram.bot.handler;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import ru.abtank.telegram.bot.State;
import ru.abtank.telegram.entity.User;

import java.io.Serializable;
import java.util.List;

@Service
public interface Handler {

// основной метод, который будет обрабатывать действия пользователя
    List<PartialBotApiMethod<? extends Serializable>> handle(User user, String message);
    // метод, который позволяет узнать, можем ли мы обработать текущий State у пользователя
    State operatedBotState();
    // метод, который позволяет узнать, какие команды CallBackQuery мы можем обработать в этом классе
    List<String> operatedCallBackQuery();
}
