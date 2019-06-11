package br.ufjf.dcc193.trab2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    AreaRepository areas;
    @Autowired
    TrabalhoRepository trabalhos;

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String formAvaliadorMenu(Model model) {
        return "avaliador/avaliador-index";
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("listar.html")
    public ModelAndView listar(){
        List<Avaliador> avaliadoresList = avaliadores.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("avaliador/avaliador-list");
        mv.addObject("avaliadores", avaliadoresList);
        return mv;
    }
    
    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("novo.html")
    public String formAvaliador(@ModelAttribute("avaliador") Avaliador pessoa) {
        return "avaliador/avaliador-form";
    }

    /**
     *
     * @param avaliador
     * @return
     */
    @PostMapping("cadastrarAvaliador.html")
    public RedirectView cadastrarAvaliador(@Valid @ModelAttribute("avalidor") Avaliador avaliador, BindingResult result) {
        if (result.hasErrors()) {
            return new RedirectView("index.html");
        }
        avaliadores.save(avaliador);
        return new RedirectView("listar.html"); 
    }

    /**
     *
     * @param avaliador
     * @return
     */
    @GetMapping("/editar/{id}")
    public ModelAndView editarAvaliador(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("avaliador", avaliadores.findById(id).get());
        mv.setViewName("avaliador/avaliador-edit");
        return mv;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewAvaliador(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("avaliador", avaliadores.findById(id).get());
        mv.setViewName("avaliador/avaliador-view");
        return mv;
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id, @Valid Avaliador avaliador, BindingResult binding) {
       ModelAndView mv = new ModelAndView();
       if (binding.hasErrors()) {
           mv.setViewName("avaliador/atividade-edit");
           mv.addObject("avaliador", avaliador);
           return mv;
       }
       avaliadores.save(avaliador);
       mv.setViewName("redirect: ../../../listar.html");
       return mv;
   }

   /**
     *
     * @param avaliador
     * @return
     */
    @GetMapping("/excluir/{id}")
    public ModelAndView excluirAvaliador(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        avaliadores.deleteById(id);
        mv.setViewName("redirect: ../../../listar.html");
        return mv;
    }

    /**
     *
     * @param avaliador
     * @return true ou false
     */
    public Boolean autenticaUser(Avaliador avaliador) {
        Avaliador aux = avaliadores.getOne(avaliador.getId());
        if (aux != null) {
            if (aux.getEmail() == avaliador.getEmail() && aux.getCodigo() == avaliador.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}