package com.game;

import java.sql.SQLException;
import java.util.ArrayList;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class GuessMain  extends SelectorComposer<Window>{
	
	@Wire 
	public Label label1;
	@Wire 
	public Textbox textbox2;
	@Wire
	public Button start;
	@Wire
	public Button check;
	@Wire
	public Button reset;
	@Wire 
	public Button logoutButton;
	ArrayList<String> list=new ArrayList<>();
	public void insertword() {
	
	list.add("der");
	list.add("dloc");
	list.add("nedrag");
	list.add("tnahpele");
	list.add("noil");
	list.add("ajav");
	list.add("TLMH");
	}
	@Listen("onClick=#start")
	public void startGame() {
		//ArrayList<String> list=new ArrayList<>(); 
		insertword();
		label1.setValue(list.get(1));
		
	}
	@Listen("onClick=#check")
		public void checkWord(){
		String userWord=textbox2.getValue();
		DataConnect ob=new DataConnect();
		try {
			boolean isCheck=(ob.checkWord(userWord)); 
			if(isCheck) {
				Messagebox.show("coreect");
				restWord();
			}else {
				Messagebox.show("try again!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	int index=2;
	//@Listen("onClick=#reset")
	public void restWord()
	{
		int length=list.size();
	if(index<length) {
		label1.setValue(list.get(index));
		textbox2.setValue("");
		++index;
	}else{
		Messagebox.show("Thank you come again");
	}
	}
	
	
	@Wire
	public Button btn1;
	@Wire
	public Button btn2;
	@Wire
	public Button btn3;
	@Wire
	public Button btn4;
	@Wire
	public Button btn5;
	@Wire
	public Button btn6;
	@Wire
	public Button btn7;
	@Wire
	public Button btn8;
	@Wire
	public Button btn9;
	@Wire
	public Button btn10;

	String b1="1";
	String b2="2";

	String b3="3";

	String b4="4";

	String b5="5";

	String b6="7";

	String b7="8";

	String b8="9";
	String b9="10";

	
	
	int flag=0;
	boolean isWin=false;
	@Listen("onClick=#btn1")
	public void start1()
	{
	
		if(flag==0) {
	btn1.setLabel("X");
		flag=1;
		}else
		{
			btn1.setLabel("O");
			flag=0;
		}
	     b1=btn1.getLabel();
		isWin=checkWinner();
		if(isWin) {
			isDisable();
		}
		btn1.setDisabled(true);
	}
	@Listen("onClick=#btn2")
	public void start2()
	{ 
		
		if(flag==1) {
			btn2.setLabel("O");
			flag=0;
	

		}else {
			btn2.setLabel("X");
			flag=1;
		}
		  b2=btn2.getLabel();
		  isWin=checkWinner();
			if(isWin) {
				isDisable();
			}
		btn2.setDisabled(true);
	}
	@Listen("onClick=#btn3")
	public void start3()
	{
		
		if(flag==1) {
			btn3.setLabel("O");
			flag=0;
		}else {
			btn3.setLabel("X");
			flag=1;
		}
		 b3=btn3.getLabel();
		 isWin=checkWinner();
			if(isWin) {
				isDisable();
			}
		btn3.setDisabled(true);
	
	}
	@Listen("onClick=#btn4")
	public void start4()
	{
		if(flag==1) {
			btn4.setLabel("O");
			
			flag=0;
		}else {
			btn4.setLabel("X");
			flag=1;
		}
		 b4=btn4.getLabel();
		 isWin=checkWinner();
			if(isWin) {
				isDisable();
			}
		btn4.setDisabled(true);
	}
	@Listen("onClick=#btn5")
	public void start5()
	{
		if(flag==1) {
			flag=0;
			btn5.setLabel("O");
		}else {
			btn5.setLabel("X");
			
			flag=1;
		}
		 b5=btn5.getLabel();
		 isWin=checkWinner();
			if(isWin) {
				isDisable();
			}
		btn5.setDisabled(true);
	}
	@Listen("onClick=#btn6")
	public void start6()
	{
		if(flag==1) {
			btn6.setLabel("O");
			flag=0;

		}else {
			btn6.setLabel("X");
			flag=1;
		}
		 b6=btn6.getLabel();
		 isWin=checkWinner();
			if(isWin) {
				isDisable();
			}
		btn6.setDisabled(true);
	}
	@Listen("onClick=#btn7")
	public void start7()
	{
		if(flag==1) {
			flag=0;
			btn7.setLabel("O");
		}else {
			btn7.setLabel("X");
			flag=1;
		
		}
		 b7=btn7.getLabel();
		 isWin=checkWinner();
			if(isWin) {
				isDisable();
			}
		btn7.setDisabled(true);
	}
	@Listen("onClick=#btn8")
	public void start8()
	{
		if(flag==1) {
			btn8.setLabel("O");
			flag=0;
			
		}else {
			btn8.setLabel("X");
			flag=1;
		}
		 b8=btn8.getLabel();
		 isWin=checkWinner();
			if(isWin) {
				isDisable();
			}
		btn8.setDisabled(true);
	}
	@Listen("onClick=#btn9")
	public void start9()
	{
		if(flag==1) {
			flag=0;
			btn9.setLabel("O");
		}else {
			btn9.setLabel("X");
			flag=1;
		
		}
		 b9=btn9.getLabel();
		 isWin=checkWinner();
			if(isWin) {
				isDisable();
			}
		btn9.setDisabled(true);
	}
	public void isDisable() {
		//Messagebox.show("reset");
	
		btn1.setDisabled(true);

		btn2.setDisabled(true);
	
		btn3.setDisabled(true);

		btn4.setDisabled(true);

		btn5.setDisabled(true);

		btn6.setDisabled(true);

		btn7.setDisabled(true);

		btn8.setDisabled(true);

		btn9.setDisabled(true);
	}

	@Listen("onClick=#btn10")
	
	 public void resetbtn()
	 {
		
		//Messagebox.show("reset");
		/*for(int i =1;i<=9;i++) {
			
		
		}*/
		btn1.setLabel(" ");
		btn1.setDisabled(false);
		btn2.setLabel(" ");
		btn2.setDisabled(false);
		btn3.setLabel("");
		btn3.setDisabled(false);
		btn4.setLabel(" ");
		btn4.setDisabled(false);
		btn5.setLabel(" ");
		btn5.setDisabled(false);
		btn6.setLabel(" ");
		btn6.setDisabled(false);
		btn7.setLabel(" ");
		btn7.setDisabled(false);
		btn8.setLabel(" ");
		btn8.setDisabled(false);
		btn9.setLabel(" ");
		btn9.setDisabled(false);
	 }

	

	 private boolean checkWinner() {
	     boolean istrue=false;
		// Messagebox.show("cliked");
	     
		  if ((b1.equals(b2) && (b1.equals(b3)))) 
		  {   
			 
			  istrue=true;
			     Messagebox.show("player  is won");
			   } 
			    else if (((b1.equals(b4)) && (b1.equals(b7))))
			    { 
			    	istrue=true;
			    	 Messagebox.show("player "+btn1.getLabel()+" is won");
			      
			    } 
			    else if (((b7.equals(b8)) && (b7.equals(b9)))) { 
			    	istrue=true;
			    	 Messagebox.show("player "+btn7.getLabel()+" is won");

			    } 
			    else if (((b3.equals(b6)) && (b3.equals(b9)))) { 
			    	istrue=true;
			    	 Messagebox.show("player "+btn3.getLabel()+" is won");
			       
			    } 
			    else if (((b1.equals(b5)) && (b1.equals(b9)))) { 
			    	istrue=true;
			    	 Messagebox.show("player "+btn1.getLabel()+" is won");
			
			    } 
			    else if (((b3.equals(b5)) && (b3.equals(b7)))) { 
			    	istrue=true;
			    	 Messagebox.show("player "+btn3.getLabel()+" is won");
			    } 
			    else if (((b2.equals(b5)) && (b2.equals(b8)))) { 
			    	istrue=true;
			    	 Messagebox.show("player "+btn3.getLabel()+" is won");
			    } 
			    else if (((b4.equals(b5)) && (b4.equals(b6)))) { 
			    	istrue=true;
			    	 Messagebox.show("player "+btn4.getLabel()+" is won");
			    } 
		  return istrue;
	 }
	
}

	/*    private boolean checkRow() {
	    	getValue();
	    	return true;
	       }

	    private boolean checkColumn() {
	       	getValue();
	       	
	        return true;
	        }

	    private boolean checkDiagonal() {
	       	getValue();
	        
	        return false;
	    }
	    */

