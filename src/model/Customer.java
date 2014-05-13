/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Thim
 */
public class Customer
{
    private String uID;
    private String firstName;
    private String lastName;
    private String balance; 
    private String creditLimit;
    private String email;   
    private String tlf;
    
    private String password = "1234";
    //private String tempPassword; // Nice to have

    public Customer(String uID, String firstName, String lastName, String balance, String creditLimit, String email, String tlf, String password)
    {
        this.uID = uID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.email = email;
        this.tlf = tlf;
        this.password = password;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Get the value of uID
     *
     * @return the value of uID
     */
    public String getUID()
    {
        return uID;
    }

    /**
     * Set the value of uID
     *
     * @param uID new value of uID
     */
    public void setUID(String uID)
    {
        this.uID = uID;
    }

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }    
    
    /**
     * Set the value of balance
     *
     * @param balance new value of firstName
     */
    public void setBalance(String balance)
    {
        this.balance = balance;
    }
    
    public String getBalance()
    {
        return balance;
    }
    
    public void setCreditLimit(String creditLimit)
    {
        this.creditLimit = creditLimit;
    }
    
    public String getCreditLimit()
    {
        return creditLimit;
    }

    public void setTlf(String tlf)
    {
        this.tlf = tlf;
    }
    
    public String getTlf()
    {
        return tlf;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return password;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Customer other = (Customer) obj;
        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName))
        {
            return false;
        }
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName))
        {
            return false;
        }
        if ((this.uID == null) ? (other.uID != null) : !this.uID.equals(other.uID))
        {
            return false;
        }
        if ((this.balance == null) ? (other.balance != null) : !this.balance.equals(other.balance))
        {
            return false;
        }
        if ((this.creditLimit == null) ? (other.creditLimit != null) : !this.creditLimit.equals(other.creditLimit))
        {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email))
        {
            return false;
        }
        if ((this.tlf == null) ? (other.tlf != null) : !this.tlf.equals(other.tlf))
        {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 59 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 59 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 59 * hash + (this.uID != null ? this.uID.hashCode() : 0);
        hash = 59 * hash + (this.balance != null ? this.balance.hashCode() : 0);
        hash = 59 * hash + (this.creditLimit != null ? this.creditLimit.hashCode() : 0);
        hash = 59 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 59 * hash + (this.tlf != null ? this.tlf.hashCode() : 0);
        hash = 59 * hash + (this.password != null ? this.password.hashCode() : 0);
        return hash;
    }
}
