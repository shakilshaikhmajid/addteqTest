package com.addteq.test1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
	private static  void dbTest()
	{
		 
	        try
	        {
	        	Class.forName("org.postgresql.Driver");
	        	System.out.println("Driver Registred Success");
	        	//String url="postgres://zcxfobqy:sY06qww_01TI7aB2ORFNBOg4zw9r_SBF@stampy.db.elephantsql.com:5432/zcxfobqy";
	        	String url="jdbc:postgresql://stampy.db.elephantsql.com:5432/zcxfobqy";
	        	String user="zcxfobqy";
	        	String pwd="sY06qww_01TI7aB2ORFNBOg4zw9r_SBF";
	        			
	        	Connection cn=DriverManager.getConnection(url,user,pwd);
	        	System.out.println("Connection Success");
	        	
	        	Statement st=cn.createStatement();
	        	st.execute("delete from users");
	        	
	        	//st.execute("insert into users values('aaa','fff')");

	        	
	        	ResultSet rs=st.executeQuery("select * from users");
	        	ResultSetMetaData meta=rs.getMetaData();
	        	int totalcolumns=meta.getColumnCount();
	        	System.out.println("Total Columns="+totalcolumns);
	        	for(int i=1;i<=totalcolumns;i++)
	        	{
	        		System.out.print("\t"+meta.getColumnName(i));
	        	}
	        	System.out.println();
	        	while(rs.next())
	        	{
	        		for(int i=1;i<=totalcolumns;i++)
	            	{
	            		System.out.print("\t"+rs.getString(i));
	            	}
	        	}
	        	rs.close();
		        	st.close();
	        	cn.close();
	        	
	        	
	        }
	        catch(Exception ex)
	        {
	        	System.out.println("Error in connection:"+ex);
	        }
	}
	private static void fileTest()
	{
		try
		{
			
			String fileName = "resources/usernames.txt";
	        ClassLoader classLoader = new App().getClass().getClassLoader();
	 
	        File file = new File(classLoader.getResource(fileName).getFile());
	         
	        //File is found
	        System.out.println("File Found : " + file.exists());
	        
			
//			 String workingDir = System.getProperty("user.dir");
//			 System.out.println("Current working directory : " + workingDir);
			   
			DataInputStream din=new DataInputStream(new FileInputStream(file));
			String un=null;
			while((un=din.readLine())!=null)
			{
				System.out.println(un);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error in file operation:"+ex);
			
		}
	}
    public static void main( String[] args )
    {
    	//fileTest();
    	dbTest();
       
    }
}