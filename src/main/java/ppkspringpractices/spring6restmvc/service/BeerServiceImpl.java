package ppkspringpractices.spring6restmvc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ppkspringpractices.spring6restmvc.modal.Beer;
import ppkspringpractices.spring6restmvc.modal.BeerStyle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Get Beer by id: " + id);

        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Cruzcampo")
                .beerStyle(BeerStyle.WHEAT)
                .upc("12345678")
                .price(new BigDecimal("0.99"))
                .quantityOnHand(50)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
