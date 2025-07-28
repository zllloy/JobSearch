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

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public List<User> findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public List<User> getByPhone(String phone) {
        return userDao.getByPhone(phone);
    }

    @Override
    public User getByEmail(String email) {
        return userDao.getByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User createUser(UserDto userDto) {
        User newUser = new User();
        newUser.setName(userDto.getName());
        newUser.setUsername(userDto.getUsername());
        newUser.setAge(userDto.getAge());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(userDto.getPassword());
        newUser.setPhoneNumber(userDto.getPhoneNumber());
        newUser.setAvatar(userDto.getAvatar());
        newUser.setAccountType(userDto.getAccountType());
        return newUser;
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id).orElseThrow(UserNotFoundException::new);
    }


    public List<User> getApplicantsByVacancy(int vacancyId) {
        return userDao.getApplicantsByVacancy(vacancyId);
    }
}
