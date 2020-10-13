package br.prysthon.aws.project.services;

import br.prysthon.aws.project.dtos.UserDTO;
import br.prysthon.aws.project.enums.UserStatus;
import br.prysthon.aws.project.exceptions.NotFoundException;
import br.prysthon.aws.project.models.User;
import br.prysthon.aws.project.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserDTO findUserById(Long id) {
        User user = this.repository.findById(id).orElseThrow(() -> new NotFoundException(User.class.getName() + " : " + " nao foi encontrado com id" + id));
        return UserDTO.fromEntity(user);
    }

    public UserDTO save(UserDTO userDTO) {
        userDTO.setStatus(UserStatus.ATIVO.getDescription());
        User user = this.repository.save(UserDTO.fromDTO(userDTO));
        logger.info("Created user: " + user.getEmail());
        return UserDTO.fromEntity(user);
    }

    public Page<UserDTO> getAllUsers(Pageable pageable) {
        Page<User> pages = this.repository.findAll(pageable);
        return pages.map(this::convertToUserDto);
    }

    private UserDTO convertToUserDto(final User user) {
        final UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setStatus(user.getStatus().getDescription());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
