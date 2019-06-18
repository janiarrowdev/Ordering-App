/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateorder;

/**
 *
 * @author Imesha
 */
public class PurchaseOrderLine {
    
    private int lineNo;
    private String partName;
    private int amount;
    private int orderid;

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
    
    public int getLineNo() {
        return lineNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Line No: "+getLineNo()+" Part: "+getPartName()+
                " Amount: "+getAmount();
    }
    
    
}
