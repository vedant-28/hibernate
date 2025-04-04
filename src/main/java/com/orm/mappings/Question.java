package com.orm.mappings;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Question {
	
	@Id
	@Column(name = "question_id")
	private int q_id;
	private String question;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Answer a_id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Answer> answers;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int q_id, String question, Answer a_id, List<Answer> answers) {
		super();
		this.q_id = q_id;
		this.question = question;
		this.a_id = a_id;
		this.answers = answers;
	}

	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer getA_id() {
		return a_id;
	}

	public void setA_id(Answer a_id) {
		this.a_id = a_id;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [q_id=" + q_id + ", question=" + question + ", a_id=" + a_id + ", answers=" + answers + "]";
	}
}
