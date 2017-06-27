package dao;

import java.util.List;

import javax.persistence.EntityManager;

import conexao.Conexao;
import negocio.Usuario;

public class UsuarioDao {
	
	private static EntityManager conexao = null;
	
	public static Usuario obterPorId(int id){
		
		return Conexao.obterConexao().find(Usuario.class, id);
	}
	@SuppressWarnings("unchecked")
	public static List<Usuario> obterLista(){
		conexao = Conexao.obterConexao();		
		return conexao.createQuery("FROM " + Usuario.class.getName()).getResultList();
	}
	
	public static boolean incluir(Usuario usuario){
		try{
			conexao = Conexao.obterConexao();
			
			conexao.getTransaction().begin();
			
			conexao.persist(usuario);
			
			conexao.getTransaction().commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			conexao.getTransaction().rollback();
			return false;
		}
	}
	
	public static boolean alterar(Usuario usuario){

		try{
			conexao = Conexao.obterConexao();
			
			conexao.getTransaction().begin();
			
			conexao.merge(usuario);
			
			conexao.getTransaction().commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			conexao.getTransaction().rollback();
			return false;
		}
	}
	
	public static boolean excluir(Usuario usuario){
		try{
			conexao = Conexao.obterConexao();
			
			conexao.getTransaction().begin();
			
			usuario = conexao.find(Usuario.class, usuario.getId());
			
			conexao.remove(usuario);
			
			conexao.getTransaction().commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			conexao.getTransaction().rollback();
			return false;
		}
	}
}