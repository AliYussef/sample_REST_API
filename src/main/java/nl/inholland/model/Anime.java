package nl.inholland.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "title")})
public class Anime {

    @Id
    @SequenceGenerator(name = "anime_seq", initialValue = 5005)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "anime_seq")
    private long id;
    private String title;
    private String genre;
    private float ranking;

    public Anime(String title, String genre, float ranking) {
        this.title = title;
        this.genre = genre;
        this.ranking = ranking;
    }

    public Anime() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getRanking() {
        return ranking;
    }

    public void setRanking(float ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", ranking=" + ranking +
                '}';
    }
}
