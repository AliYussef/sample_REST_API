package nl.inholland.repository;

import nl.inholland.model.Anime;
import org.springframework.data.repository.CrudRepository;

public interface AnimeRepository extends CrudRepository<Anime, Long> {

    Iterable<Anime> getAnimeByGenreOrderByRankingAsc(String genre);

    Iterable<Anime> getAnimeByTitle(String title);
}
