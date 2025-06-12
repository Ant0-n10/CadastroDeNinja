package Ant0_n10.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {


    MissoesRepository missoesRepository;
    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel listarPorId(Long id){
        Optional<MissoesModel> optionalMissoesModel = missoesRepository.findById(id);
        return optionalMissoesModel.orElse(null);
    }
}
