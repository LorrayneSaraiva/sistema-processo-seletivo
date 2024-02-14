package desafio_processo_seletivo.java.services;

import desafio_processo_seletivo.java.Enum.Status;
import desafio_processo_seletivo.java.models.Candidato;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatoService {

    private final List<Candidato> candidatos = new ArrayList<>();

    public int iniciarProcesso(Candidato candidato){
        int id = gerarIdProcesso();
        candidato.setIdProcesso(id);
        candidato.setStatus(Status.RECEBIDOS);
        candidatos.add(candidato);
        return id;
    }

    private int gerarIdProcesso(){
        long timesTamp = System.currentTimeMillis();
        return (int) (timesTamp % 1000000);
    }

    public Status marcarEntrevista(int idProcesso){
        Candidato candidato = encontrarCandidatoPorIdProcesso(idProcesso);
        if (candidato != null){
            candidato.setStatus(Status.QUALIFICADOS);
            return candidato.getStatus();
        }
        return null;
    }


    public void desqualificarCandidato(int idProcesso) {
        Candidato candidato = encontrarCandidatoPorIdProcesso(idProcesso);
        if (candidato != null) {
            candidatos.remove(candidato);
        }
    }


    public Status aprovarCandidato(int idProcesso){
        Candidato candidato = encontrarCandidatoPorIdProcesso(idProcesso);
        if (candidato != null){
            candidato.setStatus(Status.APROVADOS);
            return candidato.getStatus();
        }
        return null;
    }



    public List<Candidato> verificarCandidatosAprovados() {
        List<Candidato> candidatosAprovados = new ArrayList<>();

        for (Candidato candidato : candidatos) {
            if (candidato.getStatus() == Status.APROVADOS) {
                candidatosAprovados.add(candidato);
            }
        }

        return candidatosAprovados;
    }

    private Candidato encontrarCandidatoPorIdProcesso(int idProcesso){
        return candidatos.stream()
                .filter(c -> c.getIdProcesso() == idProcesso)
                .findFirst()
                .orElse(null);
    }



}
