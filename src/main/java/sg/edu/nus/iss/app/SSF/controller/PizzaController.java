package sg.edu.nus.iss.app.SSF.controller;

import java.util.UUID;

//controller(wrkshp17) - ??? clean up later
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


//RESTcontroller(wrkshp16) - ??? clean up later
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.validation.Valid;
import redis.clients.jedis.Response;
import sg.edu.nus.iss.app.SSF.model.Pizza;
import sg.edu.nus.iss.app.SSF.service.PizzaService;

@Controller
@RequestMapping(path="/")
public class PizzaController {

    @Autowired //(wrkshp14,16,17)
    private PizzaService pizzaSvc;

    // @GetMapping(path ="/pizza")
    // public String getOrder(Model model) {
    //     model.addAttribute("orderDetails", new Pizza());
    //     return "view1";
    // }

    @PostMapping("/pizza")
    public String savePizza(@Valid Pizza pizzaOrder, BindingResult bResult, RedirectAttributes redirectAttributes){
        if(bResult.hasErrors()){
            redirectAttributes.addFlashAttribute("error", "Invalid inputs");
            return "index";
        }
        String orderId = UUID.randomUUID().toString().substring(0,8);
        pizzaOrder.setOrderId(orderId);
        redisTemplate.opsForValue().set(orderId,pizzaOrder);
        redirectAttributes.addFlashAttribute("message", "Order successfully placed. Order ID:"+orderId);
    }


    // @PostMapping (path="/pizza/order", consumes= "application/x-www-form-urlencoded",
    //     produces="text/html")
    // public String postOrder(@Valid Pizza pizza, 
    //     BindingResult bResult, Model model, HttpServletResponse reponse) {
    //     if(bResult.hasErrors()){
    //         return "index";
    //     }
    //     model.addAttribute("orderDetails", pizza);
    //     response.setStatus(HttpServletResponse.SC_CREATED);
    //     return "view1";
    // }

    // @PostMapping (path="/pizza/{order}")

    
    // @GetMapping(path="") //(wrkshp14,16,17)
    // @PutMapping(path="{}") //(wrkshp16)
}