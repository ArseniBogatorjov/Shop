/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import java.util.Objects;


public class Costumer implements Serializable {
    private String cFirstname;
    private String cLastname;
    private int cTelNumber;
    private double cBalance;

    public Costumer() {
    }

    public Costumer(String cFirstname, String cLastname, int cTelNumber, double cBalance) {
        this.cFirstname = cFirstname;
        this.cLastname = cLastname;
        this.cTelNumber = cTelNumber;
        this.cBalance = cBalance;
    }

    public String getcFirstname() {
        return cFirstname;
    }

    public void setcFirstname(String cFirstname) {
        this.cFirstname = cFirstname;
    }

    public String getcLastname() {
        return cLastname;
    }

    public void setcLastname(String cLastname) {
        this.cLastname = cLastname;
    }

    public int getcTelNumber() {
        return cTelNumber;
    }

    public void setcTelNumber(int cTelNumber) {
        this.cTelNumber = cTelNumber;
    }

    public double getcBalance() {
        return cBalance;
    }

    public void setcBalance(double cBalance) {
        this.cBalance = cBalance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.cFirstname);
        hash = 79 * hash + Objects.hashCode(this.cLastname);
        hash = 79 * hash + this.cTelNumber;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.cBalance) ^ (Double.doubleToLongBits(this.cBalance) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Costumer other = (Costumer) obj;
        if (this.cTelNumber != other.cTelNumber) {
            return false;
        }
        if (Double.doubleToLongBits(this.cBalance) != Double.doubleToLongBits(other.cBalance)) {
            return false;
        }
        if (!Objects.equals(this.cFirstname, other.cFirstname)) {
            return false;
        }
        if (!Objects.equals(this.cLastname, other.cLastname)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Costumer{" + "cFirstname=" + cFirstname + ", cLastname=" + cLastname + ", cTelNumber=" + cTelNumber + ", cBalance=" + cBalance + '}';
    }
    
}
