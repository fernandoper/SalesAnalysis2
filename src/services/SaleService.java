package services;
import entities.Sale;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SaleService {
    public Map<String, Double> sumSales(Set<Sale> sales) {
        return sales.stream()
                .collect(Collectors.groupingBy(Sale::getSeller,
                        Collectors.summingDouble(Sale::getTotal)));
    }
}
