package com.projeto_final.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projeto_final.app.models.Usuario;
import com.projeto_final.app.repository.AppRepository;

@Controller
public class ProjetoController {
    @Autowired
    private AppRepository csr;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String cadastrarUsuario(){
        return "index";
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String cadastrarUsuario(Usuario usuario){
        csr.save(usuario);
        return "redirect:/indexLogged";
    }

    @RequestMapping("/indexLogged")
    public String indexLogged(){
        return "indexLogged";
    }    

    // @RequestMapping(value="/indexLogged/{idUsuario}", method=RequestMethod.GET)
    // public ModelAndView indexLogged(){
    //     return "indexLogged";
    // }    TERMINAAAAAAAAAAAAAA 
}