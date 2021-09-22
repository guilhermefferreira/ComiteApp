package com.comite.ComiteApp.Biz;

import com.comite.ComiteApp.Mensagem;
import com.comite.ComiteApp.entities.Cidade;

public class CidadeBiz {
	
	public Mensagem msg;

    public CidadeBiz() {
        msg = new Mensagem();
    }

    public Boolean Validade(Cidade cidade) {

        boolean result = true;
        if (cidade.getNome().isEmpty()) {
            msg.mensagens.add("O nome da Cidade não pode ser vazio");
            result = false;
        }
        if (cidade.getNome().startsWith("PP")) {
            msg.mensagens.add("O nome da cidade é inválido");
            result = false;
        }

        return result;

    }
	
	

}
