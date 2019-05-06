package nl.inholland.service;

import nl.inholland.model.Anime;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AnimeService {

    private List<Anime> animes = new ArrayList<>(
            Arrays.asList(
                    new Anime(1, "Fullmetal Alchemist: Brotherhood", "Fantasy", 9.24f),
                    new Anime(2, "Hunter x Hunter", "Adventure", 9.12f),
                    new Anime(3, "Dragon Ball Z", "Supernatural", 8.28f),
                    new Anime(4, "JoJo's Bizarre Adventure: Stardust Crusaders", "Adventure", 8.25f),
                    new Anime(5, "One Piece", "Adventure", 8.53f),
                    new Anime(6, "Naruto: Shippuuden", "Adventure", 8.20f)
            )
    );

    public List<Anime> getAnimes(boolean sorted, double minumum, int pageSize) {
        Stream<Anime> animeStream = animes.stream()
                .filter(anime -> anime.getRanking() >= minumum);

        if (sorted) {
            animeStream = animeStream
                    .sorted(Comparator.comparingDouble(Anime::getRanking));
        }

        return animeStream
                .limit(pageSize)
                .collect(Collectors.toList());

    }

    public Anime getAnimeById(int id) {

        return animes.stream()
                .filter(anime -> anime.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Anime getAnimeByTitle(String title) {

        return animes.stream()
                .filter(anime -> anime.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    public List<Anime> getAnimesByGenre(String genre) {

        return animes.stream()
                .filter(anime -> anime.getGenre().toLowerCase().equals(genre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void addAnime(Anime anime) {
        animes.add(anime);
    }

    public void updateAnime(int id, Anime anime) {

        for (Anime anime1 : animes) {
            if (anime.getId() == id) {
                anime1.setTitle(anime.getTitle());
                anime1.setRanking(anime.getRanking());
                anime1.setGenre(anime.getGenre());
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
