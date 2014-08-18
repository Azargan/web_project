package by.azargan.repository;

import by.azargan.data.Test;
import org.springframework.data.neo4j.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aliaksei_Vihuro
 */
@Repository(value = "testRepository")
public interface TestRepository extends CRUDRepository<Test> {

}
