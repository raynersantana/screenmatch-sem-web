package br.com.alura.screenmatch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {

    private Integer temporada;
    private String title;
    private Integer episodeNum;
    private Double rating;
    private LocalDate launchDate;

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio) {
        this.temporada = numeroTemporada;
        this.title = dadosEpisodio.title();
        this.episodeNum = dadosEpisodio.episodeNum();

        try {
            this.rating = Double.parseDouble(dadosEpisodio.rating());
        }catch (NumberFormatException e) {
            this.rating = 0.0;
        }

        try {
            this.launchDate = LocalDate.parse(dadosEpisodio.launchDate());
        }catch (DateTimeParseException e) {
            this.launchDate = null;
        }
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisodeNum() {
        return episodeNum;
    }

    public void setEpisodeNum(Integer episodeNum) {
        this.episodeNum = episodeNum;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public String toString() {
        return "temporada=" + temporada +
                ", title='" + title + '\'' +
                ", episodeNum=" + episodeNum +
                ", rating=" + rating +
                ", launchDate=" + launchDate;
    }
}
