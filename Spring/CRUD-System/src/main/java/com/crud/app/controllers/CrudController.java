package com.crud.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.app.models.Pessoa;
import com.crud.app.repository.AppRepository;

import ch.qos.logback.core.model.Model;

@Controller
public class CrudController {
    @Autowired
    private AppRepository csr;
    
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/cadastrar", method=RequestMethod.GET)
    public String cadastrar(){
        return "cadastrar";
    }

    @RequestMapping(value="/cadastrar", method=RequestMethod.POST)
    public String cadastrar(Pessoa usuario){
        csr.save(usuario);
        return "redirect:/";
    }

    //lista todos os usuários cadastrados
    @RequestMapping(value="/listar", method=RequestMethod.GET)
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("listar");
        Iterable<Pessoa> usuarios = csr.findAll();
        mv.addObject("usuarios", usuarios);
        return mv;
    }
    
    @RequestMapping(value="/alterar/{idPessoa}", method=RequestMethod.GET)
    public ModelAndView alterarUsuario(@PathVariable("idPessoa") long idPessoa){
        Pessoa usuario = csr.findByIdPessoa(idPessoa);
        ModelAndView mv = new ModelAndView("alterar");
        mv.addObject("usuario", usuario);
        return mv;
    }

    @RequestMapping(value="/alterar/{idPessoa}", method=RequestMethod.POST)
    public String alterarUsuario(@Validated Pessoa usuario, BindingResult result, RedirectAttributes attributes){
        csr.save(usuario);
        return "redirect:/listar";
    }

    @RequestMapping("/excluir/{idPessoa}")
    public ModelAndView confirmarExcluir(@PathVariable("idPessoa")
    long idPessoa){
        Pessoa usuario = csr.findByIdPessoa(idPessoa);
        ModelAndView mv = new ModelAndView("excluir");
        mv.addObject("usuario", usuario);
        return mv;
    }

    @RequestMapping("/excluir")
    public String excluirUsuario(long idPessoa){
        Pessoa usuario = csr.findByIdPessoa(idPessoa);
        csr.delete(usuario);
        return "redirect:/listar";
    }
}

