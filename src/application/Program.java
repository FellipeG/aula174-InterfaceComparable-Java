package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path of the file:");
		String path = sc.nextLine();
		List<Employee> list = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while(line != null) {
				String[] vect = line.split(",");
				list.add(new Employee(vect[0], Double.parseDouble(vect[1])));
				line = br.readLine();
			}
			
			Collections.sort(list);
			for(Employee name : list) {
				System.out.println(name.getName() + " - $" + String.format("%.2f", name.getSalary()));
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File don't exist: " + e.getMessage());
		}
		catch(IOException e) {
			System.out.println("I/O error: " + e.getMessage());
		}
		finally {
			sc.close();
		}

	}

}
