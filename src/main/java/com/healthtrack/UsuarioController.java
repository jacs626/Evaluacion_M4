package com.healthtrack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {
    private Usuario usuario = new Usuario("José", 75.0);
    private List<Usuario> usuarios = new ArrayList<>();

    {
        usuarios.add(usuario);
    }

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

    //EndPoints para JMeter

    @ResponseBody
    @GetMapping("/api/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @ResponseBody
    @PostMapping("/api/usuarios")
    public Usuario agregarUsuario(@RequestBody Usuario nuevoUsuario) {
        usuarios.add(nuevoUsuario);
        return nuevoUsuario;
    }
}
