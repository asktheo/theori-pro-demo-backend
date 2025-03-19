package pro.theori.curriculum.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pro.theori.curriculum.resume.Resume;

public interface ResumeMongoRepository extends MongoRepository<Resume, Integer> {

}
