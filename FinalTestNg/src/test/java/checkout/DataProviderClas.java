package checkout;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;


public class DataProviderClas {
	ArrayList<ArrayList<String>> dataObject;
	Object[][] obj;
	String[] dataItem;
	ArrayList<String> data;

	public ArrayList<ArrayList<String>> setUpdata() throws IOException {

		dataObject = new Util2().readXls();
		return dataObject;
	}

	@DataProvider(name = "dataForDoubleSum")
	public Object[][] dataProviderSum() throws IOException {
		dataObject = setUpdata();

		data = dataObject.get(0);

		getObject();
		return obj;
	}

	@DataProvider(name = "dataForDoubleMul")
	public Object[][] dataProviderMul() throws IOException {
		dataObject = setUpdata();

		data = dataObject.get(1);
		getObject();

		return obj;
	}

	@DataProvider(name = "dataForDoubleDiv")
	public Object[][] dataProviderDiv() throws IOException {

		dataObject = setUpdata();

		data = dataObject.get(2);
		getObject();

		return obj;
	}

	@DataProvider(name = "dataForDoubleSub")
	public Object[][] dataProviderSub() throws IOException {
		dataObject = setUpdata();

		data = dataObject.get(3);
		getObject();

		return obj;

	}

	@DataProvider(name = "dataForDoubleSqrt")
	public Object[][] dataProviderSqrt() throws IOException {
		dataObject = setUpdata();

		data = dataObject.get(4);
		getObject();

		return obj;
	}

	@DataProvider(name = "dataForDoublePow")
	public Object[][] dataProviderPow() throws IOException {
		dataObject = setUpdata();

		data = dataObject.get(5);
		getObject();

		return obj;
	
	}

	private void getObject()throws java.lang.AssertionError{
		obj = new Object[data.size()][data.get(0).split(",").length];
		for (int i = 0; i < data.size(); i++) {
			dataItem = data.get(i).split(",");
			for (int j = 0; j < dataItem.length; j++) {
				obj[i][j] = (dataItem[j]);
				System.out.print(obj[i][j]);
			}
			System.out.println();

		}
	}

}
