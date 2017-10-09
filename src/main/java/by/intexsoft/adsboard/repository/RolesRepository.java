package by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.intexsoft.adsboard.model.Roles;

/**
 * ��������� ��� ��������� CRUD �������� ����������� ���� {@link Roles}
 */
@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
	/**
	 * ������� {@link Roles} ��������� ������� ���� ������
	 * 
	 * @param role
	 *            �������� ���������� ������� {@link Roles}
	 * @return ��������� ��������� ������� {@link Roles}
	 */
	Roles findByRole(String role);
}
