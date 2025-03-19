package pro.theori.demo.projects;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "projects")
public class Project {
    @Id
    private ObjectId _id;
    private String kunde;
    private ProjectPeriod periode;
    private String beskrivelse;
    private List<String> teknologier;
    private List<ProjectRole> roller;

    public Project(){

    }
}