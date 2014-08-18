package by.azargan.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

/**
 *
 * @author Aliaksei_Vihuro
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "by.azargan.repository")
public class Neo4jConfig extends Neo4jConfiguration {

    final private String DB_PATH = "D:\\test.db";

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService() {
        setBasePackage("by.azargan.data");
        return new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH);
    }

}
