package com.projeto_final.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

import com.projeto_final.app.models.Empresa;
import com.projeto_final.app.models.Usuario;
import com.projeto_final.app.repository.EmpresaRepository;

@Controller
public class EmpresaController {
    @Autowired
    private EmpresaRepository empresaRepository;


    @PostMapping("/cadastrarEmpresa")
    public String cadastrarEmpresa(Empresa empresa, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            return "redirect:/";
        }
        empresa.setUsuario(usuario);
        empresaRepository.save(empresa);
        session.setAttribute("empresaLogada", empresa);
        return "redirect:/empresaLogged?" + "idUsuario=" + usuario.getIdUsuario() + "&idEmpresa=" + empresa.getIdEmpresa();
    }

    @RequestMapping(value="/listarEmpresa", method=RequestMethod.GET)
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("listarEmpresa");
        Iterable<Empresa> empresas = empresaRepository.findAll();
        mv.addObject("empresas", empresas);
        return mv;
    }

    @PostMapping("/editarEmpresa")
    public String editarUsuario(@RequestParam String nomeFantasia,
            @RequestParam String descricaoEmpresa,
            @RequestParam String cnpj,
            HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        Empresa empresa = (Empresa) session.getAttribute("empresaLogada");
        if (empresa != null) {
            empresa.setNomeFantasia(nomeFantasia);
            empresa.setDescricaoEmpresa(descricaoEmpresa);
            empresa.setCnpj(cnpj);
            empresaRepository.save(empresa);
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/indexLogged/" + usuario.getIdUsuario();
        }
        return "redirect:/";
    }
}
