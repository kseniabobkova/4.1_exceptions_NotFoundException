package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();


    private Book first = new Book(1, "first", 100, "author1", 50, 2021);
    private Book second = new Book(2, "second", 100, "author1",100,1999);
    private Book third = new Book(3, "first", 200, "author2", 51,1984);
    private Book fourth = new Book(4, "third", 300, "author3", 201, 2007);
    private Book fifth = new Book(5, "fourth", 200, "author3", 333, 1651);


    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);

    }

    @Test
    void souldRemoveByIdExist() {
            repository.removeById(3);

            Product[] expected = new Product[]{first, second,fourth,fifth};
            Product[] actual = repository.findAll();
            assertArrayEquals(expected, actual);
        }

    @Test
    void shouldRemoveByIdNotExist() {
        assertThrows(NotFoundException.class, () -> repository.removeById(6));
    }

}
