package simplilearnFinalProject;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LockedMe 
{
	static final String projectFilesPath ="C:\\Users\\Asus\\JavaFS";
	
	/**
	 * This method will display the menu for end users
	 */
	public static void displaymenu()
	{
		System.out.println("\t************************************");
		System.out.println("\tWelcome to LockedMe.com Secure App");
		System.out.println("\tDeveloped by : Tirtharaj Das");
		System.out.println("\t************************************");
		System.out.println("\t\t1. Display all fles");
		System.out.println("\t\t2. Add a new file");
		System.out.println("\t\t3. Delete a file");
		System.out.println("\t\t4. Search file");
		System.out.println("\t\t5. Exit");
		System.out.println("************************************");
	}
	
	/**
	 * This method will retrieve all files
	 */
	public static void getAllFiles() 
	{
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		
		if(listOfFiles.length>0)	
		{ 
			System.out.println("FILES LIST IS BELOW:\n");
		
		for(var l: listOfFiles)
		{
			System.out.println(l.getName());
		}
	}
		else
		{
			System.out.println("This Folder is Empty");
		}
	}
	
	/**
	 * This method will read file details from user and create files
	 */
	public static void createFiles()
{
	try
	{
		//Variable declaration
		Scanner obj = new Scanner(System.in);
		String fileName;
		
		//Read file name from user
		System.out.println("Enter the File Name");
		fileName = obj.nextLine();
		
		int linesCount;
		System.out.println("Enter how many lines in the file");
		linesCount = Integer.parseInt(obj.nextLine());
	
		FileWriter fw = new FileWriter(projectFilesPath +"\\"+ fileName +".txt");
		
		//Read line by line from user
		for( int i=1;i<=linesCount;i++)
		{
			System.out.println("Enter file line:");
			fw.write(obj.nextLine()+"\n");
		}
			System.out.println("File Created Successfully");
			fw.close();
			
		}
		catch(Exception Ex)
		{
			System.out.println("Unable to delete file. Please contact : tirtha123@test.com");
		}
	}
	
	/**
	 * This method will take file name as parameters and checks is
	 * it is present in the project folder or not
	 * @param fileName String
	 * @return boolean
	 */
	public static boolean checkFileExist(String fileName)
	{
		//Get all files names into a list
		
				ArrayList<String> allFilesNames = new ArrayList<String>();
				File folder = new File(projectFilesPath);
				File[] listOfFiles = folder.listFiles();
				
				if(listOfFiles.length>0)
					
				{ 
					System.out.println("FILES LIST IS BELOW:\n");
				
					for(var l: listOfFiles)
				{
					allFilesNames.add(l.getName());
				}
			}
				return allFilesNames.contains(fileName);
				
	}
	public static void deleteFiles()
	{
		try
		{
			//variable declaration
			Scanner obj = new Scanner(System.in);
			String fileName;
			
			//Read file name from user
		System.out.println("Enter File Name to be Deleted:");
		fileName = obj.nextLine();
		File f = new File(projectFilesPath+"\\"+fileName);
		
		if(checkFileExist(fileName))
		{
			f.delete();
			System.out.println("File Deleted Successfully");
		
		}
		else
			{
			System.out.println("File Doesn't Exist");
			}
	}
		catch(Exception Ex)
		{
			System.out.println("Unable to delete the file. please contact :tirtha123@test.com");
			
		}
	}
	public static void SearchFiles()
	{
		try
		{
			//Variable declaration
		Scanner obj = new Scanner(System.in);
		String fileName;
		
		//Read file name from user
		System.out.println("Enter the File Name to be searched");
		fileName = obj.nextLine();
		
		if(checkFileExist(fileName))
		{
				System.out.println("File is available");
		}
		else
				{
				System.out.println("File is not available");
				}
		
		}
		catch(Exception Ex)
		{
			
		}
		
		
		
	}
}