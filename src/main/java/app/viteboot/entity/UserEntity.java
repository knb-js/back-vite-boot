package app.viteboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    private Integer rut;
    private String dv;
    private String name;
    private String lastName;
    private String email;
    private String phone;
}
