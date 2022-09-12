package Util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    public HibernateUtil() {
    }

    private static final EntityManagerFactory emf;
    static {
        emf = Persistence.createEntityManagerFactory("default");
    }
    public static EntityManagerFactory getEmf(){
        return emf;
    }
}
