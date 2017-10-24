package by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.intexsoft.adsboard.model.Category;

/**
 * ��������� ��� ��������� CRUD �������� ����������� ���� {@link Category}
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	Category findById(long categoryId);
}
