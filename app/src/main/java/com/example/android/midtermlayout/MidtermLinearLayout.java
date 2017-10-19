package com.example.android.midtermlayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.text.InputType;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by globe_000 on 10/14/2017.
 */

public class MidtermLinearLayout extends LinearLayout {

    private EditText editText;
    private Button searchButton;
    private TextView result;
    private Button celsiusButton;


    public MidtermLinearLayout(Context context, OnClickListener listener, OnClickListener cListener ){
        super(context);

        LinearLayout.LayoutParams params = (new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                      ViewGroup.LayoutParams.MATCH_PARENT));
        params.gravity = Gravity.CENTER_HORIZONTAL;
        setGravity(Gravity.TOP);
        setOrientation(LinearLayout.VERTICAL);
        setLayoutParams( params );
        editText = new EditText(context);
        searchButton  = new Button(context);
        result = new TextView(context);
        celsiusButton = new Button(context);

        LayoutParams editTextParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        editTextParams.gravity = Gravity.CENTER_HORIZONTAL;
        editText.setGravity(Gravity.TOP);
        editTextParams.setMargins(20,20,20,20);
        editText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        editText.setHint("Enter Title");
        editText.setLayoutParams(editTextParams);
        addView( editText );

        LayoutParams searchParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        searchParams.gravity = Gravity.CENTER_HORIZONTAL;
        searchButton.setGravity(Gravity.TOP);
        searchButton.setText("Search");
        searchButton.setLayoutParams(searchParams);
        searchButton.setOnClickListener(listener);
        addView( searchButton );

        LayoutParams celsiusParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        celsiusParams.gravity = Gravity.CENTER_HORIZONTAL;
        celsiusButton.setGravity(Gravity.TOP);
        celsiusButton.setText("Get Celsius");
        celsiusButton.setLayoutParams(celsiusParams);
        celsiusButton.setOnClickListener(cListener);
        addView( celsiusButton );

        ShapeDrawable sd = new ShapeDrawable();
        // Specify the shape of ShapeDrawable
        sd.setShape(new RectShape());
        // Specify the border color of shape
        sd.getPaint().setColor(Color.RED);
        // Set the border width
        sd.getPaint().setStrokeWidth(10f);
        // Specify the style is a Stroke
        sd.getPaint().setStyle(Paint.Style.STROKE);

        LayoutParams resultParams = new LayoutParams(700, 800);
        resultParams.gravity = Gravity.CENTER_HORIZONTAL;
        result.setGravity(Gravity.TOP);
        result.setLayoutParams(resultParams);
        result.setBackgroundDrawable(sd);
        addView( result );

    }

    public String getTextInput(){
        return editText.getText().toString();
    }

    public void displayText(Weather resultText){
        //result.setText(resultText);
//        result.append("Description : " + resultText[0] + "\n");
//        result.append("Temp : " + resultText[1]);
        result.append(resultText.toString());
    }

    public void clearResult(){
        result.setText("");
    }

    public void setCelsius(String c){
        result.append("\nCelsius : " + c);
    }
}
