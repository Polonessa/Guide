package com.example.lr5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button next;
    private User user;

    public boolean isNumeric(String Str){
        char[] string = Str.toCharArray();

        for(int i = 0; i < string.length; ++i) {
            if(!Character.isDigit(string[i]))
                return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("");

        addListenerOnButton();
    }

    public void addListenerOnButton(){
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.name);
                EditText surename = findViewById(R.id.surname);
                EditText email = findViewById(R.id.email);
                EditText draft = findViewById(R.id.draft);
                String inDraft = draft.getText().toString();
                if(!name.getText().toString().equals("") && !surename.getText().toString().equals("")
                        && !email.getText().toString().equals("") && !inDraft.equals("") && isNumeric(inDraft)) {
                    user = new User(name.getText().toString(), surename.getText().toString(),
                            email.getText().toString(), Double.parseDouble(inDraft));
                    Intent intent = new Intent(MainActivity.this,Lnadmarks.class);
                    intent.putExtra(User.class.getCanonicalName(), user);
                    startActivity(intent);
                }
                else if ((!name.getText().toString().equals("") && !surename.getText().toString().equals("")
                        && !email.getText().toString().equals("")) && (inDraft.equals("") || !isNumeric(inDraft)))
                    Toast.makeText(MainActivity.this, "Осадка должна быть численным значением!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Введите Ваши данные!", Toast.LENGTH_LONG).show();
            }
        });
    }
}