package com.projeto_final.app.controllers;

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

import com.projeto_final.app.models.Usuario;
import com.projeto_final.app.repository.AppRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProjetoController {
    @Autowired
    private AppRepository csr;

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
    public String cadastrarUsuario(Usuario usuario){
        csr.save(usuario);
        // Após cadastro, redireciona para página logada
        return "redirect:/indexLogged/" + usuario.getIdUsuario();
    }

    @RequestMapping(value="/indexLogged/{idUsuario}", method=RequestMethod.GET)
    public ModelAndView indexLogged(@PathVariable ("idUsuario") long idUsuario){
        Usuario usuario = csr.findByIdUsuario(idUsuario);
        ModelAndView mv = new ModelAndView("indexLogged");
        mv.addObject("usuario", usuario);
        return mv;
    }

    // ...existing code...

    // FORMULÁRIO DE LOGIN
    // Exibe o formulário de login. Se o usuário já estiver logado, redireciona para a página logada.
    @GetMapping("/login")
    public String showLoginForm(HttpSession session) {
        if (session.getAttribute("usuarioLogado") != null) {
            return "redirect:/indexLogged";
        }
        // Exibe o formulário de login na mesma página do usuário logado
        return "indexLogged";
    }

    // PROCESSAMENTO DO LOGIN
    // Recebe os dados do formulário de login (email e senha), busca o usuário pelo email,
    // verifica se a senha está correta e, se estiver, salva o usuário na sessão e redireciona para a página logada.
    // Se não estiver correto, adiciona uma mensagem de erro e retorna para a página de usuário logado.
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
    // Exibe a página de usuário logado. Recupera o usuário da sessão e, se não estiver logado, redireciona para a página inicial.
    // Caso esteja logado, adiciona o usuário ao Model para exibir as informações na página.
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
}