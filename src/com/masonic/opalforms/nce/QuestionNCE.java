package com.masonic.opalforms.nce;

import com.siliconage.web.NameCodeExtractor;

import com.masonic.application.Question;

public final class QuestionNCE extends NameCodeExtractor<Question> {
	/* This is a singleton class:  Only one instance may exist at one time.  That requirement is enforced
	by the presence of a private constructor.  To access the instance, use the static getInstance() method.
	The single object is created with lazy instantiation.
	 */
	
	/* The single instance of this class. */
	private static final QuestionNCE ourInstance = new QuestionNCE();
	
	/* The public accessor for that single instance */
	public static QuestionNCE getInstance() {
		return ourInstance;
	}
	
	/* The private constructor that prevents anybody else from creating objects of this class. */
	private QuestionNCE() {
		super();
	}
	
	@Override
	public String extractCodeInternal(Question argQ) {
		return argQ == null ? "" : String.valueOf(argQ.getId());
	}
	
	@Override
	public String extractNameInternal(Question argQ) {
		return argQ == null ? "" : argQ.getLabel();
	}
}
