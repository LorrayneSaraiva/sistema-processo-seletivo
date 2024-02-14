package desafio_processo_seletivo.java.validator;

import desafio_processo_seletivo.java.exceptions.CandidatoNaoEncontradoException;

import java.util.List;

public class InputValidator {

    public static void validateNotEmpty(Object input, String errorMessage) throws CandidatoNaoEncontradoException{
        if(input == null || (input instanceof List && ((List<?>) input).isEmpty())){
            throw new CandidatoNaoEncontradoException(errorMessage);
        }
    }

}
