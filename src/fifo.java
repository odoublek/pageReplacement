import java.util.Scanner;


public class fifo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ref[],total,pageSize,c=0,page[],numberOfFault;
		Scanner in = new Scanner(System.in);
		System.out.println("FIFO - Enter the page size");
		pageSize = in.nextInt();
		System.out.println("Enter total number of requests");
		total = in.nextInt();
		ref = new int[total];
		page = new int[pageSize];
		for(int i=0;i<total;i++){
			ref[i] = in.nextInt();
		}
		for(int i=0;i<pageSize;i++){
			page[i] = ref[i];
			//System.out.print(i + "->");
		}
		numberOfFault=pageSize;
		for(int i=pageSize;i<total;i++){
			boolean fault = true;
			for(int j=0;j<pageSize;j++){
				System.out.print(page[j] + " ");
				if(ref[i] == page[j]){
					fault = false;
					//max = j;
					//break;
				}
			}
			System.out.println("\n");
			if(fault){
				numberOfFault+=1;
				System.out.println(ref[i]);

				page[c] = ref[i];
				c=(c+1)%pageSize;
			}
		}
		System.out.println("\nFault Rate is " + (double)numberOfFault/(double)total);
	}

}
