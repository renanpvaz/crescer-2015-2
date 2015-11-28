package br.com.cwi.crescer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.ProdutoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;
    private MaterialService materialService;
    private ServicoService servicoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService, MaterialService materialService, ServicoService servicoService) {
        this.materialService = materialService;
        this.produtoService = produtoService;
        this.servicoService = servicoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView lista() {
        return new ModelAndView("produto/lista", "produtos", produtoService.listarTodos());
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable Long id) {
        return new ModelAndView("produto/edita", "produto", produtoService.buscarPorId(id));
    }
    
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("produto") ProdutoDTO produto, BindingResult result, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return new ModelAndView("produto/edita", "produto", produto);
        }

        produtoService.atualizar(produto);
        return new ModelAndView("redirect:/produtos");
    }
    
    @ModelAttribute("servicos")
    public List<Servico> comboServicos() {
        return servicoService.listar();
    }
    
    @ModelAttribute("materiais")
    public List<Material> comboMateriais() {
        return materialService.listar();
    }
}
