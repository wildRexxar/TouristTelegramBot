package com.example.botdemo.telegram_bot;

import com.example.botdemo.controller.CityRestController;
import com.example.botdemo.entity.City;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.PostConstruct;

@Component
public class TouristBot extends TelegramLongPollingBot {

    private final CityRestController controller;

    @Value("${bot.token}")
    private String token;

    @Value("${bot.name}")
    private String name;

    @Value("${bot.cityNotFound}")
    private String cityNotFound;

    static  {
        ApiContextInitializer.init();
    }

    TouristBot(CityRestController controller) {
        this.controller = controller;
    }

    @PostConstruct
    @SneakyThrows
    public void registerBot(){
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        telegramBotsApi.registerBot(this);

    }
    @Override
    public String getBotUsername() {
        return name;
    }


    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            System.out.println("Пуск");

            Message message = update.getMessage();
            if (message.hasText()) {
                City cityFromDB = controller.getCityFromBD(message.getText());

                if (cityFromDB != null) {
                    SendMessage sendMessage = new SendMessage()
                            .setChatId(message.getChatId().toString())
                            .setText(cityFromDB.getAttraction());
                    execute(sendMessage);
                } else {
                    SendMessage sendMessage = new SendMessage()
                            .setChatId(message.getChatId().toString())
                            .setText(cityNotFound);
                    execute(sendMessage);

                }
            }
        }
    }
}
