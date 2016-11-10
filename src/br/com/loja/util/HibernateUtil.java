package br.com.loja.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
    	
        try {
            // Cria um SessionFactory a partir do hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure();
        	//registro serviço com hibernate
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        			.applySettings(configuration.getProperties()).build();
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	return sessionFactory;
        }
        catch (Throwable ex) {
            // Exibe mensagem de erro caso de problema
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}