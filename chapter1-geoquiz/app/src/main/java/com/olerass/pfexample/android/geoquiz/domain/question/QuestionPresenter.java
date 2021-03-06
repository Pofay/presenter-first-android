package com.olerass.pfexample.android.geoquiz.domain.question;

public class QuestionPresenter {
    private QuestionView view;
    private QuestionModel model;

    public QuestionPresenter(QuestionView view, QuestionModel model) {
        this.view = view;
        this.model = model;
        initialize();
    }

    private void initialize() {
        view.setQuestionText(model.getQuestionText());

        view.whenAnswerGiven(answer -> {
            if (model.isCorrectAnswer(answer)) {
                view.showCorrectAnswerMessage();
            } else {
                view.showIncorrectAnswerMessage();
            }
        });
    }
}
