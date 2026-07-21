package id.herald.springStart.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {

    @GetMapping("/mail")
    public String mailGet(HttpServletRequest request) {
        HttpSession session=request.getSession();

        if(session.getAttribute("mail")==null){
            return "loginPage";
        }
        return  "mailPage";
    }
}
