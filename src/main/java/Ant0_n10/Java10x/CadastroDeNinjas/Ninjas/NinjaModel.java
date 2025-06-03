package Ant0_n10.Java10x.CadastroDeNinjas.Ninjas;

import Ant0_n10.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_CADASTRO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nome;

    private int idade;

    private String img_url;

    private String email;

    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key
    private MissoesModel missoes;


}
