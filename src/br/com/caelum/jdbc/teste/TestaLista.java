package br.com.caelum.jdbc.teste;

import java.util.List;

public class TestaLista {

	public static void main(String[] args) {
		
		ContatoDAO dao = new ContatoDAO();
		
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato: contatos){
			System.out.println("Nome:" + contato.getNome());
			System.out.println("E-mail:" + contato.getEmail());
			System.out.println("Endereço:" + contato.getEndereco());
			System.out.println("Data de nascimento:" + contato.getDataNascimento().getTime() + "\n");
			
		}
	}

}
