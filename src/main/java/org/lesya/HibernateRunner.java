package org.lesya;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.lesya.dao.CarRepository;
import org.lesya.dao.RentRepository;
import org.lesya.util.HibernateUtil;
import org.hibernate.Session;
import java.lang.reflect.Proxy;
import java.sql.SQLException;

@Slf4j
public class HibernateRunner {

    @Transactional
    public static void main(String[] args) throws SQLException {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            var session = (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(), new Class[]{Session.class},
                    (proxy, method, args1) -> method.invoke(sessionFactory.getCurrentSession(), args1));
            session.beginTransaction();
            var carRepository = new CarRepository(session);
            var rentRepository = new RentRepository(session);
            carRepository.findById(1).ifPresent(System.out::println);
            rentRepository.findById(8).ifPresent(System.out::println) ;
            session.getTransaction().commit();
        }
    }
}
