package org.lesya.util;


import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.lesya.entity.Car;
import org.lesya.entity.Model;
import org.lesya.entity.Rent;
import org.lesya.entity.User;

@UtilityClass
public class HibernateUtil {

    public static SessionFactory buildSessionFactory() {
        Configuration configuration = buildConfiguration();
        configuration.configure();
        var sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }


    public static Configuration buildConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(Rent.class);
        configuration.addAnnotatedClass(Model.class);
        //configuration.registerTypeOverride(new JsonBinaryType());
        return configuration;
    }
}

