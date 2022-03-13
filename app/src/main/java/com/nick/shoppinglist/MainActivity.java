package com.nick.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.nick.shoppinglist.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final ArrayList<String> shoppingListItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,shoppingListItems);
        binding.shoppingListView.setAdapter(adapter);
        binding.addItemButton.setOnClickListener(view -> {
            shoppingListItems.add(binding.newItemEditText.getText().toString());
            binding.newItemEditText.setText("");
            adapter.notifyDataSetChanged();
        });
    }
}
