package sg.edu.nus.iss.app.SSF.controller;

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

//etc - ??? clean up later
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.edu.nus.iss.app.SSF.model.Pizza;
import sg.edu.nus.iss.app.SSF.service.AppService;

@Controller
@RequestMapping(path="/")
public class PizzaController {

    @Autowired //(wrkshp14,16,17)
    private AppService appSvc;

    @PostMapping (path="/pizza")
    public String postOrder(@Valid Pizza pizza, 
        BindingResult bResult, Model model){
         if(bResult.hasErrors()){
             return "index";
         }
         return "view1";
    }
    
    // @GetMapping(path="") //(wrkshp14,16,17)
    // @PutMapping(path="{}") //(wrkshp16)
}