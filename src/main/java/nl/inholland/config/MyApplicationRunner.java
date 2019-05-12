package nl.inholland.config;

import nl.inholland.model.Anime;
import nl.inholland.model.Stock;
import nl.inholland.repository.AnimeRepository;
import nl.inholland.repository.StockRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    private AnimeRepository animeRepository;
    private StockRepository stockRepository;

    public MyApplicationRunner(AnimeRepository animeRepository, StockRepository stockRepository) {
        this.animeRepository = animeRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Path path = Paths.get("src/main/resources/animes.csv");
        Files.lines(path)
                .forEach(line -> animeRepository.save(
                        new Anime(line.split(",")[0],
                                line.split(",")[1],
                                Float.parseFloat(line.split(",")[2]))));

        animeRepository.findAll()
                .forEach(System.out::println);

        List<Anime> animes = (List<Anime>) animeRepository.findAll();
        animes.stream()
                .forEach(anime -> stockRepository.save(new Stock(new Random().nextInt(10), anime)));

        stockRepository.findAll()
                .forEach(System.out::println);

    }
}
