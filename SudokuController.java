package com.game;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;


public class SudokuController extends  GenericForwardComposer<Component>{
	
	
	@Wire
	public Button checkButton;
	@Wire
	public Button resetButton;
	@Wire 
	public Button startButton;
	
	
   private Intbox[][] cells = new Intbox[9][9];
   
   private int[][] soulution = {
		    {5, 3, 4, 6, 7, 8, 9, 1, 2},
		    {6, 7, 2, 1, 9, 5, 3, 4, 8},
		    {1, 9, 8, 3, 4, 2, 5, 6, 7},
		    {8, 5, 9, 7, 6, 1, 4, 2, 3},
		    {4, 2, 6, 8, 5, 3, 7, 9, 1},
		    {7, 1, 3, 9, 2, 4, 8, 5, 6},
		    {9, 6, 1, 5, 3, 7, 2, 8, 4},
		    {2, 8, 7, 4, 1, 9, 6, 3, 5},
		    {3, 4, 5, 2, 8, 6, 1, 7, 9}
		};



   private Intbox[][] intboxes = new Intbox[9][9];


   public void doAfterCompose(Component comp) throws Exception {
       super.doAfterCompose(comp);
       initializeCells();
   }

   private void initializeCells() {
       for (int i = 0; i < 9; i++) {
           for (int j = 0; j < 9; j++) {
               cells[i][j] = (Intbox) self.getFellow("cell" + i + j);
           }
       }
   }	
   
   @Listen("onClick=#resetButton")
	public void reset() {
		 for (Intbox[] row : cells) {
	            for (Intbox cell : row) {
	                cell.setValue(null);
	            }
	        }
	}
	
	
	 public void onCellChange(int row, int col) {
	        int value = cells[row][col].getValue();
	        Messagebox.show(""+value);
	        if (value < 1 || value > 9) {
	            alert("Invalid input. Please enter a number between 1 and 9.");
	            cells[row][col].setValue(value);
	        }
	 
	 }
	 @Listen("onClick=#startButton")
	 public void onLoadData() {
		 Messagebox.show("lets start the game");
		 for (int i = 0; i < 9; i++) {
	            for (int j = 0; j < 9; j++) {
	             cells[i][j].setValue(soulution[i][j]);
	            }
	        }
	 }

}
