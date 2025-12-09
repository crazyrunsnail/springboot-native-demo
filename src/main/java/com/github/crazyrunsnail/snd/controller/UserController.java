package com.github.crazyrunsnail.snd.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.github.crazyrunsnail.snd.mapper.UserMapper;
import com.github.crazyrunsnail.snd.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserMapper userMapper;

    @GetMapping("/users")
    public Page<User> users(PageDTO<User> pageDTO) {
        return userMapper.selectPage(pageDTO);
    }

    @GetMapping("/users/{id}")
    public User user(@PathVariable Long id) {
        return userMapper.selectById(id);
    }

    @PostMapping("/users")
    public User user(User user) {
        userMapper.insert(user);
        return userMapper.selectById(user.getId());
    }

}
