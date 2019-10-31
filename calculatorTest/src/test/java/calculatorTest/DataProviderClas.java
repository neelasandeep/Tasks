package calculatorTest;

import org.testng.annotations.DataProvider;

public class DataProviderClas {
	
	@DataProvider(name="dataForDoubleSum")
	public Object[][] dataProviderSum(){
		
		 Object[][] obj= {   {1.5,2.3,3.8},
				             {23.2,24.8,48}, 
				             {8.9,9.1,18},
				             {-5,4,-1},
				             {5.3,4.3,9.6},
				             {1.3,1.4,34},
				             {3.3,1.4,34},
				             {9.3,1.4,34},
				             {8.3,1.4,34},
				             {-11.3,1.4,34}};
		 return obj;
	 }
	@DataProvider(name="dataForDoubleMul")
	public Object[][] dataProviderMul(){
		
		 Object[][] obj= {   {1.5,2.3,3.0},
				             {23.2,24.8,575.0}, 
				             {8.9,9.1,80.0},
				             {-5,4,-20},
				             {5.3,4.3,22.0},
				             {1.3,1.4,34},
				             {3.3,1.4,34},
				             {9.3,1.4,34},
				             {8.3,1.4,34},
				             {-11.3,1.4,34}};
		 return obj;
	 }
	@DataProvider(name="dataForDoubleDiv")
	public Object[][] dataProviderDiv(){
		
		 Object[][] obj= {   {6,2,3},
				             {21,7,3}, 
				             {1,0.0,1d/0d},
				             {12.9,9.4,1.372340425531915},
				             {8,8,1},
				             {1.3,1.4,34},
				             {3.3,1.4,34},
				             {9.3,1.4,34},
				             {8.3,1.4,34},
				             {-11.3,1.4,34}};
		 return obj;
	 }
	@DataProvider(name="dataForDoubleSub")
	public Object[][] dataProviderSub(){
		
		 Object[][] obj= {   {6,2,4},
				             {21,7,14}, 
				             {1,0,1},
				             {12.9,9.4,3.5},
				             {8,8,0},
				             {1.3,1.4,34},
				             {3.3,1.4,34},
				             {9.3,1.4,34},
				             {8.3,1.4,34},
				             {-11.3,1.4,34}};
		 return obj;
	 }
	@DataProvider(name="dataForDoubleSqrt")
	public Object[][] dataProviderSqrt(){
		
		 Object[][] obj= {   {4,2},
				             {21,4.58257569495584}, 
				             {1,1},
				             {12.9,3.591656999213594},
				             {8,2.8284271247461903},
				             {1.3,34},
				             {3.3,34},
				             {9.3,34},
				             {8.3,34},
				             {-11.3,34}};
		 return obj;
	 }
	@DataProvider(name="dataForDoublePow")
	public Object[][] dataProviderPow(){
		
		 Object[][] obj= {   {4,2,16},
				             {21,4.5,194481.0}, 
				             {0,0,1.0},
				             {12.9,3.5,2146.6890000000003},
				             {-8,2.8,64.0},
				             {1.3,4,34},
				             {3.3,5,34},
				             {9.3,6,34},
				             {8.3,3,34},
				             {-11.3,2,34}};
		 return obj;
	 }
	@DataProvider(name="dataFortg")
	public Object[][] dataProvidertg(){
		
		 Object[][] obj= {   {0,0d/0d},
				             {-1,1}, 
				             {30,1.0},
				             {90,1.0},
				             {45,1.0},
				             {1.3,4},
				             {3.3,34},
				             {6,34},
				             {3,34},
				             {2,34}};
		 return obj;
	 }
//	@DataProvider(name="dataForLongSum")
//	public Object[][] dataProvidertLongSum(){
//		
//		 Object[][] obj= {    {1.5,2.3,3.8},
//	             {23.2,24.8,48}, 
//	             {8.9,9.1,18},
//	             {-5,4,-1},
//	             {5.3,4.3,9.6},
//	             {1.3,1.4,34},
//	             {3.3,1.4,34},
//	             {9.3,1.4,34},
//	             {8.3,1.4,34},
//	             {-11.3,1.4,34}};
//		 return obj;
//	 }
	
	
}
