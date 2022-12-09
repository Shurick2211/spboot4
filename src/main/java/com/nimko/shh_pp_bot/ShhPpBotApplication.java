package com.nimko.shh_pp_bot;

import com.nimko.shh_pp_bot.repo.DataBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Slf4j
@SpringBootApplication

public class ShhPpBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShhPpBotApplication.class, args);
	}

}
