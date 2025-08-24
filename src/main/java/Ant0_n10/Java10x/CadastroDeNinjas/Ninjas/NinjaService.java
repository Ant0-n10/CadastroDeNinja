package Ant0_n10.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaMapper ninjaMapper;
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaMapper ninjaMapper, NinjaRepository ninjaRepository) {
        this.ninjaMapper = ninjaMapper;
        this.ninjaRepository = ninjaRepository;
    }

    public NinjaDTO criar(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);

        return ninjaMapper.map(ninjaModel);
    }

    public List<NinjaDTO> listar(){
        List<NinjaModel> ninjaModelList = ninjaRepository.findAll();

        return ninjaModelList.stream().map(ninjaMapper::map).collect(Collectors.toList());
    }

    public NinjaDTO listarPorId(Long id){
        Optional<NinjaModel> optionalNinjaModel = ninjaRepository.findById(id);

        return optionalNinjaModel.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO atualizaId(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> optionalNinjaModel = ninjaRepository.findById(id);
        if (optionalNinjaModel.isPresent()){
            NinjaModel ninjaAtualizado = optionalNinjaModel.get();
            ninjaMapper.updateModelFromDto(ninjaDTO,ninjaAtualizado);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);

             return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

    public boolean deletarId(Long id) {
        if (!ninjaRepository.existsById(id)){
            return false;
        }
        ninjaRepository.deleteById(id);
        return true;
    }
}
