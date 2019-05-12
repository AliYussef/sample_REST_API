package nl.inholland.service;

import nl.inholland.model.Anime;
import nl.inholland.model.Stock;
import nl.inholland.repository.AnimeRepository;
import nl.inholland.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimeShopService {

    private AnimeRepository animeRepository;
    private StockRepository stockRepository;

    public AnimeShopService(AnimeRepository animeRepository, StockRepository stockRepository) {
        this.animeRepository = animeRepository;
        this.stockRepository = stockRepository;
    }

    public Iterable<Anime> getAllAnimes() {
        return animeRepository.findAll();
    }

    public void addAnime(Anime anime) {
        animeRepository.save(anime);
    }

    public void deleteAnime(long id) {
        animeRepository.delete(animeRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    public void updateAnime(Anime anime) {
        animeRepository.save(animeRepository.findById(anime.getId())
                .map(anime1 -> anime).orElseThrow(IllegalArgumentException::new));
    }

    public Iterable<Anime> getAnimeByGenre(String genre) {
        return animeRepository.getAnimeByGenreOrderByRankingAsc(genre);
    }

    public Iterable<Anime> getAnimeByTitle(String title) {
        return animeRepository.getAnimeByTitle(title);
    }

    public Iterable<Stock> getAnimesInStockByQuantityMin(int min) {
        return stockRepository.getAllByQuantityGreaterThanEqualOrderByQuantityDesc(min);
    }

}
