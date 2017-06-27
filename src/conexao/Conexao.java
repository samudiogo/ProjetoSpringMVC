package conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import util.Constantes;

public class Conexao {
	
	private static EntityManager em = null;

	public static EntityManager obterConexao() {
		
		if (em == null){
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(Constantes.PERSISTENCE_UNIT_NAME);
			
		    em = factory.createEntityManager();			
		}
	    return em;
    } 	

}
