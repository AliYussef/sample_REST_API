package nl.inholland.model;

public class Anime {

    private int id;
    private String title;
    private String genre;
    private float ranking;

    public Anime(int id, String title, String genre, float ranking) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.ranking = ranking;
    }

    public Anime() {
    }

    public int getId() {
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

}
