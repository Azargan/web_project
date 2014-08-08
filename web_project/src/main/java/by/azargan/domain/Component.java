package by.azargan.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 *
 * @author Aliaksei_Vihuro
 */
@NodeEntity
public class Component {
    @GraphId Long id;
}
