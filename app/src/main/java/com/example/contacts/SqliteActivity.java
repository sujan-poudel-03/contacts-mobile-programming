package com.example.contacts;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SqliteActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editPrice, editId;
    Button btnAddData;
    Button btnViewAll;
    Button btnUpdate;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        myDb = new DatabaseHelper(this);

        editName = findViewById(R.id.editTextName);
        editPrice = findViewById(R.id.editTextPrice);
        editId = findViewById(R.id.editTextId);
        btnAddData = findViewById(R.id.buttonAdd);
        btnViewAll = findViewById(R.id.buttonViewAll);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);

        addData();
        viewAll();
        updateData();
        deleteData();
    }

    public void deleteData() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData(editId.getText().toString());
                if (deletedRows > 0)
                    Toast.makeText(SqliteActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(SqliteActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void updateData() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = myDb.updateData(
                        editId.getText().toString(),
                        editName.getText().toString(),
                        editPrice.getText().toString()
                );
                if (isUpdate)
                    Toast.makeText(SqliteActivity.this, "Data Update", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(SqliteActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addData() {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(
                        editName.getText().toString(),
                        editPrice.getText().toString()
                );
                if (isInserted)
                    Toast.makeText(SqliteActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(SqliteActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void viewAll() {
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :" + res.getString(0) + "\n");
                    buffer.append("Name :" + res.getString(1) + "\n");
                    buffer.append("Price :" + res.getString(2) + "\n\n");
                }

                showMessage("Data", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}