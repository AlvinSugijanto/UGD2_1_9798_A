package bernadus.alvin.ugd1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.view.MenuItem;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class inputactivity extends AppCompatActivity {
    Button dropbtn;
    public static final String FULL_NAME = "full_name";
    public static final String NAMA_SNACK = "nama_snack";

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_activity);
        final TextInputEditText firstNameInput = findViewById(R.id.firstname);
        final TextInputEditText lastNameInput = findViewById(R.id.lastname);
        final TextInputLayout firstNameLayout = findViewById(R.id.firstname_layout);
        final TextInputLayout lastNameLayout = findViewById(R.id.lastname_layout);
        final Button dropdownBtn = findViewById(R.id.dropbtn);
        Button sendButton = findViewById(R.id.send_btn);
        dropdownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu dropDownMenu = new PopupMenu(getApplicationContext(), dropdownBtn);
                dropDownMenu.getMenuInflater().inflate(R.menu.dropdown_menu, dropDownMenu.getMenu());
                dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        return true;
                    }
                });
                dropDownMenu.show();
            }

        });
        sendButton.setOnClickListener(new View.OnClickListener()
        {

                @Override
                public void onClick(View v)
                {
                    String namasnack = String.valueOf(dropdownBtn.getText());
                    String first = String.valueOf(firstNameInput.getText());
                    String last = String.valueOf(lastNameInput.getText());
                    if(first.isEmpty()||last.isEmpty())
                    {
                        firstNameLayout.setError("Please fill correctly.");
                        lastNameLayout.setError("Please fill correctly");
                    }
                    else
                    {
                        final String fulllName = first + " " + last;
                        Bundle bundle = new Bundle();
                        bundle.putString(FULL_NAME, fulllName);
                    }
                }

        });

    }

}