package ru.abtank.telegram.bot.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.abtank.telegram.bot.State;
import ru.abtank.telegram.entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.abtank.telegram.bot.handler.RegistrationHandler.NAME_CHANGE;
import static ru.abtank.telegram.util.TelegramUtil.createInlineKeyboardButton;
import static ru.abtank.telegram.util.TelegramUtil.createMessageTemplate;

@Component
public class HelpHandler implements Handler {

    @Override
    public List<PartialBotApiMethod<? extends Serializable>> handle(User user, String message) {
        // Создаем кнопку для смены имени
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> inlineKeyboardButtonsRowOne = List.of(
                createInlineKeyboardButton("Change name", NAME_CHANGE));

        inlineKeyboardMarkup.setKeyboard(List.of(inlineKeyboardButtonsRowOne));

        return List.of(createMessageTemplate(user).setText(String.format("" +
                "You've asked for help %s? Here it comes!", user.getName()))
                .setReplyMarkup(inlineKeyboardMarkup));

    }

    @Override
    public State operatedBotState() {
        return State.NONE;
    }

    @Override
    public List<String> operatedCallBackQuery() {
        return Collections.emptyList();
    }
}