package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.Collection;
import java.util.HashMap;

public class UserData {
    private static final HashMap<Integer, User> users = new HashMap<>();

    public static void add(User newUser) {
        users.put(newUser.getId(), newUser);
    }

    public static User getById(int id) {
        return users.get(id);
    }


    public static Collection<User> getAll() {
        return users.values();
    }
}
