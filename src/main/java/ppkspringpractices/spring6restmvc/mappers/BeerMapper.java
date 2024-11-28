package ppkspringpractices.spring6restmvc.mappers;

import org.mapstruct.Mapper;
import ppkspringpractices.spring6restmvc.dto.BeerDTO;
import ppkspringpractices.spring6restmvc.entities.Beer;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDTO(Beer beer);
}
