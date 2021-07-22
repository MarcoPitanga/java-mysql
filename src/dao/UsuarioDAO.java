package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import factory.ConnectionFactory;
import model.Usuario;

public class UsuarioDAO {
	
	public void save(Usuario usuario) {
		
		String sql = "INSERT INTO usuarios VALUES (default, ?, ?)";
		
		Connection conn = null;
		
		PreparedStatement statement = null;
		
		try {
			//Criar uma conexão com banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//PreparedStatement para executar a query
			statement = conn.prepareStatement(sql);
			
			//Adicionar os valores esperados pela query
			statement.setString(1, usuario.getSenha());
			statement.setString(2, usuario.getNome());
			
			//Executar a query
			statement.execute();
			
			JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso!", "Sucesso!", 1);
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			//Fechar as conexões
			try {
				if(statement != null) {
					statement.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	
	public ArrayList<Usuario> listaUsuarios() throws Exception{
		
		String sql = "SELECT * FROM usuarios";
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		Connection conn = null;
		PreparedStatement statement = null;
		
		//Classe que vai recuperar os dados do banco.  ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			statement = conn.prepareStatement(sql);
			
			// salvar as informaçoes que vem do banco
			rset = statement.executeQuery();
			
			//Enquanto tiver dados para percorrer em rset, ele vai rodar o while
			while (rset.next()) {
				Usuario usuario = new Usuario();
				
				//passando as informaçoes do rset para uma variavel. obs: dentro da funçao rset.getString ou getInt, o parametro é o nome da coluna do banco
				usuario.setMatricula(rset.getInt("matricula"));
				usuario.setSenha(rset.getString("senha"));
				usuario.setNome(rset.getString("nome"));
				
				usuarios.add(usuario);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();
				}
				
				if(statement != null) {
					statement.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return usuarios;
	}

	
	public void delete(Usuario usuario) {
		String sql = "DELETE FROM usuarios WHERE matricula = ?";
		
		Connection conn = null;
		
		PreparedStatement statement = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			statement = conn.prepareStatement(sql);
			
			statement.setInt(1, usuario.getMatricula());
			
			statement.execute();
			
			JOptionPane.showMessageDialog(null, "Usuario Deletado com sucesso!", "Sucesso!", 1);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	public void update(Usuario usuario) {
		String sql = "UPDATE usuarios SET senha = ? WHERE matricula = ?";
		
		Connection conn = null;
		
		PreparedStatement statement = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, usuario.getSenha());
			statement.setInt(2, usuario.getMatricula());
			
			statement.execute();
			
			JOptionPane.showMessageDialog(null, "Senha Alterada com sucesso!","Sucesso!",1);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public Usuario login(Usuario usuario) {
		
		String sql = "SELECT * FROM usuarios WHERE matricula = ? AND senha = ?";
		
		Connection conn = null;
		PreparedStatement statement = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			statement = conn.prepareStatement(sql);
			
			statement.setInt(1, usuario.getMatricula());
			statement.setString(2, usuario.getSenha());
			
			rset = statement.executeQuery();
			if(rset != null && rset.next()) {
				usuario.setMatricula(rset.getInt("matricula"));
				usuario.setSenha(rset.getString("senha"));
				usuario.setNome(rset.getString("nome"));
				JOptionPane.showMessageDialog(null, "Bem vindo(a), "+rset.getString("nome")+" !","Sucesso!", 1);
				return usuario;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();
				}
				
				if(statement != null) {
					statement.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		JOptionPane.showMessageDialog(null, "Matricula ou Senha incorreta!","Falha!",0);
		return null;
	}

	public Usuario buscar(Usuario usuario) throws Exception{
		
		String sql = "SELECT * FROM usuarios WHERE nome LIKE ?";
		
		Connection conn = null;
		PreparedStatement statement = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, "%"+usuario.getNome()+"%");
			
			rset = statement.executeQuery();
			
			JOptionPane.showMessageDialog(null, "Nome: "+rset.getString("nome")+"  Matricula: "+rset.getInt("matricula"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return usuario;
	}

}
