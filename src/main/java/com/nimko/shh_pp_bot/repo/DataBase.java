package com.nimko.shh_pp_bot.repo;

import com.nimko.shh_pp_bot.model.Person;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataBase extends MongoRepository<Person,Long> {
}
