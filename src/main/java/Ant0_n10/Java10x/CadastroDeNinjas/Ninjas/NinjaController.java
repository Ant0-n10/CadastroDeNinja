package Ant0_n10.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem Vindo a Primeira rota da aplicação";
    }

    //Create
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }
    //Read
    @GetMapping("/listar")
    public String listar(){
        return "listar Ninja";
    }
    //Read by ID
    @GetMapping("/listarId")
    public String listarId(){
        return "listar por Id";
    }
    //Update
    @PutMapping("/alterarId")
    public String alterarId(){
        return "Alterar";
    }
    //Delete
    @DeleteMapping("/deletarId")
    public String deletarId(){
        return "Deleta";
    }
}
