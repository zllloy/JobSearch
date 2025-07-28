package kg.zllloy.jobsearch.controller;

import jakarta.validation.Valid;
import kg.zllloy.jobsearch.model.User;
import kg.zllloy.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody @Valid User user) {
        return userService.createUser(user);
    }
}
