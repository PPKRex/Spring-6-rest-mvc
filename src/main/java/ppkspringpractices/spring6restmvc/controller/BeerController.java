package ppkspringpractices.spring6restmvc.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ppkspringpractices.spring6restmvc.dto.BeerDTO;
import ppkspringpractices.spring6restmvc.service.BeerService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    @PatchMapping("{beerId}")
    public ResponseEntity updateBeerPatchById(@PathVariable("beerId") UUID beerId,@RequestBody BeerDTO beer){

        beerService.patchBeerById(beerId,beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"{beerId}"})
    public ResponseEntity deleteById(@PathVariable("customerId") UUID beerId) {

        beerService.deleteById(beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{beerId}")
    public ResponseEntity updateById(@PathVariable("beerId") UUID beerId,@RequestBody BeerDTO beer) {

        beerService.updateBeerById(beerId,beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody BeerDTO beer) {
        BeerDTO savedBeer = beerService.saveNewBeer(beer);

        return new ResponseEntity(HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<BeerDTO> listBeers(){
        return beerService.listBeers();
    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public Optional<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId){
        log.debug("getBeerById - in controller 1234");

        return beerService.getBeerById(beerId);
    }
}
