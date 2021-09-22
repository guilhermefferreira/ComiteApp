package com.comite.ComiteApp.controller;

import com.comite.ComiteApp.Mensagem;
import com.comite.ComiteApp.Biz.CidadeModalidadeBiz;
import com.comite.ComiteApp.entities.CidadeModalidade;
import com.comite.ComiteApp.repositories.CidadeModalidadeRepository;
import com.comite.ComiteApp.repositories.CidadeRepository;
import com.comite.ComiteApp.repositories.ModalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.ConstraintViolationException;

@RestController
@RequestMapping("cidademodalidade")
public class CidadeModalidadeController {
	
	@Autowired
	private CidadeModalidadeRepository cidademodalidadeRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ModalidadeRepository modalidadeRepository;

    @GetMapping
    @RequestMapping("listar")
    public List<CidadeModalidade> Get() {
        return cidademodalidadeRepository.findAll();
    }


    @PostMapping
    @RequestMapping("incluir")
    public Mensagem add(@RequestBody CidadeModalidade cidademodalidade) {
        CidadeModalidadeBiz cidademodalidadeBiz = new CidadeModalidadeBiz(cidadeRepository, modalidadeRepository);
        cidademodalidade.setIdCidadeModalidade(0);

        try {

            if (cidademodalidadeBiz.Validade(cidademodalidade)) {
                this.cidademodalidadeRepository.save(cidademodalidade);
                this.cidademodalidadeRepository.flush();
            } else {
                return cidademodalidadeBiz.msg;
            }
        }catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> cidademodalidadeBiz.msg.mensagens.add(v.getMessage()));
            return cidademodalidadeBiz.msg;
        }

        return cidademodalidadeBiz.msg;


    }
}