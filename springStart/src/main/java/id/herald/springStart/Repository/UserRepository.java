package id.herald.springStart.Repository;

import id.herald.springStart.Model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTable,Long> {
    boolean existsByUsernameAndPassword(String username,String password);
}
