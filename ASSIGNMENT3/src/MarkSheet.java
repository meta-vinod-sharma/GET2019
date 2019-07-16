import java.util.Scanner;
/**
 * 
 * class Marksheet contains methods which calculate average of grades,maximum of grades,minimum of grades
 * percentage pass students in given n numbers of students
 *
 */
public class MarkSheet {
	
	/**
	 * @param grades  is an array which contains grades of students 
	 * @param n  numbers of students
	 * @return  Return Average of grades of students
	 */
	public float average(float grades[] , int n){
		float average = 0 , sumOfGrades = 0;
		for(int i = 0 ;i < n; i++){
			sumOfGrades += grades[i];
		}
		average = sumOfGrades / n ;
		return average;
	}
	
	
	/**
	 * @param grades is an array which contains grades of students 
	 * @param n   numbers of students
	 * @return    Returns Maximum Grade in all grades of students  
	 */
	public float maxGrade(float grades[] , int n){
		float maxGrade = grades[0];
		for(int i = 1; i < n; i++){
			if(grades[i] > maxGrade){
				maxGrade = grades[i];
			}
		}
		return maxGrade;
		
	}
	
	
	/**
	 * @param grades is an array which contains grades of students 
	 * @param n    numbers of students
	 * @return    Returns Minimum Grade in all grades of students 
	 */
	public float minGrade(float grades[] , int n){
		float minGrade = grades[0];
		for(int i = 1; i < n; i++){
			if(grades[i] < minGrade){
				minGrade = grades[i];
			}
		}
		return minGrade;
	}
	
	
	/**
	 * @param grades is an array which contains grades of students 
	 * @param n   numbers of students
	 * @return     Returns pass Students in Percentage 
	 */
	public float passStudentsPercentage(float grades[], int n){
		int passStudents = 0;
		float percentagePassStudent;
		for(int i = 0; i < n; i++ ){
			if(grades[i] >= 40){
				passStudents += 1;
			}
		}
		percentagePassStudent = (passStudents / (float)n) * 100;
		return percentagePassStudent;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarkSheet markSheetObj = new MarkSheet();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no of students");
		int n = scan.nextInt();
		float grades[] = new float[n];
		float grade;
		System.out.println("Enter grades for "+n+" students");
		for(int i = 0; i < n; i++){
			System.out.println("Enter grade of student "+(i+1));
			grade = scan.nextFloat();
			if(grade >= 0 && grade <= 100){
				grades[i] = grade;
			}
			else{
				System.out.println("Enter grade for student "+(i+1)+" in range(0 - 100)");
				i--;
			}
		}
		System.out.printf("Average of all grades = %.2f\n",markSheetObj.average(grades, n));
		System.out.printf("maximum of all grades = %.2f\n",markSheetObj.maxGrade(grades, n));
		System.out.printf("minimum of all grades = %.2f\n",markSheetObj.minGrade(grades, n));
		System.out.printf("percentage of students passed = %.2f\n",markSheetObj.passStudentsPercentage(grades, n));
		
		scan.close();
		}

}
