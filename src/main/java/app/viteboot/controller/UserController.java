package app.viteboot.controller;

import app.viteboot.dto.ResponseDTO;
import app.viteboot.entity.UserEntity;
import app.viteboot.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    ResponseEntity<ResponseDTO>getAllUser(){
        ResponseDTO resp = ResponseDTO.builder().build();

        List<UserEntity> userList = userService.findAllUser();

        try{
            resp = ResponseDTO
                    .builder()
                    .status(Objects.nonNull(userList))
                    .message(Objects.nonNull(userList) ? "Usuarios obtenidos con éxito" : "Ha ocurrido un error al obtener los usuarios")
                    .data(userList)
                    .build();
            log.info("usuarios obtenidos con éxito");
            return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
        }catch (Exception ex){
            log.error("ERROR, no se encontraron los usuarios");
            return new ResponseEntity<ResponseDTO>(resp, HttpStatus.BAD_REQUEST);
        }

    }



}
