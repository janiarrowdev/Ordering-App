/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateorder;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Imesha
 */
public class HibernateOrder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Date ddate = new Date(2012, 02, 23);
        PurchaseOrder p1 = new PurchaseOrder();
        p1.setSupplierName("Imesha");
        p1.setDuedate(ddate);
        
        PurchaseOrderLine line1 = new PurchaseOrderLine();
        line1.setPartName("Computer");
        line1.setAmount(1000);
        
        PurchaseOrderLine line2 = new PurchaseOrderLine();
        line2.setPartName("Printer");
        line2.setAmount(550);
       
        
        p1.addOrderLine(line1);
        p1.addOrderLine(line2);
        createOreder(p1);
        listOrder();
        
    }
    
    private static void listOrder()
    {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            List orders = session.createQuery("select p from PurchaseOrder as p").list();
            System.out.println("*** Content of the Order Table ***");
            System.out.println("*** Start ***");
            for (Iterator iter = orders.iterator(); iter.hasNext();) {
                PurchaseOrder element = (PurchaseOrder) iter.next();
                System.out.println(element);
            }
            System.out.println("*** End ***");
            tx.commit();
        } catch (RuntimeException e) {
            if(tx != null && tx.isActive())
            {
                try {
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
    }
    
    private static void createOreder(PurchaseOrder porder)
    {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.save(porder);
            tx.commit();
        } catch (RuntimeException e) {
            if(tx != null && tx.isActive())
            {
                try {
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
    }
    
    private static void updateOrder(PurchaseOrder porder)
    {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.update(porder);
            tx.commit();
        } catch (RuntimeException e) {
            if(tx != null && tx.isActive())
            {
                try {
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
    }
    
    private static void deleteOrder(PurchaseOrder porder)
    {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.delete(porder);
            tx.commit();
        } catch (RuntimeException e) {
            if(tx != null && tx.isActive())
            {
                try {
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }        
    }
    
}
