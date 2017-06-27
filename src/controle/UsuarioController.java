package controle;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.UsuarioDao;
import negocio.Usuario;

@Controller
// @RequestMapping("/usuario")
public class UsuarioController {

	@RequestMapping("/usuarios")
	public ModelAndView ListaUsuarios(Model model) {

		List<Usuario> listaUsuarios = UsuarioDao.obterLista();

		return new ModelAndView("usuario/lista", "listaUsuarios", listaUsuarios);
	}

	@RequestMapping("/usuario/novo")
	public ModelAndView novoUsuario() {
		return new ModelAndView("usuario/detalhe", "command", new Usuario());
	}
	
	@RequestMapping("/usuario/editar/{id}")
	public ModelAndView editarUsuario(@PathVariable int id) {
		Usuario usuario = UsuarioDao.obterPorId(id);
		
		return new ModelAndView("usuario/detalhe", "command", usuario).addObject("data", new Date());
	}

	@RequestMapping(value = "/usuario/gravar", method = RequestMethod.POST)
	public ModelAndView gravarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		
		if(usuario.getId() == 0){
			UsuarioDao.incluir(usuario);
		} else{
			UsuarioDao.alterar(usuario);
		}	

		return new ModelAndView("redirect:/usuarios");
	}

}
