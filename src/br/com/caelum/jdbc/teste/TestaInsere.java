package br.com.caelum.jdbc.teste;

import java.util.Calendar;

public class TestaInsere {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		
		contato.setNome("Paulo Cesar");
		contato.setEmail("paulocp@oi.com.br");
		contato.setEndereco("Rua P nº 2547");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);
		
		System.out.print("Gravado");

	}

}
