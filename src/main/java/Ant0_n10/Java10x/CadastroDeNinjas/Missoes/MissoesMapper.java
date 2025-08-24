package Ant0_n10.Java10x.CadastroDeNinjas.Missoes;

import Ant0_n10.Java10x.CadastroDeNinjas.Missoes.MissoesDTO;
import Ant0_n10.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());

        return missoesDTO;
    }

    public void updateModelFromDto(MissoesDTO dto, MissoesModel model) {

        if (dto.getNome() != null) {
            model.setNome(dto.getNome());
        }

        if (dto.getDificuldade() != null) {
            model.setDificuldade(dto.getDificuldade());
        }
    }

}
