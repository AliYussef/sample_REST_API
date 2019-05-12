package nl.inholland.repository;

import nl.inholland.model.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {
    Iterable<Stock> getAllByQuantityGreaterThanEqualOrderByQuantityDesc(int min);
}
