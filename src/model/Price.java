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
    static double price = 0.47;
            
    public static double getPrice()
    {
        return price;
    }

    public static void setPrice(double newPrice)
    {
        price = newPrice;
    }
}
