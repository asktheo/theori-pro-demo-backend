package pro.theori.curriculum.skills;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "skills")
public class Skill {
    @Id
    private ObjectId _id;
    private Integer skillKategori;
    private String navn;
    private Integer niveau;
    private Integer senestAar;
    private Integer antalAar;


    public Skill(){

    }
}
