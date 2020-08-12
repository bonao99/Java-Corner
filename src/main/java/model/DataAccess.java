/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alvindiaz
 */
public class DataAccess 
{
   
    
    private List<Customer> database = new ArrayList<>();
    
    public void addCustomer(Customer cust)
    {
        database.add(cust);
    }
    
    public List getAllCustomer()
    {
        return database;
    }
    
    public Customer getCustomerById(String id)
    {
        for(Customer cust: database)
        {
            if(cust.getId().equals(id))
                return cust;
        }
        
        return null;
    }
    
    public Customer getCustomerByName(String name)
    {
        for(Customer cust: database)
        {
            if(cust.getName().toLowerCase().equals(name.toLowerCase()))
                return cust;
        }
        
        return null;
    }
    
    
    
    
}
