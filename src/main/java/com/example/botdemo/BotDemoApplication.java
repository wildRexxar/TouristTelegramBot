package com.example.botdemo;

import com.example.botdemo.telegram_bot.TouristBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication

public class BotDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotDemoApplication.class, args);

    }

}
