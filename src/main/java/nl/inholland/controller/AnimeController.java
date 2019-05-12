package nl.inholland.controller;

import nl.inholland.model.Anime;
import nl.inholland.service.AnimeShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/animes")
public class AnimeController {

    private AnimeShopService animeShopService;

    public AnimeController(AnimeShopService animeShopService) {
        this.animeShopService = animeShopService;
    }


    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllAnimes() {
        return new ResponseEntity<>(animeShopService.getAllAnimes(), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addAnime(@RequestBody Anime anime) {
        animeShopService.addAnime(anime);
        return new ResponseEntity<>("Anime added successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAnime(@PathVariable long id) {
        animeShopService.deleteAnime(id);
        return new ResponseEntity<>("Anime has been removed", HttpStatus.OK);
    }

    @RequestMapping(value = "genre/{genre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAnimesByGenre(@PathVariable String genre) {
        return new ResponseEntity<>(animeShopService.getAnimeByGenre(genre), HttpStatus.OK);
    }

    @RequestMapping(value = "title/{title}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAnimeByTitle(@PathVariable String title) {
        return new ResponseEntity<>(animeShopService.getAnimeByTitle(title), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateAnime(@RequestBody Anime anime) {
        animeShopService.updateAnime(anime);
        return new ResponseEntity<>("successfully updated", HttpStatus.OK);
    }

}
