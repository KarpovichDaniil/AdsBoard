package by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.intexsoft.adsboard.model.User;

/**
 * ��������� ��� ��������� CRUD �������� ����������� ���� {@link User}
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

	User findByEnabled(boolean enabled);
}
