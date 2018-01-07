package xyz.theone.springbootlearning.swagger.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import xyz.theone.springbootlearning.swagger.model.User;

import java.util.*;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor winson
 * @create 2018-01-06 23:52
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static Map<Long,User> userMap = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation("获取用户列表")
    @GetMapping("/list")
    public List<User> listUser(){
        List<User> users = new ArrayList<>();
        for (Map.Entry<Long,User> userEntry : userMap.entrySet()){
            users.add(userEntry.getValue());
        }
        return users;
    }

    @ApiOperation("新增用户")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User")
    @PostMapping("/add")
    public Boolean addUser(@RequestBody User user){
        if (userMap.get(user.getId()) != null){
            return false;
        }else {
            userMap.put(user.getId(), user);
            return true;
        }
    }

    @ApiOperation("根据用户ID获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id){
        return userMap.get(id);
    }

    @ApiOperation("删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/delete/{id}")
    public Boolean deleteUserById(@PathVariable("id") Long id){
        User user = userMap.remove(id);
        if (user != null){
            return true;
        }else {
            return false;
        }
    }

    @ApiOperation("修改用户信息")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User")
    @PostMapping("/update")
    public Boolean updateUser(@RequestBody User user){
        if (userMap.get(user.getId()) == null){
            return false;
        }
        userMap.put(user.getId(), user);
        return true;
    }
}