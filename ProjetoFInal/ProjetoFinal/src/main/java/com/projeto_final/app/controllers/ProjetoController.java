package com.projeto_final.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;

import com.projeto_final.app.models.Empresa;
import com.projeto_final.app.models.Usuario;
import com.projeto_final.app.repository.AppRepository;
import com.projeto_final.app.repository.EmpresaRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProjetoController {
    @Autowired
    private AppRepository csr;
    private EmpresaRepository csrEmpresa;

    @Autowired
    private EmpresaRepository empresaRepository;

    // Página inicial: exibe os formulários de login e cadastro
    @GetMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("usuarioLogado") != null) {
            return "redirect:/indexLogged";
        }
        return "index";
    }

    // Cadastro de usuário: recebe dados do formulário de cadastro
    @PostMapping("/")
    public String cadastrarUsuario(Usuario usuario) {
        csr.save(usuario);
        // Após cadastro, redireciona para página logada
        return "redirect:/indexLogged/" + usuario.getIdUsuario();
    }

    // Método único para exibir usuário e empresas cadastradas
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

    // Exclusão direta do usuário logado
    @GetMapping("/excluirUsuario")
    public String excluirUsuario(@RequestParam long idUsuario, HttpSession session) {
        Usuario usuario = csr.findByIdUsuario(idUsuario);
        if (usuario != null) {
            csr.delete(usuario);
            session.invalidate(); // encerra a sessão após exclusão
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
            session.setAttribute("usuarioLogado", usuario); // atualiza sessão
            return "redirect:/indexLogged/" + usuario.getIdUsuario();
        }
        return "redirect:/";
    }

    // ...existing code...

    // FORMULÁRIO DE LOGIN
    @GetMapping("/login")
    public String showLoginForm(HttpSession session) {
        if (session.getAttribute("usuarioLogado") != null) {
            return "redirect:/indexLogged";
        }
        // Exibe o formulário de login na mesma página do usuário logado
        return "indexLogged";
    }

    // PROCESSAMENTO DO LOGIN
    @PostMapping("/login")
    public String processLogin(@RequestParam String email,
            @RequestParam String senha,
            HttpSession session,
            org.springframework.ui.Model model) {
        Usuario usuario = csr.findByEmail(email);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/indexLogged/" + usuario.getIdUsuario();
        }

        model.addAttribute("error", "Email ou senha inválidos");
        return "indexLogged";
    }

    // PÁGINA APÓS LOGIN
    @GetMapping("/indexLogged")
    public String indexLogged(HttpSession session, Model model) {
        // Recupera o usuário logado da sessão
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        // Se não houver usuário logado, redireciona para a página inicial
        if (usuario == null) {
            return "redirect:/"; // volta para index se não estiver logado
        }

        // Adiciona o usuário ao Model para exibir na página
        model.addAttribute("usuario", usuario);
        // Exibe a página de usuário logado
        return "indexLogged";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

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
}