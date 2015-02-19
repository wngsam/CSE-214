//Sam Wang
//ID: 108107971
//Homework 4
//CSE214
//Recitation 4 TA: Varun Agrawal 
/**
 * The simulator class that does the simulation of shopping queues.
 * @author Sam
 *
 */
public class Simulator {
	/**
	 * The simulation method that calculates the average waiting time of the shopping queue.
	 * @param numCashiers
	 * Number of cashiers available
	 * @param arrivalProb
	 * The probability a customer arrives
	 * @param maxItems
	 * The max number of items a customer may have
	 * @param scanSpeed
	 * The speed in which a customer's items are scanned at.
	 * @param simMinutes
	 * The amount of time the simulation with take place in.
	 * @return
	 */
	public static double avgWaitTime(int numCashiers, double arrivalProb, int maxItems, int scanSpeed, int simMinutes)
	{
		int customersHelped=0;
		int time =0;
		int totalWaitTime=0;
		BooleanSource temp = new BooleanSource(arrivalProb);
		BooleanSource items = new BooleanSource(0.5);
		
		Queue[] array = new Queue[numCashiers];
		for(int i=0;i<numCashiers;i++){
			array[i] = new Queue();
		}
		
		for (int i=0;i<simMinutes*60;i++){
			
			//If Arrival
			if(temp.occurs()==true){

				int item=0;
				if(maxItems<6){
					item+=(int)(Math.random()*(maxItems-1))+1;
				}
				else if(items.occurs()==false){
					
					item+= (int)(Math.random()*(maxItems-5))+6;
				}
				else{
					item+= (int)(Math.random()*5)+1;
				}
				Customer tempC = new Customer(time,item);
				//System.out.println("New Customer with "+item+" arrives at "+tempC.arrivalTime);//TEST
				if(item<16){
					//Eligible for Express
					
					int j=1;
					for(int k=1;k<array.length;k++){
						if((k+1)!=array.length && (array[k].size())>(array[k+1].size())){
								j=k+1;
						}
					}
					if(array[0].size()==0 || (array[j].size())>((double)array[0].size()/2)){
						array[0].enqueue(tempC);
						array[0].waitTime.add(item*scanSpeed);
						//System.out.println("Customer Express Lane");//TEST
					}
					else{
						
							array[j].enqueue(tempC);
							array[j].waitTime.add(item*scanSpeed);
							//System.out.println("Customer Lane: "+j);//TEST

						
					}
				}
				else{
					int j=1;
					for(int k=1;k<array.length;k++){
						if((k+1)!=array.length && (array[k].size())>(array[k+1].size())){
								j=k+1;
						}
					}
					array[j].enqueue(tempC);
					array[j].waitTime.add(item*scanSpeed);
					//System.out.println("Customer Lane: "+j);//TEST
				}
			}
			//
			
			for(int p=0;p<array.length;p++){
				if(array[p].isEmpty()==false){
					if(array[p].waitTime.getFirst()==0){
						//System.out.println("-A customer done.");//TEST
						if((array[p].size())>1){
						totalWaitTime+=(time-(array[p].get(1).arrivalTime));
						//System.out.println("*Time: "+time+" aT: "+array[p].get(1).arrivalTime);//TEST
						//System.out.println("*"+(time-(array[p].get(1).arrivalTime)));//TEST
						}
						
						array[p].waitTime.removeFirst();
						array[p].dequeue();
						
						

						customersHelped=customersHelped+1;

					}
					else{
						int g =array[p].waitTime.getFirst();
						array[p].waitTime.set(0,g-1);
					}
				}
				
			}
			
			time++;
			//System.out.println("-----");
		
		}
		//System.out.println("Total Number of Customers Helped: "+customersHelped);
		//System.out.println("Total Waiting Time: "+totalWaitTime);
		//System.out.println("-------------------");
		double averageWaitTime = (double) totalWaitTime/customersHelped;
		return averageWaitTime;
	}
	
	
}