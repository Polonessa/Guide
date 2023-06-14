package com.example.lr5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class AttractionInfo extends AppCompatActivity {
    private TextView description;
    private TextView depth;
    private Landmark landmark;
    private MapView map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_info);

        map = findViewById(R.id.map);
        description = findViewById(R.id.description);
        depth = findViewById(R.id.depth);

        getDescription();
        SetPoint();
    }
    public void getDescription(){
        landmark = getIntent().getParcelableExtra(Landmark.class.getCanonicalName());
        description.setText(landmark.getDescr());
        depth.setText("Глубина у причалов: " + String.valueOf(landmark.getDepth()));
        setTitle(landmark.getName());
    }
    @Override
    protected void onStop() {
        map.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        map.onStart();
    }

    public void SetPoint(){
        map.getMap().move(
                new CameraPosition(landmark.getPoint(), 10f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 5), null);
        map.getMap().getMapObjects().addPlacemark(landmark.getPoint());
    }
}