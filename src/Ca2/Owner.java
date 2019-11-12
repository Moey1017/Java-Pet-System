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
public class Owner
{
    private String name;
    private String email;
    private String telephone;
    private String home_Address;
    private int id;
    public static int current_owner = 0;

    public Owner(String name, String email, String telephone, String home_Address)
    {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.home_Address = home_Address;
        this.id = current_owner;
        current_owner++;
    }

    public Owner()
    {
        this.id = current_owner;
        current_owner++;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public String getEmail()
    {
        return email;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public String getHome_Address()
    {
        return home_Address;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public void setHome_Address(String home_Address)
    {
        this.home_Address = home_Address;
    }
    
    
}
