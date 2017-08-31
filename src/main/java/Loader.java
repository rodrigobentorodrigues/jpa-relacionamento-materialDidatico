
import com.ifpb.jpa.entidades.MaterialDidatico;
import com.ifpb.jpa.entidades.MaterialDidaticoPK;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Loader {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPersistence"); 
        MaterialDidaticoPK pk = new MaterialDidaticoPK();
        pk.setCodigo(1);
        pk.setOrigem("Laboratorio");
        MaterialDidatico m = new MaterialDidatico(pk, "Teste", "Teste", "Teste", true, 200.00);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();
    }
    
}
