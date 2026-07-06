package id.herald;

import org.hibernate.Session;
import id.herald.Modal.UserClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {

        UserClass userClass=new UserClass();
        userClass.setId(123);
        userClass.setPhone("9828026649");

        SessionFactory sf= new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();

        session.beginTransaction();
        session.persist(userClass);

        session.beginTransaction().commit();
        session.close();


    }
}
