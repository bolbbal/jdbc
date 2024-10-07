package javaStudy;

import java.io.File;
import java.util.UUID;

public class Uuid {
	
	public static void main(String args[]) {
		
		String aPath = "C:\\Users\\jjhh1\\OneDrive\\Documents\\GitHub\\jdbc\\javastudy18\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\hanulso\\upload";
		String upFile = "angrySin.png";
		
		String FileName = upFile.substring(0, upFile.lastIndexOf("."));
		String FileExtension = upFile.substring(upFile.lastIndexOf("."));
		System.out.println(FileName);
		
		String uuid = UUID.randomUUID().toString();
		System.out.println(FileName+uuid);
		
		String newFileName = FileName+"_"+uuid+FileExtension;
		System.out.println(newFileName);
		
		File file = new File(aPath+File.separator+newFileName);
	}
}
