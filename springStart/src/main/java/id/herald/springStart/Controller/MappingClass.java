package id.herald.springStart.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Handles HTTP requests : GET,POST
public class MappingClass {
    @GetMapping
    public String openFirstPage(){
        return "firstPage.html";
    }

    @GetMapping("/nextPage")
    public String openNextPage(){
        return "nextPage.html";
    }

    @GetMapping("/loginPage")
    public String openLoginPage(){
        return "loginPage.html";
    }

    @GetMapping("/signupPage")
    public String opensignPage(){
        return "signupPage.html";
    }
}
