package DbHandle;

import one.NewClass;

public class TestExcelHandle {
	public static void main(String[] args) {
		
		ExcelHandle excel = new ExcelHandle ("D:\\Java\\Workspace\\One\\one.xlsx" , "Sheet2");
		System.out.println(excel.getRows());
		System.out.println(excel.getCols());
		System.out.println(excel.getRowValues("18403.0"));
		
		
		NewClass.path="D:\\Java\\Workspace\\One\\one.xlsx";
		int r=NewClass.getSheet("Sheet1").getRows(); // As per my opinion these values should be fixed.
		int c=NewClass.getSheet("Sheet1").getCols();
		
		System.out.println(r + "   " + c);
	}
}
