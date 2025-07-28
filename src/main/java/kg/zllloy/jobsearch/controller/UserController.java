package kg.zllloy.jobsearch.controller;

import kg.zllloy.jobsearch.dao.UserDao;
import kg.zllloy.jobsearch.dto.UserDto;
import kg.zllloy.jobsearch.exceptions.UserNotFoundException;
import kg.zllloy.jobsearch.model.User;
import kg.zllloy.jobsearch.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    private final UserDao userDao;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/name/{name}")
    public List<User> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @GetMapping("/phone/{phone}")
    public List<User> findByPhone(@PathVariable String phone) {
        return userService.getByPhone(phone);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        try {
            User user = userService.getByEmail(email);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Произошла внутренняя ошибка сервера");
        }
    }

    private User getUserById(int id) {
        return userDao.getUserById(id)
        .orElseThrow(UserNotFoundException::new);
    }

    @PostMapping
    public HttpStatus createUser(@RequestBody User userDto) {
        userService.createUser(userDto);
        return HttpStatus.OK;
    }

    @GetMapping("vacancy/{vacancyId}")
    public ResponseEntity<List<UserDto>> getApplicantsByVacancy(@PathVariable int vacancyId) {
        List<UserDto> applicants = userService.getApplicantsByVacancy(vacancyId);
        if (applicants.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(applicants);
    }

}
