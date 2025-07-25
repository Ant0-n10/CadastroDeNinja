package Ant0_n10.Java10x.CadastroDeNinjas.Ninjas;

import Ant0_n10.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_CADASTRO")
@Data
@Getter
@Setter
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

    private String rank;

    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key
    private MissoesModel missoes;


}
