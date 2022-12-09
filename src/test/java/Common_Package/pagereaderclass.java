package Common_Package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class pagereaderclass {








	@Test
	public static String [] text_read_test(String elementname) {

		String path=".\\text\\read.txt";


		String match="";


		try {
			FileReader read=new FileReader(path);
			BufferedReader file=new BufferedReader(read);		
			String line=file.readLine();


			while(line !=null) {
				if(line.split(":",3)[0].equalsIgnoreCase(elementname)) {
					match=line;
					break;
				}
				line=file.readLine();
			}

			
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(match.equals("")) {
			try {
				File f=new File(path);
				if(!f.exists()) {
					System.out.println("txt file not found");
				}else {
					FileReader read=new FileReader(path);
					BufferedReader file=new BufferedReader(read);		
					String line=file.readLine();


					while(line !=null) {
						if(line.split(":",3)[0].equalsIgnoreCase(elementname)) {
							match=line;
							break;
						}
						line=file.readLine();
					}
				}
				Assert.assertTrue(!match.equals(""), 
						"locater name "+elementname+" is not presnt in txt file");
			}catch(IOException e ) {
				e.printStackTrace();
			}

			

		}
		return match.split(":",3);





	}



}
