package datn.realestate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import datn.realestate.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
