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
import com.comite.ComiteApp.Biz.AtletaModalidadeBiz;
import com.comite.ComiteApp.entities.AtletaModalidade;
import com.comite.ComiteApp.repositories.AtletaModalidadeRepository;
import com.comite.ComiteApp.repositories.AtletaRepository;
import com.comite.ComiteApp.repositories.ModalidadeRepository;



@RestController
@RequestMapping("atletamodalidade")
public class AtletaModalidadeController {
	
	@Autowired
	private AtletaModalidadeRepository atletaModRepositorio;

	@Autowired
	private AtletaRepository atletaRepositorio;
	
	@Autowired
	private ModalidadeRepository modalidadeRepositorio;
	
	@GetMapping("listar")
	public List<AtletaModalidade> listar() {
		
		List<AtletaModalidade> lista = atletaModRepositorio.findAll(); 
		return lista;
	}
	
	@PostMapping("incluir")	//rota
	public Mensagem salvar(@RequestBody AtletaModalidade atletaMod ) {
		
		atletaMod.setIdAtletaModalidade(0);	
		AtletaModalidadeBiz atletaModBiz = new AtletaModalidadeBiz(atletaRepositorio, modalidadeRepositorio);
		
		try {
			//validar todos os dominios e regras
		if (atletaModBiz.Validade(atletaMod)) {
			this.atletaModRepositorio.save(atletaMod);
			this.atletaModRepositorio.flush();
		} else {
			return atletaModBiz.msg; 	// retorna a mensagem de erro
		}
		}catch (ConstraintViolationException e) {
			e.getConstraintViolations().forEach(v -> atletaModBiz.msg.mensagens.add(v.getMessage()));
			return atletaModBiz.msg;
		}
		atletaModBiz.msg.mensagens.add("OK");
		
	return atletaModBiz.msg;
		
	}
}
