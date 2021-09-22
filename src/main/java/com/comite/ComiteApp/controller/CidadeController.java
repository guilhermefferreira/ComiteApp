package com.comite.ComiteApp.controller;

import java.util.List;


import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comite.ComiteApp.Mensagem;
import com.comite.ComiteApp.Biz.CidadeBiz;
import com.comite.ComiteApp.entities.Cidade;
import com.comite.ComiteApp.repositories.CidadeRepository;

		@RestController
		@RequestMapping("cidade")
public class CidadeController {

		@Autowired
    private CidadeRepository cidadeRepository;

  

    @GetMapping("listar")
    public List<Cidade> listar(){

        List<Cidade> lista = cidadeRepository.findAll();
        return lista;

    }

    @PostMapping("incluir")
    public Mensagem salvar(@RequestBody Cidade cidade ) {

    	cidade.setIdcidade(0);
    	CidadeBiz cidadeBiz = new CidadeBiz();

        try {

            if (cidadeBiz.Validade(cidade)) {
                this.cidadeRepository.save(cidade);
                this.cidadeRepository.flush();
            } else {
                return cidadeBiz.msg;
            }
        }catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> cidadeBiz.msg.mensagens.add(v.getMessage()));
            return cidadeBiz.msg;
        }
        cidadeBiz.msg.mensagens.add("OK");

        return cidadeBiz.msg;
    }
}
