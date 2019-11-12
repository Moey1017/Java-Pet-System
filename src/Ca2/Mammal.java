/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ca2;

/**
 *
 * @author HP
 */
public class Mammal extends Pet
{
    private boolean isNeutered;

    public Mammal(String type, String name, String breed, int age, String colour, char gender, String regis_Date, int ownerID, boolean isNeutered)
    {
        super(type, name, breed, age, colour, gender, regis_Date, ownerID);
        this.isNeutered = isNeutered;
    }
    
    public Mammal(String type, String name, String breed, int age, String colour, char gender, String regis_Date, boolean isNeutered)
    {
        super(type, name, breed, age, colour, gender, regis_Date);
        this.isNeutered = isNeutered;
    }

    public Mammal()
    {
        super();
    }

    public boolean isIsNeutered()
    {
        return isNeutered;
    }

    public void setIsNeutered(boolean isNeutered)
    {
        this.isNeutered = isNeutered;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Mammal{" + "isNeutered=" + isNeutered + '}';
    }
   
    
}
