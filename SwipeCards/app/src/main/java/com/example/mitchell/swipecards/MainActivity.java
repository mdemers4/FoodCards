package com.example.mitchell.swipecards;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.andtinder.model.CardModel;
import com.andtinder.model.Orientations;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;

public class MainActivity extends AppCompatActivity {

    private CardContainer mCardContainer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        mCardContainer = (CardContainer) findViewById(R.id.layoutview);
        mCardContainer.setOrientation(Orientations.Orientation.Ordered);

        Resources r = getResources();

        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);

        adapter.add(new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.picture1)));
        adapter.add(new CardModel("Title2", "Description goes here", r.getDrawable(R.drawable.picture2)));
        adapter.add(new CardModel("Title3", "Description goes here", r.getDrawable(R.drawable.picture3)));

        CardModel card = new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.picture1));
        card.setOnClickListener(new CardModel.OnClickListener() {
            @Override
            public void OnClickListener() {
                Log.i("Swipeable Cards","I am pressing the card");
            }
        });
        card.setOnCardDimissedListener(new CardModel.OnCardDimissedListener() {
            @Override
            public void onLike() {
                Log.i("Swipeable Card", "I liked it");
            }

            @Override
            public void onDislike() {
                Log.i("Swipeable Card", "I did not liked it");
                    }
                });
        adapter.add(card);
        mCardContainer.setAdapter(adapter);



        //ImageView imageButton =(ImageView) findViewById(R.id.imageButton);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent information_page = new Intent(MainActivity.this, PictureActivity.class);
//                startActivity(information_page);
//            }
//        });



    }

}
