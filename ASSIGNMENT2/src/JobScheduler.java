import java.util.Scanner;
/*This is an Application Class. 
 * The Execution starts from here. * 
 */
public class JobScheduler {
	
	// Return completion time for process
	/**
	 * @param arr array which contains arrival time and burst time
	 * @param n = no of jobs
	 * @param turnAroundTime 
	 * @param completeTime
	 */
	public void CompletionTime(int arr[][], int n, int turnAroundTime[], int completeTime[]) {
		for (int i = 0; i < n; i++) {
			completeTime[i] = arr[i][0] + turnAroundTime[i];
		}
	}
    // Return Waiting time for processes
	/**
	 * @param arr = array which contains arrival time and burst time
	 * @param n =  no of jobs
	 * @param waitingTime
	 */
	public void WaitingTime(int arr[][], int n, int waitingTime[]) {

		int service_time[] = new int[n];
		service_time[0] = 0;
		waitingTime[0] = 0;

		// calculating waiting time
		for (int i = 1; i < n; i++) {
			// Add burst time of previous processes
			service_time[i] = service_time[i - 1] + arr[i - 1][1];

			// Find waiting time for current process =
			// sum - at[i]
			waitingTime[i] = service_time[i] - arr[i][0];

			// If waiting time for a process is in negative
			// that means it is already in the ready queue
			// before CPU becomes idle so its waiting time is 0
			if (waitingTime[i] < 0)
				waitingTime[i] = 0;
		}

	}
	// Return TurnAround time for processes
	/**
	 * @param arr = array which contains arrival time and burst time
	 * @param n =  no of jobs
	 * @param waitingTime
	 * @param turnAroundTime
	 */
	public void TurnAroundTime(int arr[][], int n, int waitingTime[], int turnAroundTime[]) {

		for (int i = 0; i < n; i++) {
			turnAroundTime[i] = waitingTime[i] + arr[i][1];
		}
	}
	
	// Displays process,arrival time,burst time,turn around time,completion time,average waiting time and max waiting time for a process
	/**
	 * @param job = array which contains arrival time and burst time
	 * @param n = no of jobs
	 * @param waitingTime
	 * @param turnAroundTime
	 * @param completeTime
	 */
	public void show(int job[][], int n, int waitingTime[], int turnAroundTime[], int completeTime[]) {
		
		System.out.println("process\t\tArrival Time\tBurst Time\tWaiting Time\tTurnAround Time\t\tCompletion Time");
		System.out.println("-------------------------------------------------------------------------------------------------------");
		int totalWaitingTime = 0;
		for(int i=0; i < n; i++) {
			totalWaitingTime += waitingTime[i]; 
			System.out.println("  "+ (i + 1) +"\t\t    "+job[i][0]+"\t\t    "+job[i][1]+"\t\t    "+waitingTime[i]+"\t\t    "+turnAroundTime[i]+"\t\t\t    "+completeTime[i]);
		}
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println("Average waiting time = " + (float)totalWaitingTime / (float)n);
		int max = waitingTime[0];
		for(int j = 1; j < n; j++) {
			if(max < waitingTime[j])
				max = waitingTime[j];
		}
		System.out.println("Maximum waiting time period for a process in queue = " + max);
	}

	// Sorting Process in assending order of therir arrival time
	/**
	 * @param arr = array which contains arrival time and burst time
	 * @param n = no of jobs
	 */
	public void Sort(int arr[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (arr[j][0] < arr[i][0]) {
					int temp1 = arr[j][0];
					int temp2 = arr[j][1];
					arr[j][0] = arr[i][0];
					arr[j][1] = arr[i][1];
					arr[i][0] = temp1;
					arr[i][1] = temp2;
				}

			}

		}
	}

	public static void main(String[] args) {
// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		JobScheduler object to use its instance methods
		JobScheduler js = new JobScheduler();
		System.out.println("Enter no of jobs");
		int n = sc.nextInt();
		int waitingTime[] = new int[n];       //an Array which stores waiting time of Processes 
		int turnAroundTime[] = new int[n];    //an Array which stores TurnAround time of Processes
		int completeTime[] = new int[n];      //an Array which stores Completion time of Processes
		int job[][] = new int[n][2];          //an Array which stores arrival time and burst time of Processes
		for (int i = 0; i < n; i++) {
			System.out.println("Enter Arrival time");
			job[i][0] = sc.nextInt();
			System.out.println("Enter Burst time ");
			job[i][1] = sc.nextInt();
		}
		js.Sort(job, n);
		js.WaitingTime(job, n, waitingTime);
		js.TurnAroundTime(job, n, waitingTime, turnAroundTime);
		js.CompletionTime(job, n, turnAroundTime, completeTime);
		js.show(job, n, waitingTime, turnAroundTime, completeTime);
		sc.close();
	}

}
