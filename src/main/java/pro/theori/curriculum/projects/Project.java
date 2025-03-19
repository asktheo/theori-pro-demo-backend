package pro.theori.curriculum.projects;

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
    private String url;
    private String cvs_backend;
    private String cvs_frontend;

    public Project(){

    }
}