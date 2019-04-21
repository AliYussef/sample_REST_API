package nl.inholland.model;

public class Anime {

    private int id;
    private String title;
    private float ranking;

    public Anime(int id, String title, float ranking) {
        this.id = id;
        this.title = title;
        this.ranking = ranking;
    }

    public Anime() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRanking() {
        return ranking;
    }

    public void setRanking(float ranking) {
        this.ranking = ranking;
    }

}
