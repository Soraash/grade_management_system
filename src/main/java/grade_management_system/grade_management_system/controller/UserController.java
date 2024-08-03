package grade_management_system.grade_management_system.controller;

import grade_management_system.grade_management_system.entities.User;
import grade_management_system.grade_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User loginUser, HttpSession session) {
        User user = userService.findByUsername(loginUser.getUsername());
        if (user != null && user.getPassword().equals(loginUser.getPassword())) {
            session.setAttribute("user", user);
            return "Login successful";
        }
        return "Invalid credentials";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "Logged out successfully";
    }

    @GetMapping("/current")
    public User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute("user");
    }
}

