package br.ufjf.dcc193.trab2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.dcc193.trab2.DAO.AvaliadorRepository;

/**
 * AvaliadorController
 */
@Controller
@RequestMapping("/avaliador")
public class AvaliadorController {

    @Autowired
    AvaliadorRepository avaliadorRep;

    @RequestMapping({"/", "/index.html"})
      public String index(){
          return "avaliador-index";
      }

      @GetMapping("/nova.html")
      public ModelAndView criar(){
          ModelAndView mv = new ModelAndView();
          mv.setViewName("avaliador-form");
          return mv;
      }  
}