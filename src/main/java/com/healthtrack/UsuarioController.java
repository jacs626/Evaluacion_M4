package com.healthtrack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {
    private Usuario usuario = new Usuario("José", 75.0);

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("nombre", usuario.getNombre());
        model.addAttribute("peso", usuario.getPeso());
        return "index";
    }

    @PostMapping("/actualizar")
    public String actualizar(@RequestParam("peso") double nuevoPeso, Model model) {
        usuario.actualizarPeso(nuevoPeso);
        model.addAttribute("nombre", usuario.getNombre());
        model.addAttribute("peso", usuario.getPeso());
        model.addAttribute("mensaje", "Peso actualizado.");
        return "index";
    }
}
