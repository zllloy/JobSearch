package kg.zllloy.jobsearch.service.impl;

import kg.zllloy.jobsearch.dao.UserDao;
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
                .orElseThrow(() -> {
                    return new UserNotFoundException("Пользователя с таким email не существует");
                });
    }

}
