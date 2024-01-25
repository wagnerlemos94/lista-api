package br.com.digitadasistemas.lista.exceptons;

import java.util.NoSuchElementException;

public class ObjetoNaoEncontradoException extends NoSuchElementException{
	private static final long serialVersionUID = 1L;
	
	public ObjetoNaoEncontradoException(String msg) {
		super(msg);
	}


}
