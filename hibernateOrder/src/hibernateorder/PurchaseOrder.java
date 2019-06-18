/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateorder;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 *
 * @author Imesha
 */
public class PurchaseOrder {
    
    private int orderId;
    private String supplierName;
    private Date duedate;
    private Set parts;

    public PurchaseOrder() {
       parts = new HashSet();
    }

     public Set getParts() {
        return parts;
    }

    public void setParts(Set parts) {
        this.parts = parts;
    }
    
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public void addOrderLine(PurchaseOrderLine poline)
    {
        this.parts.add(poline);
    }
    
    public void removeOrderLine(PurchaseOrderLine poline)
    {
        this.parts.remove(poline);
    }
    
    @Override
    public String toString() {
        String orderString = "Order: "+getOrderId()+
                " Supplier: "+getSupplierName()+
                " Due Date: "+getDuedate();
        String partsString = "";
        for (Iterator iter = parts.iterator(); iter.hasNext();) {
            PurchaseOrderLine element = (PurchaseOrderLine) iter.next();
            partsString = partsString+"\t\t"+element.toString()+"\n";
        }
        return orderString+"\n"+partsString;
    }
    
    
    
}
