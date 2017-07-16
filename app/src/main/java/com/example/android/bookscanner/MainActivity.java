package com.example.android.bookscanner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bookscanner.ModelClasses.AccessInfo;
import com.example.android.bookscanner.ModelClasses.ImageLinks;
import com.example.android.bookscanner.ModelClasses.Item;
import com.example.android.bookscanner.ModelClasses.JsonResponse;
import com.example.android.bookscanner.ModelClasses.VolumeInfo;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private Button scanBtn, previewBtn, linkBtn;
   // private TextView formatTxt, contentTxt;
   private TextView authorText, titleText, descriptionText, dateText, ratingCountText;
    private LinearLayout starLayout;
    private ImageView thumbView;
    private ImageView[] starViews;
    private ApiInterface apiInterface;
    private String smallThumbnail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        scanBtn = (Button)findViewById(R.id.scan_button);
        //formatTxt = (TextView)findViewById(R.id.scan_format);
       // contentTxt = (TextView)findViewById(R.id.scan_content);
        previewBtn = (Button)findViewById(R.id.preview_btn);
        previewBtn.setVisibility(View.GONE);
       // previewBtn.setOnClickListener(this);
        linkBtn = (Button)findViewById(R.id.link_btn);
        linkBtn.setVisibility(View.GONE);
        //linkBtn.setOnClickListener(this);
        authorText = (TextView)findViewById(R.id.book_author);
        titleText = (TextView)findViewById(R.id.book_title);
        descriptionText = (TextView)findViewById(R.id.book_description);
        dateText = (TextView)findViewById(R.id.book_date);
        starLayout = (LinearLayout)findViewById(R.id.star_layout);
        ratingCountText = (TextView)findViewById(R.id.book_rating_count);
        thumbView = (ImageView)findViewById(R.id.thumb);
        starViews=new ImageView[5];
        for(int s=0; s<starViews.length; s++){
            starViews[s]=new ImageView(this);
        }

        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    IntentIntegrator scanIntegrator=  new IntentIntegrator(MainActivity.this);
                    scanIntegrator.initiateScan();

            }
        });
        linkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the url tag
                String tag = (String)v.getTag();
                //launch the url
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse(tag));
                startActivity(webIntent);

            }
        });

        previewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tag = (String)v.getTag();
                //launch preview
                Intent intent = new Intent(MainActivity.this, EmbeddedBook.class);
                intent.putExtra("isbn", tag);
                startActivity(intent);
            }
        });
        if (savedInstanceState != null){
            authorText.setText(savedInstanceState.getString("author"));
            titleText.setText(savedInstanceState.getString("title"));
            descriptionText.setText(savedInstanceState.getString("description"));
            dateText.setText(savedInstanceState.getString("date"));
            ratingCountText.setText(savedInstanceState.getString("ratings"));
            int numStars = savedInstanceState.getInt("stars");//zero if null
            for(int s=0; s<numStars; s++){
                starViews[s].setImageResource(R.drawable.star);
                starLayout.addView(starViews[s]);
            }
            starLayout.setTag(numStars);
            Picasso.with(MainActivity.this).load(smallThumbnail).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(thumbView);

            previewBtn.setTag(savedInstanceState.getString("isbn"));

            if(savedInstanceState.getBoolean("isEmbed")) previewBtn.setEnabled(true);
            else previewBtn.setEnabled(false);
            if(savedInstanceState.getInt("isLink")==View.VISIBLE) linkBtn.setVisibility(View.VISIBLE);
            else linkBtn.setVisibility(View.GONE);
            previewBtn.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(scanningResult!=null) {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            // formatTxt.setText("FORMAT: " + scanFormat);
            //contentTxt.setText("CONTENT: " + scanContent);
            if (scanContent != null && scanFormat != null && scanFormat.equalsIgnoreCase("EAN_13")) {
                previewBtn.setTag(scanContent);
                //book search
                apiInterface= ApiClient.getClient().create(ApiInterface.class);
                Call<JsonResponse> call = apiInterface.getBook(scanContent, "AIzaSyCYDpakk-ADzQLL2U0r2L-biF01wOP0m3Q");
                call.enqueue(new Callback<JsonResponse>() {
                    @Override
                    public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                        previewBtn.setVisibility(View.VISIBLE);
                        List<Item> items= response.body().getItems();
                        Item item= items.get(0);
                        VolumeInfo volumeInfo= item.getVolumeInfo();
                        titleText.setText("TITLE: "+volumeInfo.getTitle());
                        StringBuilder authorBuild = new StringBuilder("");
                        if(volumeInfo.getAuthors()!=null){
                            List<String> authors= volumeInfo.getAuthors();
                            for(int a=0; a<authors.size(); a++){
                                if(a>0) authorBuild.append(", ");
                                authorBuild.append(authors.get(a));
                                authorText.setText("AUTHOR(S): "+authorBuild.toString());
                            }
                        }
                        else{
                            authorText.setText("");
                        }

                        if(volumeInfo.getPublishedDate()!=null){
                            dateText.setText("PUBLISHED: "+volumeInfo.getPublishedDate());
                        }
                        else{
                            dateText.setText("");
                        }

                        if(volumeInfo.getDescription()!=null){
                            descriptionText.setText("DESCRIPTION: "+volumeInfo.getDescription());
                        }
                        else{
                            descriptionText.setText("");
                        }
                        if(volumeInfo.getAverageRating()!=null){
                            double decNumStars = Double.parseDouble(String.valueOf(volumeInfo.getAverageRating()));
                            int numStars = (int)decNumStars;
                            starLayout.setTag(numStars);
                            starLayout.removeAllViews();
                            for(int s=0; s<numStars; s++){
                                starViews[s].setImageResource(R.drawable.star);
                                starLayout.addView(starViews[s]);
                            }
                        }
                        else{
                            starLayout.removeAllViews();
                        }

                        if(volumeInfo.getRatingsCount()!=null){
                            ratingCountText.setText(" - "+volumeInfo.getRatingsCount()+" ratings");
                        }
                        else{
                            ratingCountText.setText("");
                        }
                        AccessInfo accessInfo= item.getAccessInfo();
                        if(accessInfo.getEmbeddable()!=null){
                            boolean isEmbeddable = Boolean.parseBoolean
                                    (String.valueOf(accessInfo.getEmbeddable()));
                            if(isEmbeddable) previewBtn.setEnabled(true);
                            else previewBtn.setEnabled(false);

                        }
                        else{
                            previewBtn.setEnabled(false);

                        }

                        if(volumeInfo.getInfoLink()!= null){
                            linkBtn.setTag(volumeInfo.getInfoLink());
                            linkBtn.setVisibility(View.VISIBLE);
                        }
                        else{
                            linkBtn.setVisibility(View.GONE);
                        }
                        ImageLinks imageLinks= volumeInfo.getImageLinks();
                         smallThumbnail= imageLinks.getSmallThumbnail();

                        Picasso.with(MainActivity.this).load(smallThumbnail).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(thumbView);

                    }

                    @Override
                    public void onFailure(Call<JsonResponse> call, Throwable t) {

                    }
                });
            } else {
                Toast.makeText(getApplicationContext(), "Not a valid scan!", Toast.LENGTH_SHORT).show();

            }
        }

        else{
            Toast.makeText(getApplicationContext(), "No book scan data received!", Toast.LENGTH_SHORT).show();

        }
    }
    protected void onSaveInstanceState(Bundle savedBundle) {
        savedBundle.putString("title", ""+titleText.getText());
        savedBundle.putString("author", ""+authorText.getText());
        savedBundle.putString("description", ""+descriptionText.getText());
        savedBundle.putString("date", ""+dateText.getText());
        savedBundle.putString("ratings", ""+ratingCountText.getText());
        savedBundle.putString("thumbPic", smallThumbnail );
        if(starLayout.getTag()!=null)
            savedBundle.putInt("stars", Integer.parseInt(starLayout.getTag().toString()));
        savedBundle.putBoolean("isEmbed", previewBtn.isEnabled());
        savedBundle.putInt("isLink", linkBtn.getVisibility());
        if(previewBtn.getTag()!=null)
            savedBundle.putString("isbn", previewBtn.getTag().toString());
    }



}
