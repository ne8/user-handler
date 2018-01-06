package ro.neo.userhandler.services;

import ro.neo.userhandler.entities.UserEntity;

import java.util.List;

public interface UserService {
    void save(UserEntity userEntity);

    List<UserEntity> findAll();

    UserEntity getByEmail(String email);

    void delete(UserEntity userEntity);
}
