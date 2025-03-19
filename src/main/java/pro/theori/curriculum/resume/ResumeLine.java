package pro.theori.curriculum.resume;

import lombok.Data;

@Data
public class ResumeLine {

    Integer aar;
    String periode;
    String beskrivelse;
    String ved;
    Boolean personlig;

    public ResumeLine(){

    }
}
