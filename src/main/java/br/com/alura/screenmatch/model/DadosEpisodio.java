package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String title,
                            @JsonAlias("Episode") Integer episodeNum,
                            @JsonAlias("imdbRating") String rating,
                            @JsonAlias("Released") String launchDate) {
}
