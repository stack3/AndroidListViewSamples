package net.stack3.listviewsample.model;

import net.stack3.listviewsample.R;

public class CustomListItem2 implements BaseCustomListItem {
	private String leftText;
	private String rightText;
	
	public String getLeftText() {
		return leftText;
	}
	
	public void setLeftText(String leftText) {
		this.leftText = leftText;
	}
	
	public String getRightText() {
		return rightText;
	}
	
	public void setRightText(String rightText) {
		this.rightText = rightText;
	}
	
	@Override
	public int getViewType() {
		return 1;
	}
}
