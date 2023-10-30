package app.viteboot.mapper;

import app.viteboot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
