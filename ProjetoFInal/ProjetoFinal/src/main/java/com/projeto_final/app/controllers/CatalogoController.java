package com.projeto_final.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projeto_final.app.models.Catalogo;
import com.projeto_final.app.models.Empresa;
import com.projeto_final.app.models.Usuario;
import com.projeto_final.app.repository.CatalogoRepository;
import com.projeto_final.app.repository.EmpresaRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CatalogoController {
    @Autowired
    private CatalogoRepository catalogoRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @PostMapping("/cadastrarCatalogo")
    public String cadastrarCatalogo(Catalogo catalogo, HttpSession session,
            @RequestParam("empresa.idEmpresa") Long idEmpresa) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        // Empresa empresa = (Empresa) session.getAttribute("empresaLogado");
        Empresa empresa = empresaRepository.findById(idEmpresa)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        if (usuario == null) {
            return "redirect:/";
        }
        catalogo.setEmpresa(empresa);
        catalogoRepository.save(catalogo);
        return "redirect:/empresaLogged?" + "idUsuario=" + usuario.getIdUsuario() + "/idEmpresa="
                + empresa.getIdEmpresa();
    }

    @RequestMapping(value = "/listarCatalogo", method = RequestMethod.GET)
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("listar");
        Iterable<Catalogo> catalogos = catalogoRepository.findAll();
        mv.addObject("catalogos", catalogos);
        return mv;
    }
}
