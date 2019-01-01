package deepshooter.com.customlauncher;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import deepshooter.com.customlauncher.Home.Contact;
import deepshooter.com.customlauncher.TwowayGrid.TwoWayAbsListView;

public class MainActivity extends Activity {


    ImageView home, twitter , clashofclan , video , music , search;

    String phone = "8867726960";

    public static Typeface myfont ;

    TextView twittertext , clashofclantext , musictext , videotext , searchtext;

    TwoWayAbsListView vL_twowaylist;
    TwoWayListAdapter listAdapter;
    TextView Name ;

    List<Contact> contactList = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initializeValue();
        setValue();
        setFont();

    }


    private void initializeValue() {

        home = (ImageView) findViewById(R.id.home);
        twitter = (ImageView) findViewById(R.id.twitter);
        clashofclan = (ImageView) findViewById(R.id.coc);
        video = (ImageView) findViewById(R.id.video);
        search = (ImageView) findViewById(R.id.chrome);
        music = (ImageView) findViewById(R.id.music);

        twittertext = (TextView) findViewById(R.id.textview1);
        clashofclantext = (TextView) findViewById(R.id.textview2);
        musictext = (TextView) findViewById(R.id.textview3);
        videotext = (TextView) findViewById(R.id.textview4);
        searchtext = (TextView) findViewById(R.id.textview5);

        vL_twowaylist =   (TwoWayAbsListView)findViewById(R.id.vL_apgd_twowaylist);
    }


    private void setFont() {

        myfont  = Typeface.createFromAsset(getAssets(), "fff.ttf");

        twittertext.setTypeface(myfont);
        clashofclantext.setTypeface(myfont);
        musictext.setTypeface(myfont);
        videotext.setTypeface(myfont);
        searchtext.setTypeface(myfont);

    }


    private void setValue() {


        Contact contact1 = new Contact();
        contact1.setName("PAA");
        contact1.setNumber("0123456789");
        contactList.add(contact1);

        Contact contact2 = new Contact();
        contact2.setName("D");
        contact2.setNumber("0123456789");
        contactList.add(contact2);

        Contact contact3 = new Contact();
        contact3.setName("BAHI");
        contact3.setNumber("0123456789");
        contactList.add(contact3);





        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);

          }
      });



        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.twitter.android");
                startActivity( LaunchIntent );
            }
        });



        clashofclan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.supercell.clashofclans");
                startActivity( LaunchIntent );

            }
        });


        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.mxtech.videoplayer.ad");
                startActivity( LaunchIntent );

            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.music");
                startActivity( LaunchIntent );

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
                startActivity( LaunchIntent );

            }
        });


        listAdapter=new TwoWayListAdapter();
        vL_twowaylist.setAdapter(listAdapter);

    }



    private class TwoWayListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return contactList.size();

        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if(convertView==null){

                convertView = getLayoutInflater().inflate(R.layout.twowaylist_adapter, parent, false);

            }


            Name = (TextView) convertView.findViewById(R.id.ctaegory);
            Name.setTypeface(myfont);


            Name.setText(contactList.get(position).getName());

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    String mNumber = contactList.get(position).getNumber();

                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + mNumber));
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    startActivity(intent);


                }
            });


            return convertView;
        }

    }
}
