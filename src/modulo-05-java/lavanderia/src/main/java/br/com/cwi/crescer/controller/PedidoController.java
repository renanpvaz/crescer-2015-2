package br.com.cwi.crescer.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.mapper.ClienteMapper;
import br.com.cwi.crescer.mapper.PedidoMapper;
import br.com.cwi.crescer.mapper.ProdutoMapper;
import br.com.cwi.crescer.service.ClienteService;
import br.com.cwi.crescer.service.ItemService;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.PedidoService;
import br.com.cwi.crescer.service.ProdutoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	
    private PedidoService pedidoService;
    private ClienteService clienteService;
    private ProdutoService produtoService;
    private ServicoService servicoService;
    private ItemService itemService;

    @Autowired
    public PedidoController(PedidoService pedidoService, ClienteService clienteService, ServicoService servicoService, ProdutoService produtoService, ItemService itemService) {
		this.pedidoService = pedidoService;
		this.clienteService = clienteService;
		this.servicoService = servicoService;
		this.produtoService = produtoService;
		this.itemService = itemService;
	}

	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarTodos());
    }
    
    @RequestMapping(path = "/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar() {
        return new ModelAndView("pedido/novo", "pedido", new PedidoDTO());
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView visualizar(@PathVariable("id") Long id) {
    	return new ModelAndView("pedido/exibe", "pedido", pedidoService.buscarPorId(id));
    }
    
    @RequestMapping(path = "/cadastrar", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid @ModelAttribute("pedido") PedidoDTO pedido, BindingResult result, final RedirectAttributes redirectAttributes) {

        if (result.hasFieldErrors()) {
            return new ModelAndView("pedido/novo", "pedido", new PedidoDTO());
        }

        pedidoService.incluir(PedidoMapper.getNewEntity(pedido.getCliente()));
        Long ultimoId = pedidoService.buscarUltimo().getId();
        return new ModelAndView("redirect:/pedidos/selecionarProduto/" + ultimoId);
    }
    
    @RequestMapping(path="/selecionarProduto/{id}", method= RequestMethod.GET)
    public ModelAndView selecionarProduto(@PathVariable("id") Long id) {
    	return new ModelAndView("pedido/selecionaProduto", "pedido", pedidoService.buscarPorId(id));
    }
    
    @RequestMapping(path="/buscarMateriais", params = {"idPedido", "idServico"}, method = RequestMethod.GET)
    public ModelAndView buscarMateriais(Model model, @RequestParam("idPedido") Long idPedido, @RequestParam("idServico") Long idServico) {
    	model.addAttribute("servicoSelecionado", servicoService.buscarPorId(idServico));
    	model.addAttribute("pedido", pedidoService.buscarPorId(idPedido));
        
    	return new ModelAndView("pedido/selecionaProduto", "materiais", produtoService.buscarMaterialPorServico(idServico));
    }
    
    @RequestMapping(path = "/adicionarItem", params = {"idPedido", "idServico", "idMaterial"}, method = RequestMethod.GET)
    public ModelAndView adicionarItem(@RequestParam("idPedido") Long idPedido, @RequestParam("idServico") Long idServico, @RequestParam("idMaterial") Long idMaterial) {
    	
    	ProdutoDTO produto = produtoService.listarPorServicoOuMaterial(idServico, idMaterial).get(0);
    	
    	ItemDTO item = pedidoService.atribuirProdutoANovoItem(produto, idPedido);
    	
    	return new ModelAndView("pedido/adicionaItem", "item", item);
    }
    
    @RequestMapping(path = "/adicionarNovoItem", method = RequestMethod.POST)
    public ModelAndView adicionarNovoItem(@Valid @ModelAttribute("item") ItemDTO item, 
    		BindingResult result, 
    		final RedirectAttributes redirectAttributes) throws ParseException {
    	
    	Pedido pedido = pedidoService.buscarPorId(item.getPedido().getIdPedido());
    	
    	if (result.hasErrors()) {
        }
    	
    	itemService.adicionarItem(item);
    	pedidoService.atualizarInformacoes(pedido, item);
    	
    	redirectAttributes.addFlashAttribute("mensagem", "Item adicionado");
    	
    	return new ModelAndView("redirect:/pedidos/" + item.getPedido().getIdPedido());
    }
    
    @RequestMapping(path = "/processarItens/{id}", method = RequestMethod.GET)
    public ModelAndView processarItens(Model model, @PathVariable("id") Long id) {
    	Pedido pedido = pedidoService.buscarPorId(id); 	
    	
    	model.addAttribute("itens", pedido.getItens());
    	
    	return new ModelAndView("pedido/processaItens", "pedido", pedido);
    }
    
    @RequestMapping(params="idItem", path = "/processarItem", method = RequestMethod.GET)
    public ModelAndView processarItem(@RequestParam("idItem") Long id) {
    	Item item = itemService.buscarPorId(id);
    	
    	itemService.processarItem(item);
    	
    	return new ModelAndView("redirect:/pedidos/processarItens/" + item.getPedido().getIdPedido());
    }

    
    @ModelAttribute("clientes")
    public List<Cliente> comboClientes() {
        return clienteService.listar();
    }
    
    @ModelAttribute("servicos")
    public List<Servico> comboServicos() {
        return servicoService.listar();
    }
}
