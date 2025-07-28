package kg.zllloy.jobsearch.service.impl;

import kg.zllloy.jobsearch.dao.UserDao;
import kg.zllloy.jobsearch.dto.ResumeDto;
import kg.zllloy.jobsearch.dto.UserDto;
import kg.zllloy.jobsearch.exceptions.UserNotFoundException;
import kg.zllloy.jobsearch.model.User;
import kg.zllloy.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        if (userDao.getAllUsers().isEmpty()) {
            throw new IllegalArgumentException("Cейчас в базе нет никаких юзеров");
        }
        return userDao.getAllUsers();
    }

    @Override
    public List<User> findByName(String name) {
        if (userDao.existByName(name)) {
            throw new UserNotFoundException();
        }

        return userDao.findByName(name);
    }

    @Override
    public List<User> getByPhone(String phone) {
        if (userDao.existByPhone(phone)) {
            throw new UserNotFoundException();
        }

        return userDao.getByPhone(phone);
    }

    @Override
    public User getByEmail(String email) {
        if (userDao.existByEmail(email)) {
            throw new UserNotFoundException();
        }

        return userDao.getByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User createUser(User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setUsername(user.getUsername());
        newUser.setAge(user.getAge());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setAvatar(user.getAvatar());
        newUser.setAccountType(user.getAccountType());
        return newUser;
    }

    @Override
    public User getUserById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID юзера должен быть положительным");
        }

        if (userDao.existById(id)) {
            throw new UserNotFoundException();
        }


        return userDao.getUserById(id).orElseThrow(UserNotFoundException::new);
    }


    public List<UserDto> getApplicantsByVacancy(int vacancyId) {
        return userDao.getApplicantsByVacancy(vacancyId).stream()
                .map(UserDto::toDto)
                .collect(Collectors.toList());
    }
}
