package Ant0_n10.Java10x.CadastroDeNinjas.Missoes;

import Ant0_n10.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<MissoesDTO> criar(@RequestBody MissoesDTO missoesDTO){
        MissoesDTO novaMissao = missoesService.criar(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMissao);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoesDTOList = missoesService.listarMissoes();
        return ResponseEntity.ok(missoesDTOList);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<MissoesDTO> listarPorId(@PathVariable Long id){
        MissoesDTO missoesId = missoesService.listarPorId(id);
        if(missoesId != null){
            return ResponseEntity.ok().body(missoesId);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<MissoesDTO> atualizaPorId(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        MissoesDTO atualizaMissao = missoesService.atualizaPorId(id,missoesDTO);
        if (atualizaMissao != null){
            return ResponseEntity.ok(atualizaMissao);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarId(@PathVariable Long id){
        boolean missaoDeletada = missoesService.deletarId(id);
        if(missaoDeletada){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
