package com.game;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;

import org.zkoss.zul.Window;

import net.sf.jasperreports.engine.export.Grid;

public class TictocMain extends SelectorComposer<Window>{
	
	@Wire 
	public Grid grid;
	 private Button[][] buttons = new Button[3][3];
	    private int currentPlayer = 1; // 1 for Player 1, 2 for Player 2
	    private boolean gameEnded = false;

	    public void onClick$grid(Event event) {
	        if (gameEnded) {
	            return;
	        }

	        Component target = event.getTarget();
	        if (target instanceof Button) {
	            Button button = (Button) target;
	            int row =0;
	            int col=0;
	         

	            if (buttons[row][col] == null) {
	                buttons[row][col] = button;
	                button.setLabel(currentPlayer == 1 ? "X" : "O");
	                checkWinner(row, col);
	                currentPlayer = 3 - currentPlayer; // Switch player
	            }
	        }
	    }

	    private void checkWinner(int row, int col) {
	        if (checkRow(row) || checkColumn(col) || checkDiagonal(row, col)) {
	            Clients.showNotification("Player " + currentPlayer + " wins!");
	            gameEnded = true;
	        } else if (isBoardFull()) {
	            Clients.showNotification("It's a draw!");
	            gameEnded = true;
	        }
	    }

	    private boolean checkRow(int row) {
	        return buttons[row][0] != null && buttons[row][0].getLabel().equals(buttons[row][1].getLabel())
	                && buttons[row][0].getLabel().equals(buttons[row][2].getLabel());
	    }

	    private boolean checkColumn(int col) {
	        return buttons[0][col] != null && buttons[0][col].getLabel().equals(buttons[1][col].getLabel())
	                && buttons[0][col].getLabel().equals(buttons[2][col].getLabel());
	    }

	    private boolean checkDiagonal(int row, int col) {
	        if (row == col || row + col == 2) {
	            return (buttons[0][0] != null && buttons[0][0].getLabel().equals(buttons[1][1].getLabel())
	                    && buttons[0][0].getLabel().equals(buttons[2][2].getLabel()))
	                    || (buttons[0][2] != null && buttons[0][2].getLabel().equals(buttons[1][1].getLabel())
	                            && buttons[0][2].getLabel().equals(buttons[2][0].getLabel()));
	        }
	        return false;
	    }





	    private boolean isBoardFull() {
	        for (Button[] row : buttons) {
	            for (Button button : row) {
	                if (button == null) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
}
