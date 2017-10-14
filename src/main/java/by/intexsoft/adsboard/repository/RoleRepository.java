package by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.intexsoft.adsboard.model.Role;

/**
 * ��������� ��� ��������� CRUD �������� ����������� ���� {@link Role}
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	/**
	 * ������� {@link Role} ��������� ������� ���� ������
	 * 
	 * @param role
	 *            �������� ���������� ������� {@link Role}
	 * @return ��������� ��������� ������� {@link Role}
	 */
	Role findByRole(String role);
}
