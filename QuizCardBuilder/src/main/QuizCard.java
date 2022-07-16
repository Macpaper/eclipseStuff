package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class QuizCard {

	private String question;
	private String answer;
	
	public QuizCard(String q, String a) {
		this.question = q;
		this.answer = a;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getAnswer() {
		return answer;
	}
	
}
