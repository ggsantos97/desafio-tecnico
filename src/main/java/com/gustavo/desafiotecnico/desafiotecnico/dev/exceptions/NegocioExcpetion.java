package com.gustavo.desafiotecnico.desafiotecnico.dev.exceptions;

public class NegocioExcpetion extends Exception{

	public NegocioExcpetion(String mensagem) {
	super(mensagem);
	}
	
	public NegocioExcpetion(final Throwable t) {
		super(t);
	}

	public NegocioExcpetion(final String mensagem, final Throwable t) {
		super(mensagem, t);
	}
}
