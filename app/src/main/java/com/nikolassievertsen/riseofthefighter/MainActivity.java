package com.nikolassievertsen.riseofthefighter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.nikolassievertsen.riseofthefighter.databinding.ActivityDashboardBinding;
import com.nikolassievertsen.riseofthefighter.ui.DashboardViewModel;
import com.nikolassievertsen.riseofthefighter.ui.TrainingActivity;

public class MainActivity extends AppCompatActivity {

    private DashboardViewModel dashboardViewModel;
    private ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use ViewBinding to easily access views
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get a new or existing ViewModel from the ViewModelProvider.
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        // Add an observer on the LiveData returned by getFighter.
        // The onChanged() method fires when the observed data changes and the activity is in the foreground.
        dashboardViewModel.getFighter().observe(this, fighter -> {
            if (fighter != null) {
                binding.fighterName.setText(fighter.name);
                binding.fighterMoney.setText(String.format("$%.2f", fighter.money));
                // Calculate total energy and set progress
                int totalEnergy = fighter.energyCapBase + fighter.energyBonus;
                int currentEnergy = totalEnergy - fighter.fatigue; // Assuming fatigue represents used energy
                binding.energyBar.setMax(totalEnergy);
                binding.energyBar.setProgress(currentEnergy);
            }
        });

        // Setup button listeners
        setupListeners();
    }

    private void setupListeners() {
        binding.btnAdvanceWeek.setOnClickListener(v -> {
            dashboardViewModel.advanceWeek();
            Toast.makeText(this, "A week has passed.", Toast.LENGTH_SHORT).show();
        });

        binding.btnTrain.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TrainingActivity.class);
            startActivity(intent);
        });

        // Placeholder listeners for other buttons
        binding.btnCareer.setOnClickListener(v -> Toast.makeText(this, "Career screen coming soon!", Toast.LENGTH_SHORT).show());
        binding.btnLifestyle.setOnClickListener(v -> Toast.makeText(this, "Lifestyle screen coming soon!", Toast.LENGTH_SHORT).show());
    }
}