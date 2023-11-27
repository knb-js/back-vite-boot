package app.viteboot.service.impl;

import app.viteboot.entity.UserEntity;
import app.viteboot.mapper.UserMapper;
import app.viteboot.service.UserService;
import app.viteboot.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public UserEntity findAllUserByRut(String rut) {
        return userMapper.findAllUserByRut(rut);
    }

    @Override
    public Integer registerUser(UserVO userVO) {
        return userMapper.registerUser(userVO);
    }


}
