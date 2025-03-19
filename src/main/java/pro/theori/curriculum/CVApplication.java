package pro.theori.curriculum;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pro.theori.curriculum.env.EnvVariables;
import pro.theori.curriculum.projects.Project;
import pro.theori.curriculum.repositories.ProjectMongoRepository;
import pro.theori.curriculum.repositories.ResumeMongoRepository;
import pro.theori.curriculum.repositories.SkillsMongoRepository;
import pro.theori.curriculum.resume.Resume;
import pro.theori.curriculum.skills.Skill;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;


@SpringBootApplication
public class CVApplication implements CommandLineRunner {
	@Autowired
	ProjectMongoRepository projectMongoRepository;
	@Autowired
	ResumeMongoRepository resumeMongoRepository;
	@Autowired
	SkillsMongoRepository skillsMongoRepository;


	@Bean
	public EnvVariables envVariables() {
		EnvVariables envVariables = new EnvVariables();
		envVariables.addKey(EnvVariables.SECRET, System.getenv(EnvVariables.SECRET));
		envVariables.addKey(EnvVariables.JSON_DIR, System.getenv(EnvVariables.JSON_DIR));
		return envVariables;
	}

	public static void main(String[] args) {
		SpringApplication.run(CVApplication.class, args);
	}

	public void run(String... args){

		if(projectMongoRepository.findAll().isEmpty()){
			try{
				System.out.printf("%s projects inserted in Mongo DB\n", insertProjectsFromFile());
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

		if(resumeMongoRepository.findAll().isEmpty()){
			try{
				System.out.printf("Resume inserted in Mongo DB\n", insertResumeFromFile());
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

		if(skillsMongoRepository.findAll().isEmpty()){
			try{
				System.out.printf("%s skills inserted in Mongo DB\n", insertSkillsFromFile());
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

	}

	private Integer insertProjectsFromFile() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		// Read JSON resource file
		File projectsFile = new File(envVariables().getEnvVariable(EnvVariables.JSON_DIR) + "/data/Projects.json");
		FileInputStream inputStream = new FileInputStream(projectsFile);

		List< Project> projects = objectMapper.readValue(inputStream,
				new TypeReference<>() {
				});

		// insert projects to project collection
		List<Project> inserted = projectMongoRepository.insert(projects);

		return inserted.size();
	}

	private Boolean insertResumeFromFile() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		// Read JSON resource file
		File resumeFile = new File(envVariables().getEnvVariable(EnvVariables.JSON_DIR) + "/data/Me.json");
		FileInputStream inputStream = new FileInputStream(resumeFile);

		Resume resume = objectMapper.readValue(inputStream,
				new TypeReference<>() {
				});

		// insert resume to "resume" collection
		Resume inserted = resumeMongoRepository.insert(resume);

		return resumeMongoRepository.count() == 1;
	}

	private Integer insertSkillsFromFile() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		// Read JSON resource file
		File skillsFile = new File(envVariables().getEnvVariable(EnvVariables.JSON_DIR) + "/data/skills.json");
		FileInputStream inputStream = new FileInputStream(skillsFile);

		List<Skill> skills = objectMapper.readValue(inputStream,
				new TypeReference<>() {
				});

		// insert resume to "resume" collection
		List<Skill> inserted = skillsMongoRepository.insert(skills);

		return inserted.size();
	}

}
