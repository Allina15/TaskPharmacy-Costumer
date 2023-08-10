package Bankk;

import java.time.LocalDate;

public class Passport {
    private LocalDate dateOfBirth;
    private String country;
    private String gender;

    public Passport(LocalDate dateOfBirth, String country, String gender) {
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Passport " +
                "dateOfBirth=" + dateOfBirth +
                ", country='" + country +
                ", gender='" + gender ;
    }
}
