package com.cherry.prospring5.ch10.obj;

import com.cherry.prospring5.ch10.CheckCountrySinger;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@CheckCountrySinger
public class Singer {
    @NotNull
    @Size(min = 2, max = 60)
    private String firstName;
    private String lastName;
    @NotNull
    private Genre genre;
    private Gender gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

//    public boolean isCountrySinger() {
//        return genre == Genre.COUNTRY;
//    }

    @AssertTrue(message = "ERROR! Individual customer should have gender and last name defined")
    public boolean isCountrySinger() {
        boolean result = true;
        if (genre != null &&
                (genre.equals(Genre.COUNTRY) &&
                        (gender == null || lastName == null))) {
            result = false;
        }
        return result;
    }
}
