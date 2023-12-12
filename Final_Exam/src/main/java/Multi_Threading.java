/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author husnain
 */
public class Multi_Threading extends Thread
{
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            try
            {
               Thread.sleep(1000);
               
            }
            catch(InterruptedException e)
            {
                      System.out.println(e);  
            }
            System.out.println(i);  
            
        }
    }
    public static void main(String arg[])
    {
        Multi_Threading t1=new Multi_Threading();
        Multi_Threading t2=new Multi_Threading();
        
        t1.start();   
        t2.start();

        
    }

 
}
