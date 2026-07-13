package id.herald.springStart.Controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/loginPage")
    public String loginPost(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        System.out.println(username);
        System.out.println(password);

        if(username.equals("admin") && password.equals("admin")){
            return "home.html";
        }else{
            return  "loginPage.html";
        }
    }

}
