package ru.webapp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.webapp.model.User;
import ru.webapp.service.ServiceDao;


@Controller
@RequestMapping("/users")
public class UserController {
    private final ServiceDao serviceImpl;

    public UserController(ServiceDao serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("allUsers", serviceImpl.getAll());
        return "users/home";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        serviceImpl.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", serviceImpl.getById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        serviceImpl.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        serviceImpl.delete(id);
        return "redirect:/users";
    }

}
