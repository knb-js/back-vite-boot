package app.viteboot.mapper;

import app.viteboot.entity.UserEntity;
import app.viteboot.vo.UserLoginVO;
import app.viteboot.vo.UserVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select  " +
            "    rut as rut, " +
            "    dv as dv, " +
            "    name as name, " +
            "    last_name as lastName, " +
            "    email as email, " +
            "    phone as phone " +
            "from user ")
    List<UserEntity> findAllUser();

    @Select("select " +
            "    rut as rut, " +
            "    dv as name, " +
            "    last_name as lastName, " +
            "    email as email, " +
            "    phone as phone " +
            "from user where rut = #{rut}")
    UserEntity findAllUserByRut(@Param("rut") String rut);


    @Insert("INSERT INTO user(rut,dv, name, last_name, email, password, phone) " +
            "VALUES(#{userVO.rut}, #{userVO.dv}, #{userVO.name}, #{userVO.lastName}, #{userVO.email}, #{userVO.password}, #{userVO.phone})")
    @Options(useGeneratedKeys = true,keyProperty = "userVO.rut",keyColumn = "rut")
    Integer registerUser(@Param("userVO") UserVO userVO);

    @Select("    select " +
            "    rut as rut, " +
            "    dv as dv, " +
            "    name as name, " +
            "    last_name as lastName, " +
            "    email as email, " +
            "    password as password, " +
            "    phone as phone " +
            "    from user " +
            "    where email = 'userVO.email' and password = 'userVO.password'")
    List<UserEntity> loginUser(@Param("userVO") UserLoginVO userVO);
}
