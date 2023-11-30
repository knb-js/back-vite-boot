package app.viteboot.vo;

import lombok.Builder;
import lombok.Data;

@Data
public class UserLoginVO {

    private String email;
    private String password;
}
