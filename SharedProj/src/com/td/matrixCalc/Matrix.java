package com.td.matrixCalc;

import java.util.ArrayList;
import java.util.Arrays;

public class Matrix {
	
	public ArrayList < ArrayList < Double >> mat = new ArrayList < ArrayList < Double >> ();
	
	private Matrix resultMatrix;
	private double tempAdd;
	
	@SuppressWarnings("unchecked")
	public Matrix ( ArrayList < ArrayList < Double >> mat) {
		this.mat = (ArrayList < ArrayList < Double >>) mat.clone();
	}
	
	
	public Matrix ( int row, int col , double ... elements) {
		
		for (int i=0; i<row; i++) {
			this.mat.add(new ArrayList <Double> ());
			
			for (int j=0; j<col ; j++) {
				this.mat.get(i).add(elements[i*col + j]);
			}
		}
	}
	
	public Matrix ( double [][] array) {
		
		for (int i=0 ; i<array.length ; i++ ) {
			this.mat.add(new ArrayList <Double> ());
			
			for ( int j=0 ; j< array[0].length ; j++ ) {
				this.mat.get(i).add(array[i][j]);
			}
		}
	}
	
	
	// Methods
	
	public int getRows () {
		return this.mat.size();
	}
	
	public int getCols () {
		return this.mat.get(0).size();
	}
	
	public Matrix add ( Matrix m) {
		
		resultMatrix.mat.clear();
		
		for ( int i =0; i<m.getRows() ;i++) {
			resultMatrix.mat.add(new ArrayList <Double> ());
			
			for ( int j=0; j<m.getCols() ; j++) {
				resultMatrix.mat.get(i).add( this.mat.get(i).get(j) + m.mat.get(i).get(j));
			}
		}
		
		return resultMatrix;
	}
	
	public Matrix substract ( Matrix m) {
		
		resultMatrix.mat.clear();
		
		for ( int i =0; i<m.getRows() ;i++) {
			resultMatrix.mat.add(new ArrayList <Double> ());
			
			for ( int j=0; j<m.getCols() ; j++) {
				resultMatrix.mat.get(i).add( this.mat.get(i).get(j) - m.mat.get(i).get(j));
			}
		}
		
		return resultMatrix;
	}
	
	
	public Matrix multiplyBy (double digit) {
		
		resultMatrix.mat.clear();
		
		for ( int i =0; i<this.getRows() ;i++) {
			resultMatrix.mat.add(new ArrayList <Double> ());
			
			for ( int j=0; j<this.getCols() ; j++) {
				resultMatrix.mat.get(i).add( this.mat.get(i).get(j) * digit);
			}
		}
		
	/*	for (ArrayList < Double > row : this.mat) {
			resultMatrix.mat.add(new ArrayList <Double> ());
			
			for (double element : row) {
				
			}
		}*/
		
		return resultMatrix;
	}
	
	
	public Matrix divideBy (double digit) {
		
		resultMatrix.mat.clear();
		
		for ( int i =0; i<this.getRows() ;i++) {
			resultMatrix.mat.add(new ArrayList <Double> ());
			
			for ( int j=0; j<this.getCols() ; j++) {
				resultMatrix.mat.get(i).add( this.mat.get(i).get(j) / digit);
			}
		}
		
		return resultMatrix;
	}
	
	
	
	
	public Matrix multiplyBy ( Matrix m) {
		
		resultMatrix.mat.clear();
		
		for ( int i =0; i<this.getRows() ;i++) {
			resultMatrix.mat.add(new ArrayList <Double> ());
			
			for ( int j=0; j<m.getCols() ; j++) {
				
				double resultElement=0;
				for ( int k=0; k<this.getCols() ; k++) {
					resultElement = resultElement + this.mat.get(i).get(k) * m.mat.get(k).get(j);
				}
				resultMatrix.mat.get(j).add(resultElement);
			
			}
		}
		
		return resultMatrix;
		
	}
	
	
	public Matrix getTransposeMatrix () {
		
		resultMatrix.mat.clear();
		
		for ( int i =0; i<this.getRows() ;i++) {
			resultMatrix.mat.add(new ArrayList <Double> ());
			
			for ( int j=0; j<this.getCols() ; j++) {
				resultMatrix.mat.get(i).add( this.mat.get(j).get(i) );
			}
		}
		
		return resultMatrix;
		
	}
	
	
	
	
	
