import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Question2 {

	public static void main(String[] args) throws Exception
	{
		/* Calls the ExecutorService and creates a Thread Pool*/
		ExecutorService servicePool = Executors.newSingleThreadExecutor();
		
		/*Calls the ProcessBuilder, Process and InputStreamReader */
		ProcessBuilder processBuilder;
		Process process;
		InputStreamReader read;
		
		/*Creates a new ProcessBuilder which will ping the website 10 times */
		processBuilder = new ProcessBuilder();
		processBuilder.command("cmd.exe", "/c","ping -n 10 google.com");
		
		/* The process starts, read which will hold the process command in the InputStreamReader class as a parameter */
		process = processBuilder.start();
		read = new InputStreamReader(process.getInputStream());
		
		/* Creates a new task which will hold the the process() as a parameter */
		Task t = new Task(read);
		
		try
		{
			/* Creates a List of String variables, and calls the submit method on the Task class which will return a future object */
			Future<List<String>> future = servicePool.submit(t);
			/* Read the results from the Future object calling one of the Future.get() method and prints out the results */
			List<String> response = future.get();
		
			/* for each loop that iterates through the String object called response and prints out the future string variables */
			for(String ping:response) {
				System.out.println(future);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		/* closes the ThreadPool */
		servicePool.shutdown();
	}
}

class Task implements Callable {
	private InputStreamReader output;
	public Task(InputStreamReader output) {
		this.output = output;
	}   

	@Override
	public List<String>call() throws Exception {
		/*Creates the Future ArrayList of Strings */
		List<String> list = new ArrayList<String>();
		/*BufferedReader which will print out the output variable which is the parameter passed when 
		 * calling the TasK class and prints out the value with the InputStreamReader in main() */
		BufferedReader b = new BufferedReader(output);
		String response;
	
		/* Loop that iterates through the 10 ping and outputs the line in a string */
		while ((response = b.readLine()) != null) {
			System.out.println(response);
			//Future<String> future = null;
			//list.add(future);
		}	
		
		/* returns the ArrayL.ist of Strings */
		return list;
	}
}
