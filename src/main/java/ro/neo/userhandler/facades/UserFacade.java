package ro.neo.userhandler.facades;


import ro.neo.userhandler.dto.UserDTO;

import java.util.List;

public interface UserFacade {
    void save(UserDTO userDTO);

    List<UserDTO> findAll();

    UserDTO getByEmail(String email);

    void delete(UserDTO userDTO);
}
