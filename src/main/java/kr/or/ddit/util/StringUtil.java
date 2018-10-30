package kr.or.ddit.util;

public class StringUtil {
	public static String getFileNameFormHeader(String contentDisposition){
		
		String fileName ="";
		String[] strArray = contentDisposition.split("; ");
		
		for(String str : strArray){
			if(str.indexOf("filename") >= 0){
				fileName = str.substring(10, str.lastIndexOf("\""));
			}
		}
		return fileName;
	}

	public static String getCookie(String cookieString, String string) {
		// TODO Auto-generated method stub
		//startWith Stirng 메서드 알아봐
		String[] cookieArray = cookieString.split("; ");
		String cookieValue = "";
		for(String str : cookieArray){
			// 생각해보니깐 contains를 사용하게 되면 저 문자를 포함한 다른 애들도 포함이 되서 올것같아
			if(str.contains(string+"=")){
				String[] array = str.split("=");
				cookieValue = array[1];
			}
		}
		return cookieValue;
	}
	
//	public static String getCookie(String cookieString, String string){
//		String[] cookies
//		return null;
//	}
	
}
