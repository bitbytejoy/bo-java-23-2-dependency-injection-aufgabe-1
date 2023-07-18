package de.neuefische.bojava232dependencyinjectionaufgabe1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class ShopServiceTest {

    @Test
    public void listProducts_whenList_thenProducts() {
        ProductRepo productRepo = Mockito.mock(ProductRepo.class);
        Mockito.when(productRepo.list()).thenReturn(List.of(new Product("10", "Bannane")));

        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Assertions.assertEquals(
                List.of(new Product("10", "Bannane")),
                shopService.listProducts()
        );

        Mockito.verify(productRepo).list();
    }

}