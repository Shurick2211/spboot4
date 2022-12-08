package com.nimko.shh_pp_bot.repo;

import com.nimko.shh_pp_bot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataBase extends JpaRepository<Person,Long> {
}
