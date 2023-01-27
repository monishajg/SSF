package sg.edu.nus.iss.app.SSF.service;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

// import sg.edu.nus.iss.app.SSF.model.Model; (wrkshp14,16,17)

@Service // class contains business logic and can be used by other classes
public class PizzaService {

    // private static final String CONTACT_ENTITY = "contactlist";

    @Autowired
    RedisTemplate<String, Object> redisTemplate; //same in workshop14,16, store persistence methods

    public void save() {
    //     System.out.println("mds >>>>>>>>");
         redisTemplate.opsForValue().set("key","value");
    }

    // public void save() {
    //     redisTemplate.opsForList()
    //         .leftPush(CONTACT_ENTITY, "____value");
    //     redisTemplate.opsForHash()
    //         .put(CONTACT_ENTITY+"_Map","___hashkey","___value");
    // }

}