package br.ufjf.dcc193.trab2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.ufjf.dcc193.trab2.domain.AreaRepository;
import br.ufjf.dcc193.trab2.domain.AvaliadorRepository;
import br.ufjf.dcc193.trab2.domain.TrabalhoRepository;
import br.ufjf.dcc193.trab2.model.Avaliador;

/**
 * AvaliadorController
 */
@Controller
@RequestMapping("/avaliador")
public class AvaliadorController {

    @Autowired
    AvaliadorRepository avaliadores;
    @Autowired
    AreaRepository areaConhecimentos;
    @Autowired
    TrabalhoRepository trabalhos;

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("avaliador.html")
    public String avaliador(Model model) {
        model.addAttribute("avaliador", avaliadores.findAll());
        return "avaliador/avaliador";
    }

    /**
     *
     * @param model
     * @return
     */
    public String formAvaliador(Model model) {
        model.addAttribute("areaConhecimento", areaConhecimentos.findAll());
        return "avaliador/formAvaliador";
    }

    /**
     *
     * @param avaliador
     * @return
     */
    @RequestMapping("cadastrarAvaliador.html")
    public RedirectView cadastrarAvaliador(Avaliador avaliador) {
        avaliadores.save(avaliador);
        return new RedirectView("avaliador.html");
    }

    /**
     *
     * @param avaliador
     * @return
     */
    @RequestMapping("editarAvaliador.html")
    public ModelAndView editarAvaliador(Avaliador avaliador) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("avaliador", avaliadores.getOne(avaliador.getId()));
        mv.addObject("areaConhecimento", areaConhecimentos.findAll());
        mv.setViewName("avaliador/editarAvaliador");
        return mv;
    }

    /**
     *
     * @param avaliador
     * @return true ou false
     */
    public Boolean identificacaoSistema(Avaliador avaliador) {
        Avaliador aux = avaliadores.getOne(avaliador.getId());
        if (aux != null) {
            if (aux.getEmail() == avaliador.getEmail() && aux.getCodigo() == avaliador.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}