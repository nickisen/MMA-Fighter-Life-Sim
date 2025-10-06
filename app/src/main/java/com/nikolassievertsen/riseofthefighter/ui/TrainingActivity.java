package com.nikolassievertsen.riseofthefighter.ui;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.nikolassievertsen.riseofthefighter.databinding.ActivityTrainingBinding;

public class TrainingActivity extends AppCompatActivity {

    private ActivityTrainingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrainingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Training");

        // TODO: Connect this to a ViewModel to get real fighter data and update stats.
        // For now, these are just placeholder actions.
        binding.btnLightTraining.setOnClickListener(v -> {
            Toast.makeText(this, "Completed light training.", Toast.LENGTH_SHORT).show();
            // In the full implementation, this would deduct energy/money and add XP
            finish(); // Go back to the dashboard
        });

        binding.btnIntenseTraining.setOnClickListener(v -> {
            Toast.makeText(this, "Completed intense training.", Toast.LENGTH_SHORT).show();
            finish();
        });

        binding.btnSparring.setOnClickListener(v -> {
            Toast.makeText(this, "Completed sparring session.", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}