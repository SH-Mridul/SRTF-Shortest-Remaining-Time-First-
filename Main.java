package SRTF;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws IOException
	 {
		  Scanner br = new Scanner(System.in);
	      int n;
	      StringBuilder totalProcessTime = new StringBuilder();
	      totalProcessTime.append(0+"\t\t");
	      System.out.print("Please enter the number of Processes: ");
	       n = br.nextInt();
	       int proc[][] = new int[n + 1][4];
	       for(int i = 1; i <= n; i++)
	       {
	      System.out.print("Please enter the Arrival Time for Process " + i + ": ");
	      proc[i][0] = br.nextInt();
	      System.out.print("Please enter the Burst Time for Process " + i + ": ");
	      proc[i][1] =  br.nextInt();
	     }
	       System.out.println();
	     
	     int total_time = 0;
	     for(int i = 1; i <= n; i++)
	     {
	      total_time += proc[i][1];
	     }
	     int time_chart[] = new int[total_time];
	     
	     for(int i = 0; i < total_time; i++)
	     {
	      int sel_proc = 0;
	      int min = 99999;
	      for(int j = 1; j <= n; j++)
	      {
	       if(proc[j][0] <= i)
	       {
	        if(proc[j][1] < min && proc[j][1] != 0)
	        {
	         min = proc[j][1];
	         sel_proc = j;
	        }
	       }
	      }
	      
	      time_chart[i] = sel_proc;
	      
	  
	      proc[sel_proc][1]--;
	      
	   
	      for(int j = 1; j <= n; j++)
	      {
	       if(proc[j][0] <= i)
	       {
	        if(proc[j][1] != 0)
	        {
	         proc[j][3]++;
	            if(j != sel_proc)
	             proc[j][2]++;
	        }
	        else if(j == sel_proc)
	         proc[j][3]++;
	       }
	      }
	      
	      //chart from here
	      
	      if(i != 0)
	      {
	       if(sel_proc != time_chart[i - 1])
	       {
	    	  System.out.print("\tP"+sel_proc+"\t|");
	    	  totalProcessTime.append(i+"\t\t");
	       }
	      }
	      else
	      System.out.print("\tP"+sel_proc+"\t|");
	      
	     }
	     System.out.println();
	     totalProcessTime.append(total_time);
	     System.out.println(totalProcessTime);
	     System.out.println();
	     System.out.println();
	     
	     //Printing the WT and TT for each Process
	     System.out.println("P.Id\t W.T \t T.T ");
	     for(int i = 1; i <= n; i++)
	     {
	      System.out.printf("%d\t%2d\t%2d",i,proc[i][2],proc[i][3]);
	      System.out.println();
	     }
	     
	     System.out.println();
	     
	     //Printing the average WT & TT
	     float WT = 0,TT = 0;
	     for(int i = 1; i <= n; i++)
	     {
	      WT += proc[i][2];
	      TT += proc[i][3];
	     }
	     WT /= n;
	     TT /= n;
	     System.out.println("The Average WT is: " + WT);
	     System.out.println("The Average TT is: " + TT);
	     br.close();
	 }
}
