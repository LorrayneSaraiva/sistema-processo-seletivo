package desafio_processo_seletivo.java.models;

import desafio_processo_seletivo.java.Enum.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Candidato {

    public String nome;
    //public int id;
    public Status status;
    public int idProcesso;
    private List<Candidato> candidatos = new ArrayList<>();

    @Override
    public String toString() {
        return "Candidato{" +
                "nome='" + nome + '\'' +
                ", idProcesso=" + idProcesso + '\'' +
                ", status=" + status +
                '}';
    }
}
