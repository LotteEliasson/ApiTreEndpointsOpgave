package lfe.apitreendpointsopgave.service;

import lfe.apitreendpointsopgave.dto.Age;
import lfe.apitreendpointsopgave.dto.Gender;
import lfe.apitreendpointsopgave.dto.NameResponse;
import lfe.apitreendpointsopgave.dto.Nationality;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

@Service
public class AppService {


    Mono<Age> getAgeFromApi(String name){
        WebClient client = WebClient.create();
        Mono<Age> age = client.get()
                .uri("https://api.agify.io?name=" + name)
                .retrieve()
                .bodyToMono(Age.class);
        return age;
    }

    Mono<Gender> getGenderFromApi(String name){
        WebClient client = WebClient.create();
        Mono<Gender> gender = client.get()
                .uri("https://api.genderize.io?name=" + name)
                .retrieve()
                .bodyToMono(Gender.class);
        return gender;
    }

    Mono<Nationality> getNatFromApi(String name){
        WebClient client = WebClient.create();
        Mono<Nationality> nationality = client.get()
                .uri("https://api.nationalize.io?name=" + name)
                .retrieve()
                .bodyToMono(Nationality.class);
        return nationality;
    }

    public NameResponse collectedFromApis(String name){
        Mono<Age> age = getAgeFromApi(name);
        Mono<Gender> gender = getGenderFromApi(name);
        Mono<Nationality> nationality = getNatFromApi(name);

        var rs = Mono.zip(age, gender, nationality).map(tuble3 -> {
            NameResponse response = new NameResponse(tuble3.getT1(), tuble3.getT2(), tuble3.getT3());
            response.setName(name);
            return response;
        });
        NameResponse response = rs.block();
        return response;
    }

}
