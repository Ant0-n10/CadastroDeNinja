package Ant0_n10.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem Vindo a Primeira rota da aplicação";
    }

    //Create
    @PostMapping("/criar")
    public String criaNinja(){
        return "Ninja Criado";
    }
    //Read
    @GetMapping("/mostraNinjas")
    public String mostraNinjas(){
        return "Todos";
    }
    //Read by ID
    @GetMapping("/mostraNinjasId")
    public String mostraNinjasd(){
        return "Todos por Id";
    }
    //Update
    @PutMapping("/alterarNinjaId")
    public String alterarNinjaId(){
        return "Alterados";
    }
    //Delete
    @DeleteMapping("/deletaNinjaID")
    public String deletaNinjaId(){
        return "Deleta";
    }
}
