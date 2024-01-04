package lfe.apitreendpointsopgave.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Nationality {

    List<Country> country;

    @Getter
    @Setter
    public static class Country {
            String country_id;
            double probability;
        }
}
