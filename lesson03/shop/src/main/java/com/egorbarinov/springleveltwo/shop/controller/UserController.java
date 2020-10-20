package com.egorbarinov.springleveltwo.shop.controller;

import com.egorbarinov.springleveltwo.shop.domain.User;
import com.egorbarinov.springleveltwo.shop.dto.UserDto;
import com.egorbarinov.springleveltwo.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Objects;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.getAll());
        return "userlist";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new UserDto());
        return "user";
    }

    @PostMapping(value = "/new")
    public String saveUser(@ModelAttribute("user") @Valid UserDto dto, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "user";
        }

        if (!dto.getPassword().equals(dto.getMatchingPassword())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "user";
        }
        if (dto.getUsername() == null) {
            model.addAttribute("amountError", "Поле не может быть пустым. Введите значение!");
            return "user";
        }

        if (dto.getEmail() == null) {
            model.addAttribute("amountError", "Поле не может быть пустым. Введите значение!");
            return "user";
        }

        if (!userService.save(dto)){
            model.addAttribute("usernameError", "Пользователь с таким именем или email уже существует");
            return "user";
        }
        return "redirect:/users";

    }

    @GetMapping("/profile")
    public String profileUser(Model model, Principal principal){
        if(principal == null){
            throw new RuntimeException("You are not authorize");
        }
        User user = userService.findByName(principal.getName());

        UserDto dto = UserDto.builder()
                .username(user.getName())
                .email(user.getEmail())
                .build();
        model.addAttribute("user", dto);
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfileUser(UserDto dto, Model model, Principal principal){
        if(principal == null
                || !Objects.equals(principal.getName(), dto.getUsername())){
            throw new RuntimeException("You are not authorize");
        }
        if(dto.getPassword() != null
                && !dto.getPassword().isEmpty()
                && !Objects.equals(dto.getPassword(), dto.getMatchingPassword())){
            model.addAttribute("user", dto);
            return "/users/profile";
        }

        userService.updateProfile(dto);
        return "redirect:/users/profile";
    }

}
