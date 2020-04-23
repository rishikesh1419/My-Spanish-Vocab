package com.example.myspanishvocab;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements WordAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Word> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, com.example.myspanishvocab.AddWord.class);
                startActivity(intent);
            }
        });

//        Toast.makeText(this, "On Create", Toast.LENGTH_SHORT).show();

        recyclerView = findViewById(R.id.wordsRv);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        words = new ArrayList<Word>();
        words.add(new Word("grande","Adjective","","Big, Huge","Tu casa es grande.","grande"));
        words.add(new Word("el","Pronoun","","he","El tiene una casa.","el"));
        words.add(new Word("casa","Noun","feminine","house","Ella tiene una casa.","casa"));
        words.add(new Word("grande","Adjective","","Big, Huge","Tu casa es grande.","grande"));
        words.add(new Word("el","Pronoun","","he","El tiene una casa.","el"));
        words.add(new Word("grande","Adjective","","Big, Huge","Tu casa es grande.","grande"));
        words.add(new Word("el","Pronoun","","he","El tiene una casa.","el"));
        words.add(new Word("grande","Adjective","","Big, Huge","Tu casa es grande.","grande"));
        words.add(new Word("el","Pronoun","","he","El tiene una casa.","el"));
        words.add(new Word("grande","Adjective","","Big, Huge","Tu casa es grande.","grande"));
        words.add(new Word("el","Pronoun","","he","El tiene una casa.","el"));
        words.add(new Word("grande","Adjective","","Big, Huge","Tu casa es grande.","grande"));
        words.add(new Word("el","Pronoun","","he","El tiene una casa.","el"));

        myAdapter = new WordAdapter(this, words);

        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClicked(int position) {
//        Toast.makeText(this, "Usage: "+words.get(position).getUsage(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, com.example.myspanishvocab.WordDetails.class);

        Gson gson = new Gson();
        String word = gson.toJson(words.get(position));
        intent.putExtra("details", word);

        startActivity(intent);
    }
}
