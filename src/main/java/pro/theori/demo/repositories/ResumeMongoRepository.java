package pro.theori.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pro.theori.demo.skills.Resume;

public interface ResumeMongoRepository extends MongoRepository<Resume, Integer> {

}
