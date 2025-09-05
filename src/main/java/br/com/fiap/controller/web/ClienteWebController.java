package br.com.fiap.controller.web;

import br.com.fiap.controller.assembler.ClienteAssembler;
import br.com.fiap.model.entity.Cliente;
import br.com.fiap.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller
@RequestMapping("/web/clientes")
public class ClienteWebController {

    @Autowired
    private ClienteService clienteService;

 

    @GetMapping("/formulario")
    public String formulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/cliente-form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cliente cliente) {
        clienteService.cadastrar(cliente);
        return "redirect:listar";
        
    }
    
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Cliente> clientes = clienteService.listarTodos();
        model.addAttribute("clientes", clientes);
        return "cliente/cliente-listar";
    }
    
    




}
