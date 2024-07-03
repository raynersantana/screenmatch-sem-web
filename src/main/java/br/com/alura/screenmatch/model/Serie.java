package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.service.ConsultaMyMemory;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "Series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;
    private Integer totalSeasons;
    private Double imbdRating;
    private String released;
    @Enumerated(EnumType.STRING)
    private Category genre;
    private String actors;
    private String poster;
    private String plot;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episodio> episodios = new ArrayList<>();

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        episodios.forEach(e -> e.setSerie(this));
        this.episodios = episodios;
    }

    public Serie() {

    }

    public Serie(DadosSerie dadosSerie) {
        this.title = dadosSerie.title();
        this.totalSeasons = dadosSerie.totalSeasons();
        this.imbdRating = OptionalDouble.of(Double.valueOf(dadosSerie.imbdRating())).orElse(0);
        this.released = dadosSerie.released();
        this.genre = Category.fromString(dadosSerie.genre().split(",")[0].trim());
        this.actors = dadosSerie.actors();
        this.poster = dadosSerie.poster();
        this.plot = ConsultaMyMemory.obterTraducao(dadosSerie.plot()).trim();
    }

    @Override
    public String toString() {
        return  "genre=" + genre +
                ", title='" + title + '\'' +
                ", totalSeasons=" + totalSeasons +
                ", imbdRating=" + imbdRating +
                ", released='" + released + '\'' +
                ", actors='" + actors + '\'' +
                ", poster='" + poster + '\'' +
                ", plot='" + plot + '\'' +
                ", episode='" + episodios + '\'';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(Integer totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public Double getImbdRating() {
        return imbdRating;
    }

    public void setImbdRating(Double imbdRating) {
        this.imbdRating = imbdRating;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public Category getGenre() {
        return genre;
    }

    public void setGenre(Category genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
