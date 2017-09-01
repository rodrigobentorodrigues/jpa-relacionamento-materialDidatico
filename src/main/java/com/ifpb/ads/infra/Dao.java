
package com.ifpb.ads.infra;

import com.ifpb.jpa.entidades.MaterialDidatico;
import com.ifpb.jpa.entidades.MaterialDidaticoPK;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Dao {
    
    private final EntityManager manager;
    private final EntityTransaction transaction;
    
    public Dao(){
        this.manager = Persistence.createEntityManagerFactory("UPersistence").
                createEntityManager();
        this.transaction = manager.getTransaction();
    }
    
    public void add (MaterialDidatico md){
        transaction.begin();
        manager.persist(md);
        transaction.commit();
    }
    
    public void upgrade (MaterialDidatico md){
        transaction.begin();
        manager.merge(md);
        transaction.commit();
    }
    
    public void remove (MaterialDidatico md){
        MaterialDidatico aux = manager.
                find(MaterialDidatico.class, md.getChaveComposta());
        transaction.begin();
        manager.remove(aux);
        transaction.commit();
    }
    
}
