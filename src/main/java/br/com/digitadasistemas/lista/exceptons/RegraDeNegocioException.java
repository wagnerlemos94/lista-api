package br.com.digitadasistemas.lista.exceptons;

import java.util.NoSuchElementException;

public class RegraDeNegocioException extends NoSuchElementException{
	private static final long serialVersionUID = 1L;

	public RegraDeNegocioException(String msg) {
		super(msg);
	}


}
