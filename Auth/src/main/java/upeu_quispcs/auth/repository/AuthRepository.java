package upeu_quispcs.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu_quispcs.auth.entity.AuthUser;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<AuthUser, Integer> {
    Optional<AuthUser> findByUserName(String userName);
}
