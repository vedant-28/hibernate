package com.orm.mappings;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Answer {
	
	@Id
	@Column(name = "answer_id")
	private int a_id;
	private String answer;
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(int a_id, String answer) {
		super();
		this.a_id = a_id;
		this.answer = answer;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer [a_id=" + a_id + ", answer=" + answer + "]";
	}	
}
