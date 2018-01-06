package ro.neo.userhandler.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.neo.userhandler.entities.UserEntity;

/**
 * Created by neop on 09.04.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

    UserEntity findByNickname(String nickname);
}
