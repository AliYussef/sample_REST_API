package nl.inholland.service;

import nl.inholland.model.Anime;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnimeService {

    private List<Anime> animes = new ArrayList<>(
            Arrays.asList(
                    new Anime(1, "Fullmetal Alchemist: Brotherhood", 9.24f),
                    new Anime(2, "Hunter x Hunter", 9.12f),
                    new Anime(3, "Dragon Ball Z", 8.28f),
                    new Anime(4, "JoJo's Bizarre Adventure: Stardust Crusaders", 8.25f),
                    new Anime(5, "One Piece", 8.53f),
                    new Anime(6, "Naruto: Shippuuden", 8.20f)
            )
    );

    public List<Anime> getAnimes() {
        return animes;
    }

    public Anime getAnime(int id) {

        for (Anime anime : animes) {
            if (anime.getId() == id) {
                return anime;
            }
        }
        return null;
    }

    public void addAnime(Anime anime) {
        animes.add(anime);
    }

    public void updateAnime(int id, Anime anime) {

        for (Anime anime1 : animes) {
            if (anime.getId() == id) {
                anime1.setTitle(anime.getTitle());
                anime1.setRanking(anime.getRanking());
            }
        }
    }

    public void deleteAnime(int id) {

        for (Anime anime : animes) {
            if (anime.getId() == id) {
                animes.remove(anime);
                break;
            }
        }
    }
}
