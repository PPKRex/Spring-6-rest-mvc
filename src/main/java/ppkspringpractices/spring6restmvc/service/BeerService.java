package ppkspringpractices.spring6restmvc.service;

import ppkspringpractices.spring6restmvc.modal.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
