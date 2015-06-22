package br.com.caelum.jdbc.teste;

import java.util.Calendar;

public class TesteRemova {

	
		public static void main(String[] args) {
			Contato contato = new Contato();
			contato.setNome("Marcos Cesar");
			contato.setEmail("marcos@oi.com.br");
			contato.setEndereco("Rua P nº 2547");
			contato.setDataNascimento(Calendar.getInstance());
			
			contato.setId(1L);
			
			ContatoDAO dao = new ContatoDAO();
			dao.remove(contato);		
			System.out.print("Item removido");
		}
	}


