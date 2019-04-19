package dao;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import unit.User;

@Repository
public class CityDAO {
	private ConcurrentMap<Long, User> repository = new ConcurrentHashMap<>();
	private static final AtomicLong idGenerator = new AtomicLong(0);
	
	public Long save(User city) {
        Long id = idGenerator.incrementAndGet();
        city.setId(id);
        repository.put(id, city);
        return id;
    }
	
	public Collection<User> findAll() {
        return repository.values();
    }
	
	public User findCityById(Long id) {
        return repository.get(id);
    }
	
	public Long updateCity(User city) {
        repository.put(city.getId(), city);
        return city.getId();
    }
	
	public Long deleteCity(Long id) {
        repository.remove(id);
        return id;
    }
}
