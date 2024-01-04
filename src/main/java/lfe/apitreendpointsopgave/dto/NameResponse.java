package lfe.apitreendpointsopgave.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NameResponse {

    String Name;

    String gender;
    double genderProbability;

    int age;
    int ageCount;

    String country;
    double countryProbability;

   public NameResponse(Age age, Gender gender, Nationality nationality){
       this.age = age.getAge();
       this.ageCount = age.getAgeCount();
       this.gender = gender.getGender();
       this.genderProbability = gender.getProbability();
       this.country = nationality.getCountry().get(0).getCountry_id();
       this.countryProbability = nationality.getCountry().get(0).getProbability();
   }

}
