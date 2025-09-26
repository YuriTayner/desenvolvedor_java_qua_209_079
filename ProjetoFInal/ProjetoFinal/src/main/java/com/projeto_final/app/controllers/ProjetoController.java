package com.projeto_final.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto_final.app.models.Usuario;
import com.projeto_final.app.repository.AppRepository;

@Controller
public class ProjetoController {
    @Autowired
    private AppRepository csr;

    //request map do index
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String cadastrarUsuario(){
        return "index";
    }

    //request map do cadastrar usuario
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String cadastrarUsuario(Usuario usuario){
        csr.save(usuario);
        return "redirect:/indexLogged/{idUsuario}";
    }

    @RequestMapping(value="/indexLogged/{idUsuario}", method=RequestMethod.GET)
    public ModelAndView indexLogged(@PathVariable ("idUsuario") long idUsuario){
        Usuario usuario = csr.findByIdUsuario(idUsuario);
        ModelAndView mv = new ModelAndView("indexLogged");
        mv.addObject("usuario", usuario);
        return mv;
    }
}