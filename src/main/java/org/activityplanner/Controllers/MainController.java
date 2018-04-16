package org.activityplanner.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

// Not a freaking RestController...
@Controller
public class MainController {

    @Autowired
    DataSource dataSource;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/new")
    public String addUser(@RequestParam String username, @RequestParam String password) {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        template.update("INSERT INTO users(username, password) VALUES ('"
                + username + "', '" + passwordEncoder.encode(password) + "')");
        System.out.println("Password: " + password);
        System.out.println(passwordEncoder.encode("password"));
        System.out.println(passwordEncoder.encode(password));
        System.out.println("Database updated");
        return "home";
    }
}
