import java.util.Scanner;


public class lru {

	//int ref[],total,pageSize;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ref[],total,pageSize,count[],page[],numberOfFault;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the page size");
		pageSize = in.nextInt();
		System.out.println("Enter total number of requests");
		total = in.nextInt();
		ref = new int[total];
		page = new int[pageSize];
		count = new int[pageSize];
		for(int i=0;i<total;i++){
			ref[i] = in.nextInt();
		}
		for(int i=0;i<pageSize;i++){
			page[i] = ref[i];
			count[i] = 0;
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
					max = j;
					//break;
				}
			}
			System.out.println("\n");
			if(fault){
				numberOfFault+=1;
				for(int j=1;j<pageSize;j++){
					if(count[max]<count[j])
						max = j;
				}
				System.out.println(ref[i]);
			}
			count[max]=0;
			page[max] = ref[i];
			for(int j=0;j<pageSize;j++){
				if(j!=max)
					count[j]++;
			}
		}
		System.out.println("\nFault Rate is " + (double)numberOfFault/(double)total);
	}

}
