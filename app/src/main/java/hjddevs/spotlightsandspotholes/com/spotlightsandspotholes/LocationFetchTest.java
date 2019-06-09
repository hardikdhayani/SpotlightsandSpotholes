package hjddevs.spotlightsandspotholes.com.spotlightsandspotholes;
import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LocationFetchTest extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_LOCATION = 1;
    Button button;
    Button slcomplains,phcomplains,newsl;
    TextView textView;
    LocationManager locationManager;
    String lattitude, longitude;

    public static final String EXTRA_TEXT = "hjddevs.spotlightsandspotholes.com.activityswitch.EXTRA_TEXT";
    public static final String EXTRA_NUMBER = "hjddevs.spotlightsandspotholes.com.activityswitch.EXTRA_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_fetch_test);

        Button slcomplains = (Button) findViewById(R.id.slcomplains);
        slcomplains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddComplaint();
            }
        });
        Button phcomplains = (Button) findViewById(R.id.phcomplains);
        phcomplains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddComplaint2();
            }
        });

        Button newsl = (Button) findViewById(R.id.newsl);
        newsl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddComplaint3();
            }
        });

        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        textView = (TextView) findViewById(R.id.text_location);
        button = (Button) findViewById(R.id.button_location);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();

        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            getLocation();
        }
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(LocationFetchTest.this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (LocationFetchTest.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(LocationFetchTest.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            Location location1 = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            Location location2 = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

            if (location != null) {
                double latti = location.getLatitude();
                double longi = location.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);

                textView.setText("Latitude = " + lattitude
                        + "\n" + "Longitude = " + longitude);

            } else if (location1 != null) {
                double latti = location1.getLatitude();
                double longi = location1.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);

                textView.setText("Latitude = " + lattitude
                        + "\n" + "Longitude = " + longitude);


            } else if (location2 != null) {
                double latti = location2.getLatitude();
                double longi = location2.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);

                textView.setText("Latitude = " + lattitude
                        + "\n" + "Longitude = " + longitude);

            } else {

                Toast.makeText(this, "Unble to Trace your location", Toast.LENGTH_SHORT).show();

            }
        }
    }

    protected void buildAlertMessageNoGps() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please Turn ON your GPS Connection")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }
    public void openAddComplaint() {
        TextView textview = (TextView) findViewById(R.id.text_location);
        String text = textview.getText().toString();

        //   EditText editText2 = (EditText) findViewById(R.id.edittext2);
        //  int number = Integer.parseInt(editText2.getText().toString());

        Intent intent = new Intent(this, AddComplaint.class);
        intent.putExtra(EXTRA_TEXT, text);
        //  intent.putExtra(EXTRA_NUMBER, number);
        startActivity(intent);
    }



    public void openAddComplaint2() {
        TextView textview = (TextView) findViewById(R.id.text_location);
        String text = textview.getText().toString();

        //   EditText editText2 = (EditText) findViewById(R.id.edittext2);
        //  int number = Integer.parseInt(editText2.getText().toString());

        Intent intent = new Intent(this, AddComplaint2.class);
        intent.putExtra(EXTRA_TEXT, text);
        //  intent.putExtra(EXTRA_NUMBER, number);
        startActivity(intent);
    }


    public void openAddComplaint3() {
        TextView textview = (TextView) findViewById(R.id.text_location);
        String text = textview.getText().toString();

        //   EditText editText2 = (EditText) findViewById(R.id.edittext2);
        //  int number = Integer.parseInt(editText2.getText().toString());

        Intent intent = new Intent(this, AddComplaint3.class);
        intent.putExtra(EXTRA_TEXT, text);
        //  intent.putExtra(EXTRA_NUMBER, number);
        startActivity(intent);
    }
}