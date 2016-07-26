package br.com.reviews.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.reviews.dao.UsuarioDao;
import br.com.reviews.model.Usuario;
import br.com.reviews.validation.UsuarioValidation;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDao usuarioDao;

	@InitBinder
	public void initBinder(final WebDataBinder binder) {

		binder.addValidators(new UsuarioValidation());
	}

	@RequestMapping("/usuario/register")
	public ModelAndView formUsuario(final Usuario usuario) {
		
		return new ModelAndView("/usuario/register");
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public ModelAndView salva(@Valid final Usuario usuario, final BindingResult result, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return this.formUsuario(usuario);
		}

		this.usuarioDao.salva(usuario);

		redirectAttributes.addFlashAttribute("mensagemAppSucesso", "Usuário cadastrado com sucesso!");

		//TODO redirecionar direito(dashboard)
		return new ModelAndView("redirect:/index1");
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public String paginaUsuario() {

		//TODO redirecionar direito(dashboard)
		return "index1";

	}

	@RequestMapping("/usuario/listar")
	public ModelAndView listar() {

		final ModelAndView modelAndView = new ModelAndView("/usuario/listar");

		final List<Usuario> usuarios = this.usuarioDao.listarTodos();

		modelAndView.addObject("usuarios", usuarios);
		
		return modelAndView;
	}

	@RequestMapping("/usuario/paginaUsuario")
	public ModelAndView detalhe() {
		
		final ModelAndView modelAndView = new ModelAndView("/usuario/paginaUsuario");
		
		final Usuario usuario = getUsuarioLogado();
		
		modelAndView.addObject("usuario", usuario);
		
		return modelAndView;
	}
	
	private Usuario getUsuarioLogado() {

		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario = usuarioDao.buscaPorLogin(login);
		return usuario;
		
	}
}
