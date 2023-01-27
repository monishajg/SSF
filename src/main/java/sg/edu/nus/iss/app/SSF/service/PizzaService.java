package sg.edu.nus.iss.app.SSF.service;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.app.SSF.model.Pizza; //(wrkshp14,16,17)

@Service // class contains business logic and can be used by other classes
public class PizzaService {

    private static final String PIZZA_ENTITY = "pizzalist";

    @Autowired
    RedisTemplate<String, Object> redisTemplate; //same in workshop14,16, store persistence methods

    public void saveOrderDetails(final Pizza pizza) {
    //     System.out.println("mds >>>>>>>>");
        redisTemplate.opsForValue().set(pizza.generateId(8),pizza.toJson().toString());
    }

    public Pizza findById(final String id) {
        Pizza result = (Pizza)redisTemplate.opsForHash()
                        .get(PIZZA_ENTITY+ "_Map", id);
        return result;

    }

}