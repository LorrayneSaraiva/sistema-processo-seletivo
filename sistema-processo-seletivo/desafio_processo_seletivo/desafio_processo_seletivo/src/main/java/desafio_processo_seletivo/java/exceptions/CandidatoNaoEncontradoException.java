package desafio_processo_seletivo.java.exceptions;

public class CandidatoNaoEncontradoException extends Exception {

    public CandidatoNaoEncontradoException(){
        super("Candidato não encontrado");
    }

    public CandidatoNaoEncontradoException(String message){
        super(message);
    }

}
