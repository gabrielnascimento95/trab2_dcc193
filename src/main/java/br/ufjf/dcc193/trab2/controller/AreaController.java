package br.ufjf.dcc193.trab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.dcc193.trab2.domain.AreaRepository;
import br.ufjf.dcc193.trab2.domain.AvaliadorRepository;
import br.ufjf.dcc193.trab2.model.Area;
import br.ufjf.dcc193.trab2.model.Avaliador;

/**
 * AreaController
 */
@RequestMapping("/area")
@Controller
public class AreaController {

  @Autowired
  AvaliadorRepository avaliadores;
  @Autowired
  AreaRepository areas;
  
  /**
     *
     * @param avaliador
     * @return
     */
    
    @RequestMapping("novaArea.html")
    public ModelAndView formArea(@RequestParam Long idAvaliador) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("idAvaliador", idAvaliador);
        mv.setViewName("area/area-form");
        return mv;
    }
}

