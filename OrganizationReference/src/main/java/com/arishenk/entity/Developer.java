package com.arishenk.entity;

import com.arishenk.People;
import com.arishenk.TypeException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@People
@NoArgsConstructor
public class Developer extends User {

    @Getter
    @Setter
    private String[] languages;

    public Integer index = 0;
    public static int countIndex = 0;

    public Developer(String fio, String phone, String email, String[] languages) {
        super(fio, phone, email);
        this.languages = languages;
        index += countIndex;
        this.setId(index);
        countIndex++;
    }

    @Override
    public String toString() {
        return super.toString() +
                "languages=" + Arrays.toString(languages) +
                '}';
    }

    public String languagesToString() {
        return String.join(",", this.languages);
    }

    public String toCSV() {
        return super.toCSV() + String.join(",", languages) + "\n";
    }

    public void fromCSV(String str) throws TypeException {
        super.fromCSV(str);
        String[] lineFromCSV = str.split(";");

        if (lineFromCSV.length != 5) {
            throw new TypeException("this type is not developer");
        }
        String[] lan = lineFromCSV[lineFromCSV.length - 1].split(",");
        this.languages = lan;
    }

    @Override
    public String toJSON(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName), this);
        return mapper.writeValueAsString(this);
    }

    @Override
    public void fromJSON(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Developer u2 = mapper.readValue(new File(fileName), Developer.class);
        this.setId(u2.getId());
        this.setLanguages(u2.languages);
        this.setPhone(u2.getPhone());
        this.setEmail(u2.getEmail());
        this.setFio(u2.getFio());
    }
}
