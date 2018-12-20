package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path of the file:");
		String path = sc.nextLine();
		List<String> list = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while(line != null) {
				list.add(line);
				line = br.readLine();
			}
			
			Collections.sort(list);
			for(String name : list) {
				System.out.println(name);
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
