package com.ivan.spring.bot.RestApiTest_one_bot.config;

import com.ivan.spring.bot.RestApiTest_one_bot.service.CommandsBots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotInitializer {
    @Autowired
    CommandsBots commandsBots;

    @EventListener({ContextRefreshedEvent.class})
    public void init () throws TelegramApiException {

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(commandsBots);
        } catch (TelegramApiException e) {

        }
    }

}
