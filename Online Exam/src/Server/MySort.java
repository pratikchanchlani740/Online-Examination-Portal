/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.util.Comparator;

/**
 *
 * @author HP
 */
class MySort implements Comparator {
   
		
	public int compare(Object A,Object B)
	{
		Course S1=(Course)A;
		Course S2=(Course)B;
		
		if(S1.getCid()==S2.getCid())
		{
			return 0;
			
		}
		
		else{
			return -1;
		}
		
	}		

  
}

