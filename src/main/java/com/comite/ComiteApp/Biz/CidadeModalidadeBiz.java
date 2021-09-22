package com.comite.ComiteApp.Biz;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import com.comite.ComiteApp.Mensagem;
import com.comite.ComiteApp.entities.CidadeModalidade;
import com.comite.ComiteApp.repositories.ModalidadeRepository;
import com.comite.ComiteApp.repositories.CidadeRepository;

public class CidadeModalidadeBiz {
    public Mensagem msg;

    private CidadeRepository cidadeRepository;
    private ModalidadeRepository modalidadeRepository;
 
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Validator validator = factory.getValidator();

    public CidadeModalidadeBiz(CidadeRepository cidadeRepository, ModalidadeRepository modalidadeRepository) {
        msg = new Mensagem();
        this.cidadeRepository = cidadeRepository;
        this.modalidadeRepository = modalidadeRepository;
    }

    public Boolean Validade(CidadeModalidade cidademodalidade) {

        Set<ConstraintViolation<CidadeModalidade>> constraintViolationSet = validator.validate(cidademodalidade);

        Boolean result = true;
      
        if (cidadeRepository.findById(cidademodalidade.getIdCidade()).isEmpty()) {
            msg.mensagens.add("Id inexistente");
            result = false;
        }      
        if (modalidadeRepository.findById(cidademodalidade.getIdModalidade()).isEmpty()) {
            msg.mensagens.add("Id inexistente");
            result = false;
        }     
        if(!constraintViolationSet.isEmpty()){
            ConstraintViolationException exceptionConstraint = new ConstraintViolationException(constraintViolationSet);
            msg.mensagens.add(exceptionConstraint.getMessage());
            result = false;
        }
        if(result == true){
            msg.mensagens.add("OK");
        }


        return result;

    }

}