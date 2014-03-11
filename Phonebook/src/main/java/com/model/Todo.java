package com.model;

import java.io.Serializable;



public class Todo implements Serializable{
	  /**
	 * 
	 */
	private static final long serialVersionUID = -678458163724688787L;
	private Long id;
	  private String summary;
	  private String description;

	  public Todo() {
	}

	public String getSummary() {
	    return summary;
	  }

	  public void setSummary(String summary) {
	    this.summary = summary;
	  }

	  public String getDescription() {
	    return description;
	  }

	  public void setDescription(String description) {
	    this.description = description;
	  }

	  public String toString() {
	    return "Todo [summary=" + summary + ", description=" + description
	        + "]";
	  }
}
