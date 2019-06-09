package hjddevs.spotlightsandspotholes.com.spotlightsandspotholes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdminLogin extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        Name = (EditText)findViewById(R.id.adminName);
        Password = (EditText)findViewById(R.id.adminPassword);

        Login = (Button)findViewById(R.id.AdminLoginButton);



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(AdminLogin.this, ViewStreetlightComplaints.class);
            startActivity(intent);
        }else{


            Info.setText("INVALID DETAILS! " );


            }
        }
    }


