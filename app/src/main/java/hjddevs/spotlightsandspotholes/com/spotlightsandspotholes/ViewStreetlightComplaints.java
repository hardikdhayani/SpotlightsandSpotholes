package hjddevs.spotlightsandspotholes.com.spotlightsandspotholes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ViewStreetlightComplaints extends AppCompatActivity {
    private Button viewstreetcomplaints;
    private Button potholescomplaints;
    private Button streetlightrequests;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_streetlight_complaints);

        viewstreetcomplaints = findViewById(R.id.viewstreetcomplaints);
        potholescomplaints = findViewById(R.id.potholescompliants);
        streetlightrequests = findViewById(R.id.streetlightrequests);



        logout = (Button)findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });

        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");

        viewstreetcomplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewStreetlightComplaints.this, RetrieveComplaint.class);
                startActivity(intent);
            }
        });
        potholescomplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewStreetlightComplaints.this, RetrieveComplaint2.class);
                startActivity(intent);
            }
        });
        streetlightrequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewStreetlightComplaints.this, RetrieveComplaint3.class);
                startActivity(intent);
            }
        });
    }
    private void Logout(){

        finish();
        startActivity(new Intent(ViewStreetlightComplaints.this, MainActivity.class));
    }
}