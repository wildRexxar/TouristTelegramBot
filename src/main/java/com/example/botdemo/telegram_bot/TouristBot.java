package com.example.botdemo.telegram_bot;

import com.example.botdemo.controller.CityRestController;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.starter.AfterBotRegistration;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.annotation.PostConstruct;

import static java.awt.SystemColor.text;

@Component
public class TouristBot extends TelegramLongPollingBot {

    @Autowired
    private CityRestController controller;

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            System.out.println("Пуск");

            Message message = update.getMessage();
            if (message.hasText()) {

                String textFromDB = controller.findCityFromDB(message.getText());
                System.out.println(textFromDB);

                if (textFromDB != null) {
                    SendMessage sendMessage = new SendMessage()
                            .setChatId(message.getChatId().toString())
                            .setText("true");
                    execute(sendMessage);
                } else {
                    SendMessage sendMessage = new SendMessage()
                            .setChatId(message.getChatId().toString())
                            .setText("false");
                    execute(sendMessage);

                }
            }
        }
    }

    static  {
        ApiContextInitializer.init();
    }

    @Override
    public String getBotUsername() {
        return "@Tourist7428Bot";
    }

    @Override
    public String getBotToken() {
        return "5116991507:AAG6McU9MgvuzeBYU84Zl7yYZMN4Y35RAbs";
    }


    @PostConstruct
    @SneakyThrows
    public void registerBot(){
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
            telegramBotsApi.registerBot(this);

        }
    }
