package com.projeto_final.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

import com.projeto_final.app.models.Usuario;
import com.projeto_final.app.repository.AppRepository;

@Controller
public class LoginController {
    @Autowired
    private AppRepository csr;

    @GetMapping("/login")
    public String showLoginForm(HttpSession session) {
        if (session.getAttribute("usuarioLogado") != null) {
            return "redirect:/indexLogged";
        }
        return "indexLogged";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email,
            @RequestParam String senha,
            HttpSession session,
            Model model) {
        Usuario usuario = csr.findByEmail(email);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/indexLogged/" + usuario.getIdUsuario();
        }

        model.addAttribute("error", "Email ou senha inválidos");
        return "indexLogged";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
