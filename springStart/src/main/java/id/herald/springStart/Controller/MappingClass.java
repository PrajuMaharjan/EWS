package id.herald.springStart.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import id.herald.springStart.Model.UserTable;
import id.herald.springStart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;


@Controller // Handles HTTP requests : GET,POST
public class MappingClass {

    @Autowired
    private UserRepository uRepo;

    @GetMapping("/")
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
    public String loginPost(HttpServletRequest request,Model m){
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        System.out.println(username);
        System.out.println(password);

        String hashPassword= DigestUtils.md5DigestAsHex(password.getBytes());

        if(uRepo.existsByUsernameAndPassword(username,hashPassword)){
            List<UserTable> totalUsers=uRepo.findAll();
            m.addAttribute("totalUsers",totalUsers);

            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            return "home.html";
        }
        return  "loginPage.html";
    }

    @GetMapping("/home")
    public String getHome(Model m){
        m.addAttribute("totalUsers",uRepo.findAll());
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();

        return "loginPage";
    }
}