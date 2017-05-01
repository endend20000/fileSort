package filesort;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public class Main {
	
	
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String path = System.getProperty("java.class.path");
		int firstIndex = path.lastIndexOf(System.getProperty("path.separator")) + 1;
		int lastIndex = path.lastIndexOf(File.separator) + 1;
		String filepath = path.substring(firstIndex, lastIndex);
		path = java.net.URLDecoder.decode(path, "UTF-8");
		
		Pattern pattern = Pattern.compile("[0-9]*");
		
		File dir=new File(filepath);
		String[] filelist = dir.list();
		 for (int i = 0; i < filelist.length; i++) {
			 String filename=filelist[i];
			 
			 String chFileName="";
			 
			 
			 for(int j=0;j< filename.length();j++){
				 String suffix=filename.substring(j, j+1);
				 if(suffix.equals(" ")||pattern.matcher(suffix).matches()||suffix.equals(".")){
					  
				 }else{
					 chFileName=(i+1)+" "+filename.substring(j);
					 break;
				 }
			 }
			 
			 File readfile = new File(filepath + "\\" + filelist[i]);
			 File writeFile=new File(filepath + "\\" +chFileName);
			 readfile.renameTo(writeFile);
			 
		}

	}

}
