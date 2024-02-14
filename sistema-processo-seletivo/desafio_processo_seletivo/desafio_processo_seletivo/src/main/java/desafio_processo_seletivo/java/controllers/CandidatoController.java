package desafio_processo_seletivo.java.controllers;

import desafio_processo_seletivo.java.Enum.Status;
import desafio_processo_seletivo.java.exceptions.CandidatoNaoEncontradoException;
import desafio_processo_seletivo.java.models.Candidato;
import desafio_processo_seletivo.java.services.CandidatoService;
import desafio_processo_seletivo.java.validator.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    private final CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService) {

        this.candidatoService = candidatoService;
    }

    @PostMapping("/iniciarProcesso")
    public int iniciarProcesso(@RequestBody Candidato candidato) throws CandidatoNaoEncontradoException {

        InputValidator.validateNotEmpty(candidato, "Candidato não encontrado");
        return candidatoService.iniciarProcesso(candidato);

    }

    @PostMapping("/marcarEntrevista/{idProcesso}")
    public Status marcarEntrevista(@PathVariable int idProcesso){

        return candidatoService.marcarEntrevista(idProcesso);

    }

    @DeleteMapping("/desqualificarCandidato/{idProcesso}")
    public void desqualificarCandidato(@PathVariable int idProcesso){

        candidatoService.desqualificarCandidato(idProcesso);

    }

    @PostMapping("/aprovarCandidato/{idProcesso}")
    public Status aprovarCandidato(@PathVariable int idProcesso){

        return candidatoService.aprovarCandidato(idProcesso);

    }

    @GetMapping("/verificarCandidatosAprovados")
    public List<Candidato> verificarCandidatosAprovados(){

        return candidatoService.verificarCandidatosAprovados();

    }



}
