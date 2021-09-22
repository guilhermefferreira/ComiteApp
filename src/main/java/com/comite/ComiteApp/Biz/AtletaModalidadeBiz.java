package com.comite.ComiteApp.Biz;

import com.comite.ComiteApp.Mensagem;
import com.comite.ComiteApp.entities.AtletaModalidade;
import com.comite.ComiteApp.entities.Cidade;
import com.comite.ComiteApp.repositories.AtletaRepository;
import com.comite.ComiteApp.repositories.ModalidadeRepository;

public class AtletaModalidadeBiz {
    public Mensagem msg;

    private AtletaRepository atletaRepository;

    private ModalidadeRepository modalidadeRepository;

    public AtletaModalidadeBiz(AtletaRepository atletaRepository, ModalidadeRepository modalidadeRepository) {
        msg = new Mensagem();
    }

    public Boolean Validade(AtletaModalidade atletaModalidade) {

        boolean result = true;
        if (atletaRepository.existsById(atletaModalidade.getIdAtleta())) {
            msg.mensagens.add("Este atleta não existe");
            result = false;
        }
        if (modalidadeRepository.existsById(atletaModalidade.getIdModalidade())) {
            msg.mensagens.add("Esta modalidade não existe");
            result = false;
        }

        return result;

    }
}
