package com.nikolassievertsen.riseofthefighter.game;

import com.nikolassievertsen.riseofthefighter.data.model.Fighter;
import java.util.Random;

public class FightEngine {

    public static class FightResult {
        public final String winner;
        public final String method;
        public final String commentary;

        public FightResult(String winner, String method, String commentary) {
            this.winner = winner;
            this.method = method;
            this.commentary = commentary;
        }
    }

    public FightResult simulateFight(Fighter player, Fighter opponent) {
        // A more complex simulation would be round-by-round
        // This is a simplified version for demonstration

        double playerPower = calculateFighterPower(player);
        double opponentPower = calculateFighterPower(opponent);

        // Normalize power levels and add some randomness
        double totalPower = playerPower + opponentPower;
        double playerWinProbability = playerPower / totalPower;

        Random random = new Random();
        double roll = random.nextDouble();

        if (roll < playerWinProbability) {
            // Player wins
            return new FightResult(player.name, "KO", player.name + " wins by knockout!");
        } else {
            // Opponent wins
            return new FightResult(opponent.name, "KO", opponent.name + " wins by knockout!");
        }
    }

    private double calculateFighterPower(Fighter fighter) {
        // This is a simplified power calculation. A real game would have more depth.
        return (fighter.strength * 1.5) +
                (fighter.speed * 1.2) +
                (fighter.endurance * 1.8) +
                (fighter.durability * 2.0) +
                (fighter.striking * 2.5) +
                (fighter.grappling * 2.2) +
                (fighter.wrestling * 2.0) +
                (fighter.clinch * 1.5) +
                (fighter.fightIQ * 3.0) +
                (fighter.confidence * 1.5);
    }
}