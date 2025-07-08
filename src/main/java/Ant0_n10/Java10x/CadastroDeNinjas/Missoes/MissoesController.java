package Ant0_n10.Java10x.CadastroDeNinjas.Missoes;

import Ant0_n10.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    MissoesService missoesService;
    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public MissoesModel criar(@RequestBody MissoesModel missoesModel){
        return missoesService.criar(missoesModel);
    }

    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarPorId(@PathVariable Long id){
        return missoesService.listarPorId(id);
    }

    @PutMapping("/alterar")
    public String alterarId(){
        return "Missao alterada";
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarId(@PathVariable Long id){
        missoesService.deletarId(id);
    }
}
