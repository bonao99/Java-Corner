/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.util.stream.Collectors;
import model.Customer;
import model.DataAccess;

/**
 *
 * @author alvindiaz
 */
public class CustomerController 
{
    DataAccess dataAccess = new DataAccess();
    
    
    public List getAllCustomer()
    {
        //THE BOSS SAID WE SHOULD ONLY SHOW ACTIVES CUSTOMERS
        
        return (List) dataAccess.getAllCustomer().stream().filter((t) -> {
            return ((Customer)t).isEnable();
        }).collect(Collectors.toList());
    }
    
    
    
    public Customer getCustomerById(String id)
    {
        return dataAccess.getCustomerById(id);
    }
    
    
     public Customer getCustomerByName(String name)
    {
        return dataAccess.getCustomerByName(name);
    }
     
     public boolean addCustomer(Customer cust)
     {
         if(dataAccess.getAllCustomer().size() >=3)
             return false;
         
         dataAccess.addCustomer(cust);
         return true;
         
         
     }
    
}
