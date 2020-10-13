package br.prysthon.aws.project.dtos;

import br.prysthon.aws.project.enums.UserStatus;
import br.prysthon.aws.project.models.User;
import br.prysthon.aws.project.util.Utilidades;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    private String status;

    public static UserDTO fromEntity(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setCreatedAt(Utilidades.formatDate(user.getCreatedDate()));
        userDTO.setUpdatedAt(Utilidades.formatDate(user.getLastModifiedDate()));
        userDTO.setStatus(user.getStatus().getDescription());
        return userDTO;
    }
    public static User fromDTO(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setStatus(UserStatus.toEnum(userDTO.getStatus()));
        return user;
    }
}
