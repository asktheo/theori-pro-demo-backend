package pro.theori.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pro.theori.demo.projects.Project;

public interface ProjectMongoRepository extends MongoRepository<Project, Integer> {


}
