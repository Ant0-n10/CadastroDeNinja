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
    public MissoesDTO criar(@RequestBody MissoesDTO missoesDTO){
        return missoesService.criar(missoesDTO);
    }

    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO listarPorId(@PathVariable Long id){
        return missoesService.listarPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarId(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        return missoesService.atualizaId(id,missoesDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarId(@PathVariable Long id){
        missoesService.deletarId(id);
    }
}
