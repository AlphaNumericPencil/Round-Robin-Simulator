
public class RRS {
    // Method to find the waiting time for all
    // processes
    static void calcWaitTime(int processes[], int numOfProcesses,
                 int burstTime[], int waitTime[], int quantum)
    {
        // Make a copy of burst times to store the remaining ones
        int remainingBurstTime[] = new int[numOfProcesses];
        for (int i = 0; i < numOfProcesses; i++)
            remainingBurstTime[i] =  burstTime[i];
      
        int t = 0;
      
        //Start round robin
        while(true)
        {
            boolean done = true; //this will be used to break the loop later
      
            //Iterate processes
            for (int i = 0; i < numOfProcesses; i++)
            {
                // If burst time of a process is greater than 0
                // then only need to process further
                if (remainingBurstTime[i] > 0)
                {
                    done = false; 

                    /*
                     * Time quantum. The time quantum for the associated priority. This illustrates
					 *the inverse relationship between priorities and time quanta: the
					 *lowest priority (priority 0) has the highest time quantum (200 milliseconds),
					 *and the highest priority (priority 59) has the lowest time quantum (20 milliseconds).

					 *• Time quantum expired. The new priority of a thread that has used
					 *its entire time quantum without blocking. Such threads are considered
					 *CPU-intensive. As shown in the table, these threads have their priorities lowered.
                     */
                    if (remainingBurstTime[i] > quantum) //Is the process allowed to continue?
                    {
                        t += quantum;
                        remainingBurstTime[i] -= quantum;
                    }
      
                    // If burst time is smaller than or equal to quantum, it has used up all its allocated time
                    //It will wait for the next loop
                    else
                    {
                        t = t + remainingBurstTime[i];
                        waitTime[i] = t - burstTime[i];
                        remainingBurstTime[i] = 0;  //REALLY IMPORTANT. 
                    }
                }
            }
            if (done == true)
            {
              break;
            }
        }
    }
      
    
    static void calcTurnaroundTime(int processes[], int numOfProcesses,
                            int burstTime[], int waitTime[], int turnAroundTimes[])
    	{
        // Turnaround time is calculated by adding wait time to burst time
        // burstTime[i] + waitTime[i]
        for (int i = 0; i < numOfProcesses; i++)
            turnAroundTimes[i] = burstTime[i] + waitTime[i];
    	}
      
  
    static void findavgTime(int processes[], int numOfProcesses, int burstTime[],
                                         int quantum)
    	{
        int waitTime[] = new int[numOfProcesses]; 
        int turnAroundTimes[] = new int[numOfProcesses];
        int total_waitTime = 0, totalTurnAroundTimes = 0;
      

        calcWaitTime(processes, numOfProcesses, burstTime, waitTime, quantum);
        calcTurnaroundTime(processes, numOfProcesses, burstTime, waitTime, turnAroundTimes);
     
        
      
        // Calculate totals and print
        for (int i = 0; i < numOfProcesses; i++)
        {
            total_waitTime = total_waitTime + waitTime[i];
            totalTurnAroundTimes = totalTurnAroundTimes + turnAroundTimes[i];
            System.out.println("Process " + (i+ 1) + ": " + " Burst time: " + burstTime[i] +" Waiting time: " +
                              waitTime[i] +" Turnaround Time:  " + turnAroundTimes[i]);
        }
      
    	}   
	}


