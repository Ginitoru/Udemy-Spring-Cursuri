package com.ginitoru.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

public class Student {

    @NotNull(message = "first name is required")
    @Size(min = 1, message ="at leat 1 character" )
    private String firstName;

    @NotNull(message  = "last name is required")
    private String lastName;

    private String country;

    private String favoriteLanguage;

    private Map<String, String> countryOptions = new HashMap<>();
    private Map<String, String> languages= new HashMap<>();


    public Student() {
        addCountryes();
        addLanguage();
    }

    private void addCountryes(){

        countryOptions.put("BR", "Brazil");
        countryOptions.put("US", "America");
        countryOptions.put("Fr", "France");
    }

    private void addLanguage(){
        languages.put("Java", "Java");
        languages.put("C#", "C");
        languages.put("PHP", "PHP");
        languages.put("Ruby", "Ruby");
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

    public String getCountry() {
        return country;
    }

    public Map<String, String> getCountryOptions() {
        return countryOptions;
    }

    public void setCountryOptions(Map<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public void setCountry(String country) {
        this.country = country;
    }

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
}
