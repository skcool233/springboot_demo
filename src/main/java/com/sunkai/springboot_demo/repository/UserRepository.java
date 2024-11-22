package com.sunkai.springboot_demo.repository;

import com.sunkai.springboot_demo.pojo.User;
import com.sunkai.springboot_demo.pojo.dto.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository  //数据访问层spring的bean,等价于@Component
public interface UserRepository extends CrudRepository<User, Integer> {
}
