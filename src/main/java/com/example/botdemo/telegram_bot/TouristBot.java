package com.example.botdemo.telegram_bot;

import com.example.botdemo.controller.CityRestController;
import com.example.botdemo.entity.City;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TouristBot extends TelegramLongPollingBot {
    @Autowired
    private CityRestController controller;


    private String response = "не знаю таких";
    private final String URL = "http://localhost:8080/api/cities";

    private String findCity(String city) {

        return null;
    }


    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String cityFromBot = message.getText();
            if (message.hasText()) {
                if (findCity(cityFromBot) != null) {
                    execute(
                            SendMessage.builder()
                                    .chatId(message.getChatId().toString())
                                    .text("Ды, это парыж, ну или ландон")
                                    .build());
                } else {
                    execute(
                            SendMessage.builder()
                                    .chatId(message.getChatId().toString())
                                    .text(response)
                                    .build());
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "@Tourist7428Bot";
    }

    @Override
    public String getBotToken() {
        return "5116991507:AAG6McU9MgvuzeBYU84Zl7yYZMN4Y35RAbs";
    }

    @SneakyThrows
    public static void main(String[] args) {
        TouristBot bot = new TouristBot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }
}
