/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author T
 */
public class Price
{
    double price = 0.42;
    
    /**
     *
     * @param price
     */
    public Price(double price)
    {
        this.price = price;
    }
    /**
     *
     * @return
     */
    public double getPrice()
    {
        return price;
    }

    /**
     *
     * @param newPrice
     */
    public void setPrice(double newPrice)
    {
        price = newPrice;
    }
}
