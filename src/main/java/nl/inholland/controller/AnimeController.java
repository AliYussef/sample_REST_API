package nl.inholland.controller;

import nl.inholland.model.Anime;
import nl.inholland.service.AnimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping(value = "/animes")
public class AnimeController {

    private AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    // first solution without any response status

    /*@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Anime> getAllAnimes() {
        return animeService.getAnimes();
    }*/

    /*@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addAnime(@RequestBody Anime anime) {
        animeService.addAnime(anime);
    }*/

    /*@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Anime getAnime(@PathVariable int id) {
        return animeService.getAnime(id);
    }*/


    // second solution with response status
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAnimes(@RequestParam(required = false) boolean sorted,
                                            @RequestParam(required = false, defaultValue = "0") double minimum,
                                            @RequestParam(required = false, defaultValue = "" + Integer.MAX_VALUE) int pageSize) {
        return new ResponseEntity<>(animeService.getAnimes(sorted, minimum, pageSize), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAnimeById(@PathVariable int id) {
        return new ResponseEntity<>(animeService.getAnimeById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "title/{title}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAnimeByTitle(@PathVariable String title) {
        return new ResponseEntity<>(animeService.getAnimeByTitle(title), HttpStatus.OK);
    }

    @RequestMapping(value = "genre/{genre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAnimesByGenre(@PathVariable String genre) {
        return new ResponseEntity<>(animeService.getAnimesByGenre(genre), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addAnime(@RequestBody Anime anime) {
        animeService.addAnime(anime);
        return new ResponseEntity<>("Anime has been successfully added.", HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateAnime(@PathVariable int id, @RequestBody Anime anime) {
        animeService.updateAnime(id, anime);
        return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAnime(@PathVariable int id) {
        animeService.deleteAnime(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

}
