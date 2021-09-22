package com.comite.ComiteApp.Biz;

import com.comite.ComiteApp.Mensagem;
import com.comite.ComiteApp.entities.CidadeModalidade;
import com.comite.ComiteApp.repositories.ModalidadeRepository;
import com.comite.ComiteApp.repositories.CidadeRepository;

public class CidadeModalidadeBiz {
    public Mensagem msg;

    private CidadeRepository cidadeRepository;
    private ModalidadeRepository modalidadeRepository;

    public CidadeModalidadeBiz(CidadeRepository cidadeRepository, ModalidadeRepository modalidadeRepository) {
        msg = new Mensagem();
        this.cidadeRepository = cidadeRepository;
        this.modalidadeRepository = modalidadeRepository;
    }

    public Boolean Validade(CidadeModalidade cidademodalidade) {
       
        Boolean result = true;
      
        if (cidadeRepository.findById(cidademodalidade.getIdCidade()).isEmpty()) {
            msg.mensagens.add("Id inexistente");
            result = false;
        }      
        if (modalidadeRepository.findById(cidademodalidade.getIdModalidade()).isEmpty()) {
            msg.mensagens.add("Id inexistente");
            result = false;
        }   
        if(result == true){
            msg.mensagens.add("OK");
        }


        return result;

    }

}