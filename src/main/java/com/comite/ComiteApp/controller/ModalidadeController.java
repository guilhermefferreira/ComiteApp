package com.comite.ComiteApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comite.ComiteApp.Mensagem;
import com.comite.ComiteApp.Biz.ModalidadeBiz;
import com.comite.ComiteApp.entities.Modalidade;
import com.comite.ComiteApp.repositories.ModalidadeRepository;

@RestController
@RequestMapping ("modalidade")
public class ModalidadeController {
	
	@Autowired
	private ModalidadeRepository modalidadeRepositorio;
	
	@GetMapping("listar")
	public List<Modalidade> listar(){
		
		
		List<Modalidade> lista = modalidadeRepositorio.findAll();
		return lista;
		
	}
	
	@PostMapping ("incluir")
	public Mensagem salvar(@Valid @RequestBody Modalidade modalidade) {
		
		ModalidadeBiz modalidadeBiz = new ModalidadeBiz();
		
    try {
			
			if (modalidadeBiz.Validade(modalidade)) {
				this.modalidadeRepositorio.save(modalidade);
				this.modalidadeRepositorio.flush();
			} else {
				return modalidadeBiz.msg; 
			}
		} catch (Exception e) {
			modalidadeBiz.msg.mensagens.add(e.getMessage());
			return modalidadeBiz.msg;
		}
         modalidadeBiz.msg.mensagens.add("OK");
		
		return modalidadeBiz.msg;
		
	}

}
