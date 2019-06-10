package br.ufjf.dcc193.trab2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufjf.dcc193.trab2.domain.AvaliadorRepository;
import br.ufjf.dcc193.trab2.model.Avaliador;

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
        return "avaliador/avaliador-index";
    }

    @GetMapping("/listar.html")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("avaliadores", avaliadorRep.findAll());
        return new ModelAndView("avaliador/avaliador-list", model);
    }

    @GetMapping("/novo.html")
    public String preSalvar(@ModelAttribute("avaliador") Avaliador pessoa){
        return "avaliador/avaliador-form";
      }  

    @PostMapping("/salvar.html")
    public String salvar(@Valid @ModelAttribute("avalidor") Avaliador pessoa, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "avaliador/avaliador-form";
        }
        avaliadorRep.save(pessoa);
        attr.addFlashAttribute("mensagem", "Avaliador criada com sucesso.");
        return "redirect: avaliador/avaliador-list";
    }

    @GetMapping("/{id}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model) {
        Avaliador pessoa = avaliadorRep.getOne(id);
        model.addAttribute("avaliador", pessoa);
        return new ModelAndView("avaliador/avaliador-form", model);
    }

    @PutMapping("/salvar.html")
    public String atualizar(@Valid @ModelAttribute("playlist") Avaliador pessoa, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "avaliador/avaliador-form";
        }  
        avaliadorRep.save(pessoa); 
        attr.addFlashAttribute("mensagem", "Avaliador atualizada com sucesso.");
        return "redirect: avaliador/avaliador-index";
    }
}