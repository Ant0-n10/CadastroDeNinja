package Ant0_n10.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

   NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem Vindo a Primeira rota da aplicação";
    }

    //Create
    @PostMapping("/criar")
    public NinjaModel criar(@RequestBody NinjaModel ninjaModel){
        return ninjaService.criar(ninjaModel);
    }

    //Read
    @GetMapping("/listar")
    public List<NinjaModel> listar(){
        return ninjaService.listar();
    }

    //Read by ID
    @GetMapping("/listar/{id}")
    public NinjaModel listarPorId(@PathVariable Long id){
        return ninjaService.listarPorId(id);
    }

    //Update
    @PutMapping("/atualizar/{id}")
    public NinjaModel atualizaId(@PathVariable Long id, @RequestBody NinjaModel ninjaModel){
        return ninjaService.atualizaId(id, ninjaModel);
    }

    //Delete
    @DeleteMapping("/deletar/{id}")
    public void deletarId(@PathVariable Long id){
        ninjaService.deletarId(id);
    }
}
