package com.arishenk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringData {
    public static void main(String[] args) {
        SpringApplication.run(SpringData.class);
    }

    @Bean // компонент контекста Spring
    public CommandLineRunner demo(UserRepository crudRepository, CallsRepository repository) {
        return (args) -> {
            crudRepository.save(new User("Ivan", "900"));
            crudRepository.save(new User("Boris", "800"));
            crudRepository.save(new User("Arina", "700"));
            crudRepository.save(new User("Masha", "600"));
            repository.save(new Calls(crudRepository.findByFio("Ivan").getId(), crudRepository.findByFio("Masha").getId(),
                    "3:15", new Date()));
            repository.save(new Calls(crudRepository.findByFio("Boris").getId(), crudRepository.findByFio("Arina").getId(),
                    "1.30", new Date()));
            for (User user : crudRepository.findAll()) {
                System.out.println(user.getFio());
            }
            for (Calls call : repository.findAll()) {
                System.out.println(call.getTime() + " " + call.getDate());
            }
        };
    }
}