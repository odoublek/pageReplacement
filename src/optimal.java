import java.util.Scanner;


public class optimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ref[],total,pageSize,time[],page[],numberOfFault;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the page size");
		pageSize = in.nextInt();
		System.out.println("Enter total number of requests");
		total = in.nextInt();
		ref = new int[total];
		page = new int[pageSize];
		time = new int[pageSize];
		for(int i=0;i<total;i++){
			ref[i] = in.nextInt();
		}
		for(int i=0;i<pageSize;i++){
			page[i] = ref[i];
			time[i] = 100000;
			//System.out.print(i + "->");
		}
		numberOfFault=pageSize;
		for(int i=pageSize;i<total;i++){
			int max = 0;
			boolean fault = true;
			for(int j=0;j<pageSize;j++){
				System.out.print(page[j] + " ");
				if(ref[i] == page[j]){
					fault = false;
		//			max = j;
					//break;
				}
			}
			System.out.println("\n");
			if(fault){
				numberOfFault+=1;
			/*	for(int j=1;j<pageSize;j++){
					if(count[max]<count[j])
						max = j;
				}*/
				for(int j=i+1;j<total;j++){
					for(int k=0;k<pageSize;k++){
						if(ref[j] == page[k]&&time[k]>i){
							time[k]=i;
						}
					}
					max=0;
				}
				for(int j=0;j<pageSize;j++){
					if(time[max]>time[j])
						max=j;
				}
				System.out.println(ref[i]);
			}
			time[max]=10000;
			page[max] = ref[i];
			
		}
		System.out.println("\nFault Rate is " + (double)numberOfFault/(double)total);

	}

}
