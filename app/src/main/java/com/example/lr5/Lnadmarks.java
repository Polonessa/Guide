package com.example.lr5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yandex.mapkit.directions.driving.Description;
import com.yandex.mapkit.geometry.Point;

import java.util.ArrayList;

public class Lnadmarks extends AppCompatActivity {
    private ArrayList<Landmark> landmarks = new ArrayList<>();
    private ArrayList<Landmark> avaliableLandmarks = new ArrayList<>();
    private ListView listOfLandmarks;
    private User user;
    private TextView hello;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lnadmarks);

        hello = findViewById(R.id.HelloUser);
        listOfLandmarks = findViewById(R.id.ListOfAtractions);
        listOfLandmarks.setBackgroundColor(50);

        setTitle("Яхтклубы Петербурга");
        Hello();
        landmarks.add(new Landmark("Балтиец", R.string.Балтиец, new Point(59.860014516473164, 30.12362344229707), 2.5F));
        landmarks.add(new Landmark("Геркулес", R.string.Геркулес, new Point(59.98811064214254, 30.167831401514952), 3F));
        landmarks.add(new Landmark("Крестовский", R.string.Крестовский, new Point(59.96746799915576, 30.246901599999998), 4F));
        landmarks.add(new Landmark("Речной", R.string.Речной, new Point(59.96406493946682, 30.241350395663492), 4F));
        landmarks.add((new Landmark("Горская", R.string.Горская, new Point(60.03702683726319, 29.975637759156125), 4.5F)));
        landmarks.add(new Landmark("Крондштадт", R.string.Крондшадтский, new Point(59.987161758174246, 29.799724847652808),4F));

        for (int i = 0; i < landmarks.size(); ++i){
            if (landmarks.get(i).getDepth() > user.getDraft())
                avaliableLandmarks.add(landmarks.get(i));
        }

        Adapter();
        ClickOnAttraction();
    }
    public void Hello(){
        user = getIntent().getExtras().getParcelable(User.class.getCanonicalName());
        hello.setText("Добро пожаловать, " + user.getName());
    }

    public void Adapter(){
        ArrayAdapter<Landmark> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, avaliableLandmarks);
        listOfLandmarks.setAdapter(adapter);
    }
    public void ClickOnAttraction(){
    listOfLandmarks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Lnadmarks.this, AttractionInfo.class);
                Landmark Attraction = (Landmark) listOfLandmarks.getItemAtPosition(position);
                intent.putExtra(Landmark.class.getCanonicalName(), Attraction);
                startActivity(intent);
            }
        });
    }
}