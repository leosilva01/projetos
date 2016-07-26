package br.com.reviews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.reviews.dao.AppDao;
import br.com.reviews.dao.UsuarioDao;
import br.com.reviews.model.App;
import br.com.reviews.model.GerenciadorDeReviews;
import br.com.reviews.model.Usuario;

@Controller
public class ReviewsController {

	@Autowired
	private GerenciadorDeReviews gerenciadorDeReviews;

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private AppDao appDao;


	@RequestMapping("/review")
	@Cacheable("appsReviews") //limpando cache nos metodos salva app e dar review
	public ModelAndView review() {
		
		List<App> apps = gerenciadorDeReviews.getFilaReviews();
		
		ModelAndView modelAndView = new ModelAndView("/review/review");
		
		modelAndView.addObject("apps", apps);
		
		return modelAndView;
	}

	@RequestMapping(value = "/review/{id}")
	@CacheEvict(value = {"appsReviews"}, allEntries = true)
	public ModelAndView darReview(@PathVariable int id, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/index1");
		
		App app = appDao.buscaPorId(id);
		
		Usuario usuario = getUsuarioLogado();
		if(!gerenciadorDeReviews.addReviews(usuario, app)){
			redirectAttributes.addFlashAttribute("sucesso", "app não pode ser votado.");
			return modelAndView;
		}
		
		//TODO mensagens não estao chegando direito apos cadastrar um app
		redirectAttributes.addFlashAttribute("sucesso", "voto computado");
		
		return modelAndView;
	}
	
	@ExceptionHandler(NullPointerException.class) 
	public ModelAndView trataAppNaoEncontrado() {

		//TODO redirecionar direito(dasboard)
		final ModelAndView modelAndView = new ModelAndView("index1");
		modelAndView.addObject("appNaoEncontrado", "O App informado não foi encontrado.");

		return modelAndView;
	}
	
	private Usuario getUsuarioLogado() {

		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		return usuarioDao.buscaPorLogin(login);
	}

}
