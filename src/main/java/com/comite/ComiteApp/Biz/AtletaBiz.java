package com.comite.ComiteApp.Biz;

import com.comite.ComiteApp.Mensagem;
import com.comite.ComiteApp.entities.Atleta;
import com.comite.ComiteApp.repositories.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

public class AtletaBiz {

    public Mensagem msg;

    public AtletaBiz() {msg = new Mensagem();}

    public boolean Atletismo(@Valid Atleta atleta){

        boolean result = true;
        msg = new Mensagem();

        if(atleta.getNome().isEmpty()){
            msg.mensagens.add("O nome não pode ser vazio");
            result = false;

            if(atleta.getNome().length() < 5){
                msg.mensagens.add("O nome não pode ter menos que cinco caracteres");
                result = false;
            }

            if(atleta.getInscricao().isEmpty()){
                msg.mensagens.add("A inscrição não pode ser vazia");
                result = false;
            }

            if(atleta.getInscricao().length() < 5){
                msg.mensagens.add("A inscrição não pode ter menos que cinco caracteres");
                result = false;
            }
        }
        return result;
    }
}
