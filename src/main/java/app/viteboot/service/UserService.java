package app.viteboot.service;

import app.viteboot.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAllUser();

}
