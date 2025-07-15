package Ant0_n10.Java10x.CadastroDeNinjas.Ninjas;

import Ant0_n10.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private int idade;
    private String img_url;
    private String email;
    private String rank;

    private MissoesModel missoes;
}
