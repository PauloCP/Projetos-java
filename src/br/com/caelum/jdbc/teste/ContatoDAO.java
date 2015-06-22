package br.com.caelum.jdbc.teste;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;

import com.mysql.jdbc.PreparedStatement;

public class ContatoDAO {

	
		
		private Connection connection;
		
		public ContatoDAO(){
			this.connection = new ConnectionFactory().getConnection();
		}

		
		public void adiciona(Contato contato){
			String sql = "insert into contatos"
					+ "(nome,email,endereco,dataNascimento)"
					+ "values (?,?,?,?)";
			try{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setString(1,contato.getNome());
				stmt.setString(2,contato.getEmail());
				stmt.setString(3,contato.getEndereco());
				stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
				
				stmt.execute();
				stmt.close();
			}catch (SQLException e){
				throw new RuntimeException(e);
			}
		}
		
	//---------------------------------------------------------	
		
		public List<Contato> getLista(){
			try{
				List<Contato> contatos = new ArrayList<Contato>();
				PreparedStatement stmt = (PreparedStatement) this.connection.
						prepareStatement("select * from contatos");
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()){
					
					//criando o objeto Contato
					Contato contato = new Contato();
					contato.setId(rs.getLong("id"));
					contato.setNome(rs.getString("nome"));
					contato.setEmail(rs.getString("email"));
					contato.setEndereco(rs.getString("endereco"));
					
					//montadp a data através do Calendar
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataNascimento"));
					contato.setDataNascimento(data);
					
					//adicionando um objeto a lista
					contatos.add(contato);
				}
				
				rs.close();
				stmt.close();
				return contatos;
				
			}catch (SQLException e){
				throw new RuntimeException(e);
			}
		}
		
	//--------------------------------------------------------	
	
		public void altera(Contato contato){
			String sql = "update contatos set nome=?, email=?,"+
						 "endereco=?,dataNascimento=? where id=?";	
		
			try{
				PreparedStatement stmt = (PreparedStatement) connection
						.prepareStatement(sql);
				stmt.setString(1,contato.getNome());
				stmt.setString(2,contato.getEmail());
				stmt.setString(3,contato.getEndereco());
				stmt.setDate(4,new Date(contato.getDataNascimento()
						.getTimeInMillis()));
				stmt.setLong(5,contato.getId());
				stmt.execute();
				stmt.close();
			   
			}catch (SQLException e){
				throw new RuntimeException(e);
				//
			}
		}
		
	//-------------------------------------------------------
		
		
		public void remove(Contato contato){
			try{
				PreparedStatement stmt = (PreparedStatement) connection
						.prepareStatement("delete from contatos where id=?");
				stmt.setLong(1,contato.getId());
				stmt.execute();
				stmt.close();
			   
			}catch (SQLException e){
				throw new RuntimeException(e);
				
			}
				
		}
	//-------------------------------------------------------	
			
		
		

}


