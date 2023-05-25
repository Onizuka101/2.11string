package Service;

import component.Basket;
import model.Item;
import Reposirory.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;

@Service
public class StoreService {
    private final Basket basket;
    private final StoreRepository storeRepository;

    public StoreService(Basket basket, StoreRepository storeRepository) {
        this.basket = basket;
        this.storeRepository = storeRepository;
    }

    public void add(Set<Integer> ids) {
        basket.add(ids);
    }
    public List<Item> get() {
        return basket.get().stream()
                .map(id->storeRepository.get(id))
                .collect(Collectors.toList());
    }

}
