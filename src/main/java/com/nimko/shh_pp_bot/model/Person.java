package com.nimko.shh_pp_bot.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Document
public class Person {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String nik;

    @Override
    public String toString() {
        return  firstName + " " + lastName + " " + nik;
    }
}
