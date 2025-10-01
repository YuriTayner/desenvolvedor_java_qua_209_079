package com.projeto_final.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto_final.app.models.Catalogo;
import com.projeto_final.app.models.Empresa;
import com.projeto_final.app.models.Item;
import com.projeto_final.app.models.Usuario;
import com.projeto_final.app.repository.ItemRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/cadastrarItem")
    public String cadastrarItem(Item item, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        Empresa empresa = (Empresa) session.getAttribute("empresaLogada");
        Catalogo catalogo = (Catalogo) session.getAttribute("catalogoLogado");
        if (usuario == null) {
            return "redirect:/";
        }
        item.setCatalogo(catalogo);
        itemRepository.save(item);
        session.setAttribute("empresaLogada", empresa);
        return "redirect:/empresaLogged?" + "idUsuario=" + usuario.getIdUsuario() + "&idEmpresa=" + empresa.getIdEmpresa();
    }

    @RequestMapping(value="/listarItem", method=RequestMethod.GET)
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("listar");
        Iterable<Item> itens = itemRepository.findAll();
        mv.addObject("itens", itens);
        return mv;
    }
    
}
