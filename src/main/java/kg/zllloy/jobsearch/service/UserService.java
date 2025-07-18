package kg.zllloy.jobsearch.service;

import kg.zllloy.jobsearch.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    List<User> findByName(String name);

    List<User> getByPhone(String phone);

    User getByEmail(String email);
}
