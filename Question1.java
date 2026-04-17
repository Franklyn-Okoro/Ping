
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1 {

	public static void main(String[] args) throws Exception {
		/*	Calling the ProcessBuilder */
			ProcessBuilder processBuilder = new ProcessBuilder();
			
		/*	Calls and initializes the Process Class and its methods */
			Process process = null;
			
		/* 	Calling the command that will ping the web site 10 times */
			processBuilder.command("cmd.exe", "/c","ping -n 10 google.com");
			
		/*	Starts a new process using the attributes of this process builder */
			process = processBuilder.start();
			
		/*	InputStreamReader which will hold the process command and declare it */	
			InputStreamReader read = new InputStreamReader(process.getInputStream());
			
		/*  Reads the InputStreamReader command */
			BufferedReader b = new BufferedReader(read);
			
		/*  Calling a string which will hold the output of the Buffered Reader*/
			String response;
			try {
				/*Loop that iterates through the 10 pings and outputs the line in a string */
				while ((response = b.readLine()) != null) {
		/* 			Reads the Buffered Reader and outputs the response */
					System.out.println(response);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
}
