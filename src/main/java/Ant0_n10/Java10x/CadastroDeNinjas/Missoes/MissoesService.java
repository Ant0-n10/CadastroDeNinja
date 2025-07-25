package Ant0_n10.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {


    MissoesRepository missoesRepository;
    MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDTO criar(MissoesDTO missoesDTO) {
        MissoesModel model = missoesMapper.map(missoesDTO);
        model = missoesRepository.save(model);
        return missoesMapper.map(model);
    }

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoesModelList = missoesRepository.findAll();
        return missoesModelList.stream().map(missoesMapper::map).collect(Collectors.toList());
    }

    public MissoesDTO listarPorId(Long id){
        Optional<MissoesModel> optionalMissoesModel = missoesRepository.findById(id);
        return optionalMissoesModel.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO atualizaId(Long id, MissoesDTO missoesDTO) {
       Optional<MissoesModel> optionalMissoesModel = missoesRepository.findById(id);
        if (missoesRepository.existsById(id)) {
            MissoesModel missoesAtualizado = missoesMapper.map(missoesDTO);
            missoesAtualizado.setId(id);
           MissoesModel missoesSave = missoesRepository.save(missoesAtualizado);
           return missoesMapper.map(missoesSave);
       }
        return null;
    }

    public void deletarId(Long id) {
        missoesRepository.deleteById(id);
    }
}
