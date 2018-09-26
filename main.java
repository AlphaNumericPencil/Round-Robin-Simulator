   
public class main extends RRS{
public static void main(String[] args){
        
        int processes[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; //The ID of each process
        int burstTime[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 }; //"Priority" of each process
        int numOfProcesses = 10; //duh.
        int quantum = 5; //The amount of time each process will have spent on it
        findavgTime(processes, numOfProcesses, burstTime, quantum);
    }
}