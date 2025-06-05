package Ant0_n10.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missões listadas";
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada";
    }
}
