package nl.inholland.controller;


import nl.inholland.service.AnimeShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/stock")
public class StockController {

    private AnimeShopService animeShopService;

    public StockController(AnimeShopService animeShopService) {
        this.animeShopService = animeShopService;
    }

    @RequestMapping(value = "{min}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAnimesInStockByQuantityMin(@PathVariable int min) {
        return new ResponseEntity<>(animeShopService.getAnimesInStockByQuantityMin(min), HttpStatus.OK);
    }
}
