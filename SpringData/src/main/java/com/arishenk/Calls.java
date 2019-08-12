package com.arishenk;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Document
@NoArgsConstructor
@Table(name="calls")
public class Calls {

    public Calls(Integer id_userFirst, Integer id_userSecond, String time, Date date) {
        this.id_userFirst = id_userFirst;
        this.id_userSecond = id_userSecond;
        this.time = time;
        this.date = date;
    }

    @Getter
    @Setter
    private Integer id_userFirst;

    @Getter
    @Setter
    private Integer id_userSecond;

    @Getter
    @Setter
    private String time;

    @Getter
    @Setter
    private Date date;
}