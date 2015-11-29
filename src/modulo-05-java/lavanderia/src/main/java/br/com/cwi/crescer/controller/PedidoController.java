package br.com.cwi.crescer.controller;

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
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.mapper.ClienteMapper;
import br.com.cwi.crescer.mapper.PedidoMapper;
import br.com.cwi.crescer.service.ClienteService;
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
    private MaterialService materialService;
    private ServicoService servicoService;

    @Autowired
    public PedidoController(PedidoService pedidoService, ClienteService clienteService, MaterialService materialService,
			ServicoService servicoService, ProdutoService produtoService) {
		this.pedidoService = pedidoService;
		this.clienteService = clienteService;
		this.materialService = materialService;
		this.servicoService = servicoService;
		this.produtoService = produtoService;
	}

	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarTodos());
    }
    
    @RequestMapping(path = "/cadastrar", method = RequestMethod.GET)
    public ModelAndView cadastrar() {
        return new ModelAndView("pedido/novo", "pedido", new PedidoDTO());
    }

    @RequestMapping(path = "/cadastrar", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid @ModelAttribute("pedido") PedidoDTO pedido, BindingResult result, final RedirectAttributes redirectAttributes) {

        if (result.hasFieldErrors()) {
            return new ModelAndView("pedido/novo", "pedido", new PedidoDTO());
        }

        pedidoService.incluir(PedidoMapper.getNewEntity(pedido.getCliente()));
        Long ultimoId = pedidoService.buscarUltimo().getId();
        return new ModelAndView("redirect:/pedidos/adicionarItem/" + ultimoId);
    }
    
    @RequestMapping(path="/adicionarItem/{id}", method= RequestMethod.GET)
    public ModelAndView adicionarItem(@PathVariable("id") Long id) {
    	return new ModelAndView("pedido/novoItem", "pedido", pedidoService.buscarPorId(id));
    }
    
    @RequestMapping(path="/buscarMateriais", params = {"idPedido", "idServico"}, method = RequestMethod.GET)
    public ModelAndView buscarMateriais(Model model, @RequestParam("idPedido") Long idPedido, @RequestParam("idServico") Long idServico) {
    	model.addAttribute("servicoSelecionado", servicoService.buscarPorId(idServico));
    	model.addAttribute("pedido", pedidoService.buscarPorId(idPedido));
        
    	return new ModelAndView("pedido/novoItem", "materiais", produtoService.buscarMaterialPorServico(idServico));
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
