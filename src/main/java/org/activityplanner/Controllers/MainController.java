package org.activityplanner.Controllers;

import org.activityplanner.DAOs.MysqlUserDao;
import org.activityplanner.Entities.User;
import org.activityplanner.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

// Not a freaking RestController...
@Controller
public class MainController {

    @Autowired
    DataSource dataSource;

    @Autowired
    private MysqlUserDao mysqlUserDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String registerNewUser(@RequestParam String username, @RequestParam String password) {
//        JdbcTemplate template = new JdbcTemplate();
//        template.setDataSource(dataSource);
        System.out.println(username + ", " + password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        mysqlUserDao.save(user);

        System.out.println("username: " + username);
        System.out.println("pass: " + password);
        System.out.println("hashed: " + passwordEncoder.encode(password));
        return "registration";
    }

}
