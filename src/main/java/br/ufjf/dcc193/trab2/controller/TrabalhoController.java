package br.ufjf.dcc193.trab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import br.ufjf.dcc193.trab2.domain.AreaRepository;
import br.ufjf.dcc193.trab2.domain.TrabalhoRepository;
import br.ufjf.dcc193.trab2.model.Trabalho;

/**
 * TrabalhoController
 */
@Controller
public class TrabalhoController {
  @Autowired
  TrabalhoRepository trabalhos;
  @Autowired
  AreaRepository areas;

  /**
     *
     * @param model
     * @return
     */
    @RequestMapping("trabalho.html")
    public String trabalho(Model model) {
        model.addAttribute("trabalho", trabalhos.findAll());
        return "trabalho/trabalho";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("formTrabalho.html")
    public String formTrabalho(Model model) {
        model.addAttribute("areaConhecimento", areas.findAll());
        return "trabalho/formTrabalho";
    }

    /**
     *
     * @param trabalho
     * @return
     */
    @RequestMapping("cadastrarTrabalho.html")
    public RedirectView cadastrarTrabalho(Trabalho trabalho) {
        trabalhos.save(trabalho);
        return new RedirectView("trabalho.html");
    }

    /**
     *
     * @param trabalho
     * @return
     */
    @RequestMapping("editarTrabalho.html")
    public ModelAndView editarTrabalho(Trabalho trabalho) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("trabalho", trabalhos.getOne(trabalho.getId()));
        mv.addObject("areaConhecimento", areas.findAll());
        mv.setViewName("trabalho/editarTrabalho");
        return mv;
    }

}