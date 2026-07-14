package id.herald.springStart.Controller;

import id.herald.springStart.Model.UserTable;
import id.herald.springStart.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private UserRepository uRepo;

    @GetMapping("/signupPage")
    public String signup(){
        return "signupPage";
    }

    @PostMapping("/signupPage")
    public String signupPost(HttpServletRequest request,Model m) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username: " + username);
        System.out.println("password: " + password);

        String hashPassword= DigestUtils.md5DigestAsHex(password.getBytes());

        UserTable uc=new UserTable();
        uc.setUsername(username);
        uc.setPassword(hashPassword);
        

        m.addAttribute("signupSuccess","You have successfully signed up! Login now!");

        if(uRepo.existsByUsernameAndPassword(username,hashPassword)){
            return "home";
        }
            return "signupPage";
    }
}
