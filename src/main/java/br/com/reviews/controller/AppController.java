package br.com.reviews.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.reviews.dao.AppDao;
import br.com.reviews.dao.UsuarioDao;
import br.com.reviews.model.App;
import br.com.reviews.model.Usuario;
import br.com.reviews.validation.AppValidation;

@Controller
public class AppController {

	@Autowired
	private AppDao appDao;

	@Autowired
	private UsuarioDao usuarioDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new AppValidation());
	}

	@RequestMapping("/app/formApp")
	public ModelAndView formApp(App app) {

		return new ModelAndView("/app/formApp");
	}

	@RequestMapping(value = "/app", method = RequestMethod.POST)
	@CacheEvict(value = {"appsReviews"}, allEntries = true)
	public ModelAndView salva(@Valid App app, BindingResult result, RedirectAttributes redirectAttributes) {

		if(result.hasErrors()){
			return formApp(app);
		}
		
		Usuario usuario = getUsuarioLogado();

		app.setUsuario(usuario);
		
		//TODO fazer uma classe de validação
		if(!( usuario.getApps().size() >= 2 )){
			
			appDao.salva(app);
			
			redirectAttributes.addFlashAttribute("sucesso", "App cadastrado com sucesso!");
			
			//TODO redirecionar direito(dashboard)
			return new ModelAndView("redirect:/index1");
		}

		//TODO redirecionar direito(dashboard)
		redirectAttributes.addFlashAttribute("sucesso", "limite de apps alcançado.");
		return new ModelAndView("redirect:/index1");
		
		
	}

	
	@RequestMapping(value = "/app", method = RequestMethod.GET)
	public ModelAndView paginaUsuario() {
		
		return new ModelAndView("/usuario/paginaUsuario");
	}
	
	@RequestMapping("/app/listaApp")
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("/app/listaApp");


		Usuario usuario = getUsuarioLogado();
		
		//TODO nao consigo passar o objeto usuario
		//TODO fazer cache com os apps do usuario logado, cuidado q o cache esta sendo feito para todo o sistema
		modelAndView.addObject("usuarioLogin", usuario.getLogin());
		List<App> apps = usuario.getApps();
		modelAndView.addObject("apps", apps);

		return modelAndView;
	}
	
	private Usuario getUsuarioLogado() {

		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario = usuarioDao.buscaPorLogin(login);
		return usuario;
		
	}
}
