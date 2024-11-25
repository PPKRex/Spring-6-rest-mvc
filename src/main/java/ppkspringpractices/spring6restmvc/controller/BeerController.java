package ppkspringpractices.spring6restmvc.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import ppkspringpractices.spring6restmvc.modal.Beer;
import ppkspringpractices.spring6restmvc.service.BeerService;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {

    private final BeerService beerService;

    public Beer getBeerById(UUID id){
        log.debug("getBeerById - in controller");

        return beerService.getBeerById(id);
    }
}
