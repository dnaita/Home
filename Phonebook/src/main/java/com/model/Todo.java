package com.model;



public class Todo {
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
