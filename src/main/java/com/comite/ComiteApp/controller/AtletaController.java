package com.comite.ComiteApp.controller;

import com.comite.ComiteApp.Biz.AtletaBiz;
import com.comite.ComiteApp.Mensagem;
import com.comite.ComiteApp.entities.Atleta;
import com.comite.ComiteApp.repositories.AtletaRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("atleta")
public class AtletaController {

    @Autowired
    private AtletaRepository atletaRepository;

    @GetMapping("listar")
    public List<Atleta> listar(){
        List<Atleta> lista = atletaRepository.findAll();
        return lista;
    }

    @PostMapping("incluir")
    public Mensagem salvar(@RequestBody Atleta atleta ){
        atleta.setIdatleta(0);

        AtletaBiz atletaBiz = new AtletaBiz();

        try {
            if (atletaBiz.Atletismo(atleta)) {
                this.atletaRepository.save(atleta);
                this.atletaRepository.flush();
            } else {
                return atletaBiz.msg;
            }
        }catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(v -> atletaBiz.msg.mensagens.add(v.getMessage()));
            return atletaBiz.msg;
        }
        atletaBiz.msg.mensagens.add("OK");
        return atletaBiz.msg;
    }
}
