package pro.theori.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pro.theori.demo.skills.Skill;
import pro.theori.demo.skills.SkillKategori;

import java.util.ArrayList;

public interface SkillsMongoRepository extends MongoRepository<Skill, Integer> {
    ArrayList<Skill> findBySkillKategori(Integer kategori);
    ArrayList<Skill> findByAntalAar(Integer antalAar);
    ArrayList<Skill> findBySenestAar(Integer senestAar);
    Skill findByNavn(String navn);
}
