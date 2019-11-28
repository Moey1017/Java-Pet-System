/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_jingsheng_moey;

import java.util.Comparator;

/**
 *
 * @author HP
 */
public class PetDateComparator implements Comparator<Pet>
{
    public int compare(Pet a, Pet b)
    {
        return a.getRegis_Date().compareTo(b.getRegis_Date());
    }
}
