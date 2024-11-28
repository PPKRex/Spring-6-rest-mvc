package ppkspringpractices.spring6restmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ppkspringpractices.spring6restmvc.dto.BeerDTO;
import ppkspringpractices.spring6restmvc.entities.Beer;
import ppkspringpractices.spring6restmvc.repositories.BeerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class BeerControllerIT {
    @Autowired
    BeerController controller;

    @Autowired
    BeerRepository repository;
    @Autowired
    private BeerRepository beerRepository;

    @Test
    void testListBeers() {
        List<BeerDTO> dtos = controller.listBeers();

        assertThat(dtos.size()).isEqualTo(3);
    }

    @Test
    void testGetById() {
        Beer beer = beerRepository.findAll().get(0);

        Optional<BeerDTO> dto = controller.getBeerById(beer.getId());

        assertThat(dto).isNotNull();
    }

    @Test
    void testBeerIdNotFound() {
        assertThrows(NotFoundException.class, () -> {
            controller.getBeerById(UUID.randomUUID());
        });

    }

    @Rollback
    @Transactional
    @Test
    void testEmptyList() {
        beerRepository.deleteAll();
        List<BeerDTO> dtos = controller.listBeers();

        assertThat(dtos.size()).isEqualTo(0);
    }
}