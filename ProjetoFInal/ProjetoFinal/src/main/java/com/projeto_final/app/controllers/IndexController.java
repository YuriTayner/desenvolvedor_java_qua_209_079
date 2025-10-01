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

    // INDEX
    @GetMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("usuarioLogado") != null) {
            return "redirect:/indexLogged";
        }
        return "index";
    }

    // INDEX LOGGED
    @GetMapping({ "/indexLogged", "/indexLogged/{idUsuario}" })
    public String indexLogged(@PathVariable(required = false) Long idUsuario, HttpSession session, Model model) {
        Usuario usuario = null;
        if (idUsuario != null) {
            usuario = csr.findByIdUsuario(idUsuario);
            if (usuario == null) {
                return "redirect:/";
            }
            session.setAttribute("usuarioLogado", usuario);
        } else {
            usuario = (Usuario) session.getAttribute("usuarioLogado");
            if (usuario == null) {
                return "redirect:/";
            }
        }

        List<Empresa> empresas = empresaRepository.findByUsuario(usuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("empresas", empresas);
        return "indexLogged";
    }

    // INDEX EMPRESAS
    @GetMapping({ "/empresaLogged", "/empresaLogged/{idUsuario}/{idEmpresa}" })
    public String empresaLogged(
            @PathVariable(required = false) Long idUsuario,
            @PathVariable(required = false) Long idEmpresa,
            HttpSession session,
            Model model) {
        Usuario usuario = null;
        Empresa empresa = null;

        if (idUsuario != null && idEmpresa != null) {
            usuario = csr.findByIdUsuario(idUsuario);
            empresa = empresaRepository.findByIdEmpresa(idEmpresa);
            if (usuario == null || empresa == null) {
                return "redirect:/";
            }
            // Salva na sessão para navegação futura
            session.setAttribute("usuarioLogado", usuario);
            session.setAttribute("empresaLogada", empresa);
        } else {
            usuario = (Usuario) session.getAttribute("usuarioLogado");
            empresa = (Empresa) session.getAttribute("empresaLogada");
            if (usuario == null || empresa == null) {
                return "redirect:/";
            }
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("empresa", empresa);
        return "empresaLogged";
    }
}
