package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;
    // private MaterialService materialService;
    // private ServicoService servicoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) { // , MaterialService materialService, ServicoService servicoService) {
        // this.materialService = materialService;
        this.produtoService = produtoService;
        // this.servicoService = servicoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("produto/lista", "produtos", produtoService.listarTodos());
    }

}
