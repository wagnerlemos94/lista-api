package br.com.digitadasistemas.starterpack.exceptons;

import java.util.NoSuchElementException;

public class ObjetoNaoEncontrado extends NoSuchElementException{
	private static final long serialVersionUID = 1L;
	
	public ObjetoNaoEncontrado(String msg) {
		super(msg);
	}


}
