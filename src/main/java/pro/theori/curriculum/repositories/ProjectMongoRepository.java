package pro.theori.curriculum.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pro.theori.curriculum.projects.Project;

public interface ProjectMongoRepository extends MongoRepository<Project, Integer> {


}
