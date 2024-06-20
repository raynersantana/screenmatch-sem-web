package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String title,
                         @JsonAlias("totalSeasons") Integer totalSeasons,
                         @JsonAlias("imdbRating") String imbdRating,
                         @JsonAlias("Released") String released) {

}