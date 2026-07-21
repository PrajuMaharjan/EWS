package id.herald.springStart.Controller;

import id.herald.springStart.Model.UserTable;
import id.herald.springStart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("deleteUser")
    public String deleteUser(@RequestParam("id") int id , Model m)
    {
        userRepository.deleteById((long) id);
        m.addAttribute("totalUsers",userRepository.findAll());

        return "home";
    }

    @PostMapping("editUser")
    public String editUser(@RequestParam("id") int id , Model m)
    {
        Optional<UserTable> ut=userRepository.findById((long) id);
        if(ut.isPresent()){
            UserTable user=ut.get();
            m.addAttribute("user",user);
            return "editPage";
        }
        m.addAttribute("totalUsers",userRepository.findAll());
        return "home";
    }

    @PostMapping("updateUser")
    public String updateUser(@ModelAttribute UserTable user,Model m)
    {
        userRepository.save(user);

        m.addAttribute("totalUsers",userRepository.findAll());
        return "home";

    }

}