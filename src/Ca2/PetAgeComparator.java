/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ca2;

import java.util.Comparator;

/**
 *
 * @author HP
 */
public class PetAgeComparator implements Comparator<Pet>
{
    @Override
    public int compare(Pet a, Pet b)
    {
        if(a.getAge() - b.getAge() < 0)
            return -1;
        else if(a.getAge() - b.getAge() > 0)
            return 1;
        else 
            return 1;
    }
}
