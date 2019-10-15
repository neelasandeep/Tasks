
public class JunitTask {

	

	public String checkForA(String str) {

		if ( (str.length() < 2 && str.contains("A"))||(str.length() >= 2 && str.substring(0, 2).contains("A"))) {
			str = str.replace("A", "");
		}
		return str;
	}

}
