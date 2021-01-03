package com.luv2code.springdemo.mvc.model;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Student {

    private String firstName;

    private String lastName;

    private String country;

    private LinkedHashMap<String, String> coutryOptions;

    private String favoriteLanguage;
    private String favoriteLanguage2;

    private Map<String, String> languages;

    private List<String> operatingSystems;

    public Student() {
        coutryOptions = new LinkedHashMap<>();
        languages = new LinkedHashMap<>();
        coutryOptions.put("BR", "Brazil");
        coutryOptions.put("FR", "France");
        coutryOptions.put("DE", "Germany");
        coutryOptions.put("US", "United States");
        addLanguage();

    }

    private void addLanguage(){
        languages.put("Java", "Java");
        languages.put("C#", "C");
        languages.put("PHP", "PHP");
        languages.put("Ruby", "Ruby");
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCoutryOptions() {
        return coutryOptions;
    }

    public void setCoutryOptions(LinkedHashMap<String, String> coutryOptions) {
        this.coutryOptions = coutryOptions;
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

    public String getFavoriteLanguage2() {
        return favoriteLanguage2;
    }

    public void setFavoriteLanguage2(String favoriteLanguage2) {
        this.favoriteLanguage2 = favoriteLanguage2;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

    public List<String> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(List<String> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}
