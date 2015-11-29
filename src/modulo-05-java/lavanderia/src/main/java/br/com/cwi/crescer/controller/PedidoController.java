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

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.mapper.ClienteMapper;
import br.com.cwi.crescer.mapper.PedidoMapper;
import br.com.cwi.crescer.service.ClienteService;
import br.com.cwi.crescer.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	
    private PedidoService pedidoService;
    private ClienteService clienteService;

    @Autowired
    public PedidoController(PedidoService pedidoService, ClienteService clienteService) {
        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
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
        return new ModelAndView("redirect:/pedidos");
    }
    
    @ModelAttribute("clientes")
    public List<Cliente> comboClientes() {
        return clienteService.listar();
    }
}
