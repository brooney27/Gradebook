
import java.util.Scanner;

public class GradeBook {
	public static void main(String[] args){
		String[] name = new String[100];
		char[] grade = new char[100];
		String[] gender = new String[100];
		String[] major = new String[100];
		String[] state = new String[100];
		int[] score = new int[100];
		
		int numMajor = 0;
		String[] majors = new String[100];
		int numState = 0;
		String[] states = new String[100];
		
		int counter = 0;
		
		boolean done = false;
		
		Scanner in = new Scanner(System.in);
		
		while(!done == true){
			System.out.println("0: Enter new student, 1: Number of students 2: Average Grade");
			System.out.println("3: Average by Gender, 4: Average by Major, 5: Average by State, 6: to exit");
			System.out.println("Enter a command:");
			int input = in.nextInt();
			
			if(input==6)done = true;
			else if(input==0){
				String inStr;
				System.out.println("Enter Name:");
				name[counter] = in.next();
				System.out.println("Enter Grade:");
				grade[counter] = in.next().toCharArray()[0];
				System.out.println("Enter Gender(m/f):");
				gender[counter] = in.next();
				System.out.println("Enter Major:");
				inStr = in.next();
				major[counter] = inStr;
				boolean newMajor = true;
				for(int i = 0; i <= numMajor; i++){
					if(inStr.equals(majors[i]))newMajor=false;
				}
				if(newMajor){
					System.out.println("adding new major " + inStr);
					majors[numMajor]=inStr;
					numMajor++;
				}
				System.out.println("Enter State:");
				inStr = in.next();
				state[counter] = inStr;
				boolean newState = true;
				for(int i = 0; i <= numState; i++){
					if(inStr.equals(states[i]))newState=false;
				}
				if(newState){
					System.out.println("adding new state " + inStr);
					states[numState]=inStr;
					numState++;
				}
				System.out.println("Enter Score:");
				score[counter] = in.nextInt();
				
				counter++;
			}
			else if(input==1){
				System.out.println("Number of Students: " + counter);
			}
			else if(input==2){
				double sum = 0;
				for(int i = 0; i < counter; i++){
					sum += score[i];
				}
				System.out.println("Overall Average: " + (sum/counter));
			}
			else if(input==3){
				int specavg = specificAvg(gender, "m", score, counter);
				System.out.println("Average for males: " + specavg);
				specavg = specificAvg(gender, "f", score, counter);
				System.out.println("Average for females: " + specavg);
			}
			else if(input==4){
				for(int i = 0; i < numMajor; i++){
					int specavg = specificAvg(major, majors[i], score, counter);
					System.out.println("Average for " + majors[i] + " majors: " + specavg);
				}
			}
			else if(input==5){
				for(int i = 0; i < numState; i++){
					int specavg = specificAvg(state, states[i], score, counter);
					System.out.println("Average for " + states[i] + " : " + specavg);
				}
			}
			
		}
		System.out.println("Report Date: June 14, 2013");
		System.out.println("Number of students: " + counter);
		
		int specavg = specificAvg(gender, "m", score, counter);
		System.out.println("Average for males: " + specavg);
		specavg = specificAvg(gender, "f", score, counter);
		System.out.println("Average for females: " + specavg);
		
		for(int i = 0; i < numMajor; i++){
			specavg = specificAvg(major, majors[i], score, counter);
			System.out.println("Average for " + majors[i] + " majors: " + specavg);
		}
		
		for(int i = 0; i < numState; i++){
			specavg = specificAvg(state, states[i], score, counter);
			System.out.println("Average for " + states[i] + " : " + specavg);
		}
		
	}
	
	public static int specificAvg(String[] array, String lookup, int[] values, int size){
		int numMatch = 0;
		int sum = 0;
		
		for(int i = 0; i < size; i++){
			if(array[i].equals(lookup)){
				numMatch++;
				sum += values[i];
			}
		}
		
		return (sum/numMatch);
	}
}
