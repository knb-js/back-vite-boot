package app.viteboot.service;

import app.viteboot.entity.UserEntity;
import app.viteboot.vo.UserLoginVO;
import app.viteboot.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    List<UserEntity> findAllUser();

    UserEntity findAllUserByRut(@Param("rut") String rut);

    Integer registerUser(@Param("userVO") UserVO userVO);;

    List<UserEntity> loginUser(@Param("userVO") UserLoginVO userVO);

}
