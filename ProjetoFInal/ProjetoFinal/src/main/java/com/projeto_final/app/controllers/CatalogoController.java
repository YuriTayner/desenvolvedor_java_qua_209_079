package com.projeto_final.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

import com.projeto_final.app.models.Catalogo;
import com.projeto_final.app.models.Empresa;
import com.projeto_final.app.models.Usuario;
import com.projeto_final.app.repository.CatalogoRepository;





@Controller
public class CatalogoController {
    @Autowired
    private CatalogoRepository catalogoRepository;

    @PostMapping("/cadastrarCatalogo")
    public String cadastrarCatalogo(Catalogo catalogo, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        Empresa empresa = (Empresa) session.getAttribute("empresaLogada");
        if (usuario == null || empresa == null) {
            return "redirect:/";
        }
        catalogo.setEmpresa(empresa);
        catalogoRepository.save(catalogo);
        return "redirect:/empresaLogged?" + "idUsuario=" + usuario.getIdUsuario() + "&idEmpresa=" + empresa.getIdEmpresa();     
    }

    @RequestMapping(value="/listarCatalogo", method=RequestMethod.GET)
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("listar");
        Iterable<Catalogo> catalogos = catalogoRepository.findAll();
        mv.addObject("catalogos", catalogos);
        return mv;
    }

}
