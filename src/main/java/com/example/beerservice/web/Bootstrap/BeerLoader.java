package com.example.beerservice.web.Bootstrap;

import com.example.beerservice.web.domain.Beer;
import com.example.beerservice.web.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner
{
    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count()==0){
            beerRepository.save(Beer.builder()
                    .beerName("Mango")
                    .beerStyle("JPA")
                    .upc(3370100001L)
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("12.95")).build());

            beerRepository.save(Beer.builder()
                    .beerName("Apple")
                    .beerStyle("JPA")
                    .upc(3370100002L)
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("12.16")).build());
        }

        System.out.println("Beer" + beerRepository.count());
    }
}
