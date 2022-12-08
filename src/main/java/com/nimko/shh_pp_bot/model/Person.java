package com.nimko.shh_pp_bot.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
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
