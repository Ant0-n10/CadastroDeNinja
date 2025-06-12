package Ant0_n10.Java10x.CadastroDeNinjas.Missoes;

import Ant0_n10.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MissoesRepository extends JpaRepository<MissoesModel,Long> {
}