	// extra
	
	public Matrix removeRow ( int rowIndex ) {
		//resultMatrix.mat.clear();
		
		resultMatrix = new Matrix ( this.mat);
		
		resultMatrix.mat.remove(rowIndex);
		return resultMatrix;
		
	}
	
	public Matrix removeCol ( int colIndex) {
		//resultMatrix.mat.clear();
		
		resultMatrix = new Matrix ( this.mat);
		
		for ( int i=0; i< this.getRows(); i++) {
			resultMatrix.mat.get(i).remove(colIndex);
		}
		
		return resultMatrix;
		
	}
	
	
	
	public Matrix replaceRow (int rowIndex, ArrayList <Double> row) {
		
		resultMatrix = new Matrix ( this.mat);
		resultMatrix.mat.set(rowIndex, row);
		return resultMatrix;
		
	}
	
	//public Matrix replaceRow (int rowIndex, double[] row) {
		
	//	return this.replaceRow(rowIndex, new ArrayList <Double> (Arrays.asList(row)) );
		
	//}
	
	public Matrix replaceCol ( int colIndex, ArrayList <Double> col) {
		
		resultMatrix = new Matrix ( this.mat);
		
		for ( int i=0; i< this.getRows(); i++) {
			resultMatrix.mat.get(i).set(colIndex, col.get(i));
		}
		
		return resultMatrix;
	}
	
	public Matrix replaceCol ( int colIndex, double[] col) {
		
		resultMatrix = new Matrix ( this.mat);
		
		for ( int i=0; i< this.getRows(); i++) {
			resultMatrix.mat.get(i).set(colIndex, col[i]);
		}
		
		return resultMatrix;
	}
	
	
	
	
	// advance-1^ ij   j+i
	
	public double getDeterminantValue () {
		
		if (this.getCols() == 2) {
			return (this.mat.get(0).get(0)*this.mat.get(1).get(1) - this.mat.get(0).get(1)*this.mat.get(1).get(0) );
		}
		
		tempAdd = 0;
		for ( int j=0 ; j < this.getCols() ; j++) {
			tempAdd = tempAdd + Math.pow(-1, j) * this.mat.get(0).get(j) * this.removeRow(0).removeCol(j).getDeterminantValue();
		}
		
		return tempAdd;
	}
	
	
	
	public Matrix calcCofactorMatrix () {
		
		resultMatrix.mat.clear();
		
		for ( int i =0; i<this.getRows() ;i++) {
			resultMatrix.mat.add(new ArrayList <Double> ());
			
			for ( int j=0; j<this.getCols() ; j++) {
				resultMatrix.mat.get(i).add( Math.pow(-1, i+j) * this.removeRow(i).removeCol(j).getDeterminantValue() );
			}
		}
		
		return resultMatrix;
		
	}
	
	public Matrix calcInverseMatrix () {
		
		if ( this.getRows() == 2) {
			resultMatrix = new Matrix (2, 2, this.mat.get(1).get(1) , (-1)*this.mat.get(0).get(1), (-1)*this.mat.get(1).get(0),  this.mat.get(0).get(0));
			return resultMatrix.divideBy(this.getDeterminantValue());
		}
		
		
		resultMatrix = this.calcCofactorMatrix().getTransposeMatrix();
		return resultMatrix.divideBy(this.getDeterminantValue());
		
	}
	
	
	

}
