package mavenexample;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws IOException {
        User u1 = new User(1, "arishenk", "999", "arishenk@gmail.com");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("user.json"), u1);
        String userJSON = mapper.writeValueAsString(u1);
        System.out.println(userJSON);
        User u2 = mapper.readValue(new File("user.json"), User.class);
        System.out.println(u2.getId() + " " + u2.getFio() + " " + u2.getEmail() + " " + u2.getPhone());
    }
}