package pro.theori.curriculum.resume;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "person")
public class Resume {
    @Id
    private ObjectId _id;
    private String resume;
    private ArrayList<ResumeLine> tidligere;
    private ArrayList<ResumeLine> uddannelse;
    private ArrayList<ResumeLine> kurser;

    public Resume(){

    }

}
