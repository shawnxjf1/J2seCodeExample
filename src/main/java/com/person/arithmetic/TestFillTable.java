package com.person.arithmetic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestFillTable {
	
	class model
	{
		private Date day ;
		private int amount;
		public Date getDay() {
			return day;
		}
		public void setDay(Date day) {
			this.day = day;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		
		
	}
	
	public void fillByNearBy(Date curDay)
	{
		
	}
	
	public List<model>fillDateFromTable()
	{
		//list1 = select * from table order by day ;
		List<model> list1 = new ArrayList<TestFillTable.model>();
		
		int leftMostHaveValue = 0;
		/**
		 * trans list1,begin 0 to size-2.
		 */
		for (int i=0; i< list1.size() -1;i++)
		{
			// amount =0 stander for null value.
//			if (list1.get(i).amount > 0)
//			{
//				leftMostHaveValue = i;
//			}
			//set for i, left right both have value.
			// i =0 have value
			
			if (list1.get(i).amount >0)
			{
				continue;
			}
			
			if (i == 0 )
			{
				if (list1.get(i+1).amount >0)
				{
					list1.get(i).setAmount(list1.get(i+1).amount/2);
				}else
				{
				  list1.get(i).setAmount(0);
				}
				continue;
			}
			
		    // i-1 has been calculated.
			if (list1.get(i+1).amount >0)
			{
				list1.get(i).setAmount((list1.get(i-1).amount + list1.get(i+1).amount)/2);
			}
			
			else if (list1.get(i+1).amount == 0)
			{
				list1.get(i).setAmount(list1.get(i-1).amount);
			}
			//i =0 null value
		}
		list1.get(list1.size()-1).setAmount(list1.get(list1.size()-2).amount);
	}

}
