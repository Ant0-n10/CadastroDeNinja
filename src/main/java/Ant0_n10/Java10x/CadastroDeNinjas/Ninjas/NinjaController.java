package Ant0_n10.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<NinjaDTO> criar(@RequestBody NinjaDTO ninja){
        NinjaDTO ninjaCriado = ninjaService.criar(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body(ninjaCriado);
    }

    //Read
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listar(){
        List<NinjaDTO> ninjaDTOList = ninjaService.listar();
        return ResponseEntity.ok(ninjaDTOList);
    }

    //Read by ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<NinjaDTO> listarPorId(@PathVariable Long id){
        NinjaDTO ninjaDTO = ninjaService.listarPorId(id);
        if (ninjaDTO != null){
            return ResponseEntity.ok().body(ninjaDTO);
        }
        return ResponseEntity.notFound().build();
    }

    //Update
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<NinjaDTO> atualizaId(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        NinjaDTO atualizaNinja = ninjaService.atualizaId(id,ninjaDTO);
        if (atualizaNinja != null){
            return ResponseEntity.ok().body(atualizaNinja);
        }
        return ResponseEntity.notFound().build();
    }

    //Delete
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarId(@PathVariable Long id){
       boolean  deletarId = ninjaService.deletarId(id);
        if (deletarId){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
