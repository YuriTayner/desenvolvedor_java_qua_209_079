package com.projeto_final.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

import com.projeto_final.app.models.Usuario;
import com.projeto_final.app.repository.AppRepository;

@Controller
public class UsuarioController {
    @Autowired
    private AppRepository csr;

    @PostMapping("/")
    public String cadastrarUsuario(Usuario usuario) {
        csr.save(usuario);
        return "redirect:/indexLogged/" + usuario.getIdUsuario();
    }

    @GetMapping("/excluirUsuario")
    public String excluirUsuario(@RequestParam long idUsuario, HttpSession session) {
        Usuario usuario = csr.findByIdUsuario(idUsuario);
        if (usuario != null) {
            csr.delete(usuario);
            session.invalidate();
        }
        return "redirect:/";
    }

    @PostMapping("/editar")
    public String editarUsuario(@RequestParam String nomeUsuario,
            @RequestParam String email,
            @RequestParam String senha,
            HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario != null) {
            usuario.setNomeUsuario(nomeUsuario);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            csr.save(usuario);
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/indexLogged/" + usuario.getIdUsuario();
        }
        return "redirect:/";
    }
}
