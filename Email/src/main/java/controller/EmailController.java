package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/email")
public class EmailController {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public EmailController(){
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    @GetMapping("/list")
    public ModelAndView getList(){
        ModelAndView modelAndView = new ModelAndView("list");
        return modelAndView;
    }
    @PostMapping("/validate")
    public String validateEMail(@RequestParam String email, ModelAndView modelAndView){
        boolean isvalid = this.validate(email);
        if (!isvalid){
            modelAndView.addObject("message", "Email in validate");
            return "list";
        }
        modelAndView.addObject("email", email);
        return "success";
    }
    private boolean validate(String regex){
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
