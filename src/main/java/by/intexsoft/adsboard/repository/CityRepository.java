package by.intexsoft.adsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.intexsoft.adsboard.model.City;

/**
 * ��������� ��� ��������� CRUD �������� ����������� ���� {@link City}
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
