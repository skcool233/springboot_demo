package com.sunkai.springboot_demo.service;

import com.sunkai.springboot_demo.pojo.User;
import com.sunkai.springboot_demo.pojo.dto.UserDto;
import com.sunkai.springboot_demo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    //数据逻辑层Spring的Bean,等价于@Component
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User add(UserDto user) {

        User userPojo = new User();

        userPojo.setUserName(user.getUserName());
        userPojo.setPassword(user.getPassword());
        userPojo.setEmail(user.getEmail());
        // 保存到数据库（假设有 userRepository）
        userRepository.save(userPojo);
        return userPojo; // 返回保存后的 User 对象
        //调用数据访问类
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> {
            throw new IllegalArgumentException("用户不存在,参数异常!");
        });
    }

    @Override
    public User edit(UserDto user) {
        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);

        return userRepository.save(userPojo);
    }

    @Override
    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }
}
