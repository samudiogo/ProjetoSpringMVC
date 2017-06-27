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

import dao.FormacaoDao;
import negocio.Formacao;


@Controller
// @RequestMapping("/formacao")
public class FormacaoController {

	@RequestMapping("/formacoes")
	public ModelAndView ListaFormacao(Model model) {

		List<Formacao> listaformacoes = FormacaoDao.obterLista();

		return new ModelAndView("formacao/lista", "listaformacoes", listaformacoes);
	}

	@RequestMapping("/formacao/novo")
	public ModelAndView novo() {
		return new ModelAndView("formacao/detalhe", "command", new Formacao());
	}
	
	@RequestMapping("/formacao/editar/{id}")
	public ModelAndView editar(@PathVariable int id) {
		Formacao formacao = FormacaoDao.obterPorId(id);
		
		return new ModelAndView("formacao/detalhe", "command", formacao).addObject("data", new Date());
	}

	@RequestMapping(value = "/formacao/gravar", method = RequestMethod.POST)
	public ModelAndView gravarFormacao(@ModelAttribute("formacao") Formacao formacao) {
		
		if(formacao.getId() == 0){
			FormacaoDao.incluir(formacao);
		} else{
			FormacaoDao.alterar(formacao);
		}			

		return new ModelAndView("redirect:/formacoes");
	}

}
