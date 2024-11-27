package ppkspringpractices.spring6restmvc.service;

import ppkspringpractices.spring6restmvc.modal.BeerDTO;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<BeerDTO> listBeers();

    BeerDTO getBeerById(UUID id);

    BeerDTO saveNewBeer(BeerDTO beer);

    void updateBeerById(UUID beerId, BeerDTO beer);

    void deleteById(UUID beerId);

    void patchBeerById(UUID beerId, BeerDTO beer);
}
