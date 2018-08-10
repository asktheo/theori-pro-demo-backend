package pro.theori.demo.skills;

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
