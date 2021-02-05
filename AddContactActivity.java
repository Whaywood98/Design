package com.example.sharingapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Add a new contact
 */
public class AddContactActivity extends AppCompatActivity {

    private ContactList contact_list = new ContactList();
    private ContactListController contact_list_controller = new ContactListController(contact_list);

    private Context context;

    private EditText username;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        context = getApplicationContext();
        contact_list_controller.loadContacts(context);
    }

    public boolean validateInput(List<String> strings){
        for(int i = 0; i < strings.size(); i++){
            if(strings.get(i).equals("")){
                return false;
            }
        }
        return true;
    }

    public void saveContact(View view) {

        List<String> contact_str = new ArrayList<>();
        item.add(title.getUserName().toString());
        item.add(maker.getEmail().toString());


        if(!validateInput(contact_str)){
            return;
        }


        Contact contact = new Contact(contact_str.get(0), contact_str.get(1), null);

        // Add contact
        boolean success = contact_list_controller.addContact(contact, context);
        if (!success) {
            return;
        }

        // End AddContactActivity
        finish();
    }
}
