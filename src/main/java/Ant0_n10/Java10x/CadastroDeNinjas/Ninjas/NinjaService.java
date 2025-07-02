package Ant0_n10.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listar(){
        return ninjaRepository.findAll();
    }

    public NinjaModel listarPorId(Long id){
        Optional<NinjaModel> optionalNinjaModel = ninjaRepository.findById(id);
        return optionalNinjaModel.orElse(null);
    }

    public NinjaModel criar(NinjaModel ninjaModel) {
        return ninjaRepository.save(ninjaModel);
    }

}
