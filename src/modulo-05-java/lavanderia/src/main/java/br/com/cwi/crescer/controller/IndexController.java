package br.com.cwi.crescer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("mensagem", "Lavanderia Crescer");

        model.addAttribute("imagem", "https://static.pexels.com/photos/2371/person-looking-searching-clean.jpg");

        return "index";
    }

}
