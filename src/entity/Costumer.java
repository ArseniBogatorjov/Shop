
package entity;
import java.io.Serializable;

import java.util.Objects;


public class Costumer implements Serializable {
    private String Firstname;
    private String Lastname;
    private int TelNumber;
    private double Balance;
    
     public String getFullName() {
        return Firstname + " " + Lastname;
    }
     
    public void subtractBalance(double amount) {
        if (amount <= Balance) {
            Balance -= amount;
        } else {
            System.out.println("Error: Insufficient funds.");
        }
    }

    public double getBalance() {
        return Balance;
    }

    public void addBalance(double amount) {
        Balance += amount;
    }


    public Costumer(String cFirstname, String cLastname, int cTelNumber, double cBalance) {
        this.Firstname = cFirstname;
        this.Lastname = cLastname;
        this.TelNumber = cTelNumber;
        this.Balance = cBalance;

    }

    
    public String getcFirstname() {
        return Firstname;
    }

    public void setcFirstname(String cFirstname) {
        this.Firstname = Firstname;
    }

    public String getcLastname() {
        return Lastname;
    }

    public void setcLastname(String cLastname) {
        this.Lastname = cLastname;
    }

    public int getcTelNumber() {
        return TelNumber;
    }

    public void setcTelNumber(int cTelNumber) {
        this.TelNumber = cTelNumber;
    }

    public double getcBalance() {
        return Balance;
    }

    public void setcBalance(double cBalance) {
        this.Balance = cBalance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.Firstname);
        hash = 79 * hash + Objects.hashCode(this.Lastname);
        hash = 79 * hash + this.TelNumber;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.Balance) ^ (Double.doubleToLongBits(this.Balance) >>> 32));
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
        if (this.TelNumber != other.TelNumber) {
            return false;
        }
        if (Double.doubleToLongBits(this.Balance) != Double.doubleToLongBits(other.Balance)) {
            return false;
        }
        if (!Objects.equals(this.Firstname, other.Firstname)) {
            return false;
        }
        if (!Objects.equals(this.Lastname, other.Lastname)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Costumer: " + "Firstname=" + Firstname + ", Lastname=" + Lastname + ", TelNumber=" + TelNumber + ", Balance=" + Balance;
    }

 
}
