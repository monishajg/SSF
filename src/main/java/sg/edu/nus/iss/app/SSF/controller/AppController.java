package sg.edu.nus.iss.app.SSF.controller;

//controller(wrkshp17) - ??? clean up later
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import sg.edu.nus.iss.app.SSF.service.AppService;

// @Controller // @RestController
@RequestMapping(path="/") // - ??? clean up later
public class AppController {

    //@Autowired //(wrkshp14,16,17)
    //private AppService appSvc;

    // @GetMapping(path="") //(wrkshp14,16,17)
    // public ???type? getSomething(Model model,){

    //     return "result";
    // }

    //@PostMapping //(path="") //(wrkshp14,16)
    //public ???type? postSomething(Model model,){
    //public String getUser() {
    //    System.out.println("Hellloooo");
    //    appService.saveGame();
    //    return "hello";
    //}
    //     return "result";
    // }

    // @PutMapping(path="{}") //(wrkshp16)
}