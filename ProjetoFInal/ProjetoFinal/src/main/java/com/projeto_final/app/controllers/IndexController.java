package com.projeto_final.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

import com.projeto_final.app.models.Usuario;
import com.projeto_final.app.models.Empresa;
import com.projeto_final.app.repository.AppRepository;
import com.projeto_final.app.repository.EmpresaRepository;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private AppRepository csr;

    @Autowired
    private EmpresaRepository empresaRepository;

    //INDEX
    @GetMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("usuarioLogado") != null) {
            return "redirect:/indexLogged";
        }
        return "index";
    }

    //INDEX LOGGED
    @GetMapping("/indexLogged/{idUsuario}")
    public String indexLogged(@PathVariable Long idUsuario, Model model) {
        Usuario usuario = csr.findByIdUsuario(idUsuario);
        if (usuario == null) {
            return "redirect:/";
        }
        List<Empresa> empresas = empresaRepository.findByUsuario(usuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("empresas", empresas);
        return "indexLogged";
    }

    @GetMapping("/indexLogged")
    public String indexLogged(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            return "redirect:/";
        }
        model.addAttribute("usuario", usuario);
        return "indexLogged";
    }

    //INDEX EMPRESAS
    @GetMapping("/empresaLogged")
    public String empresaLogged(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        Empresa empresa = (Empresa) session.getAttribute("empresaLogada");
        if (usuario == null || empresa == null) {
            return "redirect:/";
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("empresa", empresa);
        return "empresaLogged";
    }
}
