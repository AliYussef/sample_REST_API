package nl.inholland.model;

import javax.persistence.*;

@Entity
public class Stock {

    @Id
    @SequenceGenerator(name = "stock_seq", initialValue = 100001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_seq")
    private long id;
    private int quantity;

    @OneToOne
    private Anime anime;

    public Stock(int quantity, Anime anime) {
        this.quantity = quantity;
        this.anime = anime;
    }

    public Stock() {
    }

    public long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", anime=" + anime +
                '}';
    }
}
