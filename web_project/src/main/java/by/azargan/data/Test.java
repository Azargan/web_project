package by.azargan.data;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 *
 * @author Aliaksei_Vihuro
 */
@NodeEntity
public class Test {

    @GraphId Long id;

}
