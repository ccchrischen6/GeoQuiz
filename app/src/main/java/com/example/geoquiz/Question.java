package com.example.geoquiz;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;



public class Question extends ToolKit{
    /** resource for the context input */
    private Resources res;

    /** the question array */
    private String[] questions;

    /** the answer array */
    private String[] answers;


    public Question(Context context, Activity activity) {
        super(context,activity);

        /** get the resource from context */
        res = context.getResources();
        questions = res.getStringArray(R.array.questions);
        answers = res.getStringArray(R.array.answers);
    }

    /** make sure the questionId is valid in the question array, if not, return false */
    private boolean isValidate(int questionId){
        if (questionId<0 || questionId>questions.length-1) return false;
        else return true;
    }

    /** return the question tagged with the questionId,
     * if failed to pass validation, return a empty string */
    public String getQuestion(int questionId) {
        if (!isValidate(questionId)) {
            Toast.makeText(context, R.string.error_toast, Toast.LENGTH_LONG).show();
            return "";
        }
        return questions[questionId];
    }

    /** return the answer tagged with the questionId,
     * if failed to pass validation, return true */
    public boolean getAnswer(int questionId) {
        if (!isValidate(questionId)) {
            Toast.makeText(context, R.string.error_toast, Toast.LENGTH_LONG).show();
            return true;
        }
        return Boolean.parseBoolean(answers[questionId]);
    }

    /** return the size of the question array */
    public int getSize(){
        return questions.length;
    }


}
