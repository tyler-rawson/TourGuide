/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView numbers;
    TextView familyMembers;
    TextView colors;
    TextView phrases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numbers = findViewById(R.id.numbers);
        familyMembers = findViewById(R.id.family);
        colors = findViewById(R.id.colors);
        phrases = findViewById(R.id.phrases);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(view.getContext(), NumbersActivity.class);
                    startActivity(i);
                } catch (Exception exception) {
                    Toast.makeText(MainActivity.this, "" + exception, Toast.LENGTH_SHORT).show();
                }
            }
        });
        familyMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(view.getContext(), FamilyMembersActivity.class);
                    startActivity(i);
                } catch (Exception exception) {
                    Toast.makeText(MainActivity.this, "" + exception, Toast.LENGTH_SHORT).show();
                }
            }
        });
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(view.getContext(), ColorsActivity.class);
                    startActivity(i);
                } catch (Exception exception) {
                    Toast.makeText(MainActivity.this, "" + exception, Toast.LENGTH_SHORT).show();
                }
            }
        });
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(view.getContext(), PhrasesActivity.class);
                    startActivity(i);
                } catch (Exception exception) {
                    Toast.makeText(MainActivity.this, "" + exception, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
