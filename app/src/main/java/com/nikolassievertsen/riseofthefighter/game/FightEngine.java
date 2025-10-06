package com.nikolassievertsen.riseofthefighter.game;

import com.nikolassievertsen.riseofthefighter.data.model.Fighter;

import java.util.Random;

public class FightEngine {

    public enum FightPlan {
        STRIKE_FOCUS,
        GRAPPLE_FOCUS,
        BALANCED
    }

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

    public FightResult simulateFight(Fighter player, Fighter opponent, FightPlan plan, long seed) {
        Random random = new Random(seed);

        // Calculate effective scores for both fighters
        double playerEffectiveScore = calculateEffectiveOverall(player, plan);
        double opponentEffectiveScore = calculateEffectiveOverall(opponent, FightPlan.BALANCED); // Opponent AI is balanced for now

        // Calculate win probability using softmax with an upset floor
        double totalScore = playerEffectiveScore + opponentEffectiveScore;
        double playerWinProbability = (playerEffectiveScore / totalScore) * 0.95 + 0.025; // 5% upset floor

        // Simulate the fight
        double roll = random.nextDouble();
        if (roll < playerWinProbability) {
            // Player wins
            String method = determineMethodOfVictory(player, opponent, random);
            return new FightResult(player.name, method, player.name + " wins by " + method + "!");
        } else {
            // Opponent wins
            String method = determineMethodOfVictory(opponent, player, random);
            return new FightResult(opponent.name, method, opponent.name + " wins by " + method + "!");
        }
    }

    private double calculateEffectiveOverall(Fighter fighter, FightPlan plan) {
        double effectiveStriking = fighter.striking * getPlanModifier(plan, "striking");
        double effectiveGrappling = fighter.grappling * getPlanModifier(plan, "grappling");
        double effectiveWrestling = fighter.wrestling * getPlanModifier(plan, "wrestling");

        // Weighted sum of all effective stats
        return (effectiveStriking * 1.5) +
                (effectiveGrappling * 1.5) +
                (effectiveWrestling * 1.5) +
                (fighter.strength * 1.2) +
                (fighter.speed * 1.2) +
                (fighter.endurance * 1.8) +
                (fighter.durability * 2.0) +
                (fighter.clinch * 1.2) +
                (fighter.fightIQ * 3.0) +
                (fighter.confidence * 1.5);
    }

    private double getPlanModifier(FightPlan plan, String skill) {
        switch (plan) {
            case STRIKE_FOCUS:
                return skill.equals("striking") ? 1.2 : 0.9;
            case GRAPPLE_FOCUS:
                return skill.equals("grappling") || skill.equals("wrestling") ? 1.2 : 0.9;
            case BALANCED:
            default:
                return 1.0;
        }
    }

    private String determineMethodOfVictory(Fighter winner, Fighter loser, Random random) {
        double koProbability = (double) winner.striking / (winner.striking + winner.grappling);
        double subProbability = 1.0 - koProbability;

        double roll = random.nextDouble();
        if (roll < koProbability) {
            return "KO";
        } else if (roll < koProbability + subProbability) {
            return "Submission";
        } else {
            return "Decision";
        }
    }
}