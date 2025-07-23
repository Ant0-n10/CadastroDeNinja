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
    public NinjaDTO criar(@RequestBody NinjaDTO ninja){
        return ninjaService.criar(ninja);
    }

    //Read
    @GetMapping("/listar")
    public List<NinjaDTO> listar(){
        return ninjaService.listar();
    }

    //Read by ID
    @GetMapping("/listar/{id}")
    public NinjaDTO listarPorId(@PathVariable Long id){
        return ninjaService.listarPorId(id);
    }

    //Update
    @PutMapping("/atualizar/{id}")
    public NinjaDTO atualizaId(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        return ninjaService.atualizaId(id,ninjaDTO);
    }

    //Delete
    @DeleteMapping("/deletar/{id}")
    public void deletarId(@PathVariable Long id){
        ninjaService.deletarId(id);
    }
}
