package in.coderarmy.service;

import in.coderarmy.model.User;

import java.util.*;

public class UserService {

    private Map<Integer, User> userDB;

    public UserService() {
        this.userDB = new HashMap<>();
    }

    public User createUser(User newUser) {
        userDB.put(newUser.getId(), newUser);

        return userDB.get(newUser.getId());
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userDB.values());
    }

    public User getUserById(Integer id) {
        return userDB.getOrDefault(id, null);
    }

    public User updateUser(User existingUser, String updateName,
                           String updateEmail, String updateMobile) {

        existingUser.setName(updateName);
        existingUser.setEmail(updateEmail);
        existingUser.setMobile(updateMobile);

        userDB.put(existingUser.getId(), existingUser);

        return userDB.get(existingUser.getId());
    }

    public void deleteUser(Integer id) {
        userDB.remove(id);
    }



}
