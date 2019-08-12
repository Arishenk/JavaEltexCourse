package com.arishenk;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Класс-контроллер
 * @author Arishenk
 * @version v1.0
 */
@RestController
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);

    /**
     * Метод для сопоставления с точкой входа <b>/get_users</b>
     * @return Массив объектов пользователей
     * @see User#User(Integer, String, String, String[])
     */
    @RequestMapping("/")
    public User getUser() {
        return new User(1, "Boris", "900", new String[]{"Java", "C#"});
    }

    /**
     * Метод для сопоставления с точкой входа <b>/get_user</b>
     * @param id - User#id пользователя
     * @return Объект пользователя
     * @see User#User(Integer, String, String, String[])
     */
    @RequestMapping("/admin")
    public User getUser1(/*@PathVariable("id") Integer id*/) {
        log.info("MREOW"); // обычное информационное сообщение
        log.debug("DEBUG"); // более подробное описание события (для
        log.error("ERROR"); // когда происходит ошибка в try-catch
        log.warn("WARNING"); // предупреждения
       // System.out.println(id);
        return new User(1, "Boris", "939399393", new String[]{"Java", "C++"});
    }
}
