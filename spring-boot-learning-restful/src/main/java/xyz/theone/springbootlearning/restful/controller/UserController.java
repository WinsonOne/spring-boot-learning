package xyz.theone.springbootlearning.restful.controller;

import org.springframework.web.bind.annotation.*;
import xyz.theone.springbootlearning.restful.model.User;

import java.util.*;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor winson
 * @create 2018-01-05 23:11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static Map<Long,User> userMap = Collections.synchronizedMap(new HashMap<>());

    @GetMapping("/list")
    public List<User> listUser(){
        List<User> users = new ArrayList<>();
        for (Map.Entry<Long,User> userEntry : userMap.entrySet()){
            users.add(userEntry.getValue());
        }
        return users;
    }

    @PostMapping("/add")
    public Boolean addUser(User user){
        if (userMap.get(user.getId()) != null){
            return false;
        }else {
            userMap.put(user.getId(), user);
            return true;
        }
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id){
        return userMap.get(id);
    }

    @GetMapping("/delete/{id}")
    public Boolean deleteUserById(@PathVariable("id") Long id){
        User user = userMap.remove(id);
        if (user != null){
            return true;
        }else {
            return false;
        }
    }

    @PostMapping("/update")
    public Boolean updateUser(User user){
        if (userMap.get(user.getId()) == null){
            return false;
        }
        userMap.put(user.getId(), user);
        return true;
    }
}
