package ro.neo.userhandler.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.neo.userhandler.entities.UserEntity;
import ro.neo.userhandler.repositories.UserRepository;
import ro.neo.userhandler.services.UserService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(final UserEntity userEntity) {
        userEntity.setPassword(this.passwordEncoder.encode(userEntity.getPassword()));
        this.userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> findAll() {
        final Iterable<UserEntity> userEntities = this.userRepository.findAll();
        final List<UserEntity> userEntityList = new ArrayList<>();

        for (final UserEntity userEntity : userEntities) {
            userEntityList.add(userEntity);
        }
        return userEntityList;
    }


    @Override
    public UserEntity getByEmail(final String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public void delete(final UserEntity userEntity) {
        this.userRepository.delete(userEntity);
    }
}
