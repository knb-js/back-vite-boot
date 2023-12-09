package app.viteboot.controller;

import app.viteboot.dto.ResponseDTO;
import app.viteboot.entity.UserEntity;
import app.viteboot.service.UserService;
import app.viteboot.vo.UserLoginVO;
import app.viteboot.vo.UserVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
@Log4j2
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    ResponseEntity<ResponseDTO> getAllUser() {

        ResponseDTO resp = ResponseDTO.builder().build();

        List<UserEntity> userList = userService.findAllUser();

        try {
            if(userList != null){
                resp = ResponseDTO
                        .builder()
                        .status(Objects.nonNull(userList))
                        .message(Objects.nonNull(userList) ? "Usuarios obtenidos con éxito" : "Ha ocurrido un error al obtener los usuarios")
                        .data(userList)
                        .build();
            }
            log.info("Usuarios obtenidos con éxito");
            return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("ERROR, no se encontraron los usuarios");
            return new ResponseEntity<ResponseDTO>(resp, HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/users/registerUser")
    public @ResponseBody ResponseDTO registerUser(@RequestBody UserVO request){

        ResponseDTO responseDTO = new ResponseDTO();

        Integer register = userService.registerUser(request);

        try {
            if(register != null){
                responseDTO = ResponseDTO
                        .builder()
                        .status(Objects.nonNull(register))
                        .message(Objects.nonNull(register) ? "Usuario registrado con éxito" : "Ha ocurrido un error al registrar el usuarios")
                        .data(register)
                        .build();

                log.info("Usuario registrado con éxito");
                return responseDTO;
            }else{
                log.info("ERROR, el usuario se encuentra vacio");
                return null;
            }
        } catch (Exception ex) {
            log.error("ERROR, no se registró el usuario");
            return responseDTO;
        }
    }

    @PostMapping("/users/loginUser")
    public @ResponseBody ResponseDTO loginUser(@RequestBody UserLoginVO request){

        ResponseDTO responseDTO = new ResponseDTO();

        List<UserEntity> userlistLogin = userService.loginUser(request);

        try {
            if(userlistLogin != null){
                responseDTO = ResponseDTO
                        .builder()
                        .status(Objects.nonNull(request))
                        .message(Objects.nonNull(request) ? "correo y contraseña ingresado correctamente" : "correo y contraseña incorrecto")
                        .data(request)
                        .build();

                log.info("correo y contraseña ingresado correctamente");
                return responseDTO;
            }else {
                log.info("ERROR, correo o contraseña se encuentra vacio");
                return null;
            }
        } catch (Exception ex) {
            log.error("ERROR, correo y contraseña incorrecto");
            return responseDTO;
        }
    }


}
