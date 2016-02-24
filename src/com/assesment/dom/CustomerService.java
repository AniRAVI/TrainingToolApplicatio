package com.assesment.dom;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
	public List<AssesmentDO>geCustomerTOs(){
		List<AssesmentDO>custlist=new ArrayList<AssesmentDO>();
		AssesmentDO cTo=new AssesmentDO();
	/*	cTo.setCid("C-101");
		cTo.setCname("Amitesh");
		cTo.setEmail("ami@gmail.com");
		cTo.setPhone("111111");
		cTo.setCity("Blore");
		cTo.setStatus("Full form of AT & T ??");
		*/
		custlist.add(cTo);
		custlist.add(cTo);
		custlist.add(cTo);
		custlist.add(cTo);
		custlist.add(cTo);
		custlist.add(cTo);
		
		
		return custlist;
		
	}
	
	
	
	
}
