package com.freeCinema.cinema.controller;

import org.apache.logging.log4j.message.EntryMessage;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.freeCinema.cinema.model.User;
import com.freeCinema.cinema.repository.UserRepository;
import com.freeCinema.cinema.service.InternalServerException;

// TODO
// Создайте модель пользователя (User) с необходимыми полями (например, id, имя, фамилия, email, пароль и т.д.).
// Создайте интерфейс репозитория (UserRepository), расширяющий CrudRepository из Spring Data JDBC.
// Создайте сервис (UserService), который будет содержать методы для добавления пользователя (регистрации) и поиска пользователя по email-адресу.
// Создайте контроллер (UserController), который будет обрабатывать запросы на регистрацию пользователя.
// В контроллере создайте POST-метод handleRegistrationForm, который будет обрабатывать POST-запросы на /registration.
// Внутри метода handleRegistrationForm получите данные из формы (POST-параметры) и создайте объект User.
// Проверьте, что пользователь с таким email-адресом еще не зарегистрирован в системе (используя метод сервиса).
// Если пользователь с таким email-адресом уже есть, верните ошибку (например, через объект BindingResult) и выведите ее на странице регистрации.
// Если пользователь с таким email-адресом не зарегистрирован, сохраните его в базе данных (используя метод сервиса) и перенаправьте пользователя на страницу успешной регистрации.
// Создайте страницу регистрации (registration.html) с формой для ввода данных пользователя.
// На странице регистрации добавьте JavaScript-код для проверки введенных данных до отправки формы (например, проверка на совпадение паролей и наличие обязательных полей).

@Controller
public class UserController {
    private UserRepository userRepository;
    
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping(path = "/registration")
    public String getQuestionForm() {
        return "registration";
    }

    @GetMapping(path = "/error")
    public String getErrorForm() {
        return "error";
    }

    public boolean existsByField(String fieldValue1, String fieldValue2) {
        return userRepository.findByNameAndPassword(fieldValue1, fieldValue2) != null;
    }

    @PostMapping(path = "/registration")
    public String handleRegistrationForm(@ModelAttribute("user") User user) {
        try {
            if(existsByField(user.getUsername(), user.getPassword()) == false) {
            userRepository.save(user);
        }
        }catch(InternalServerException ex) {
            System.out.println("ex");
        }
        return "jj";
    }

    @ModelAttribute(name = "user")
    public User user() { 
        return new User();
    }
}