package com.example.geoquiz;

import android.app.Activity;
import android.content.Context;
import android.view.View;

public class ToolKit {
    Context context;
    Activity activity;


    public ToolKit(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;

    }

    public View getView(String sID){
        int ID = context.getResources().getIdentifier(sID, "id", context.getPackageName());
        return activity.findViewById(ID);
    }
}
