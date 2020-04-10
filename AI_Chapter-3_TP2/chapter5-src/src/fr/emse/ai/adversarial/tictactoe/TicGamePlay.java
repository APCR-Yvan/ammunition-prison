package fr.emse.ai.adversarial.tictactoe;

import fr.emse.ai.adversarial.AlphaBetaSearch;
import fr.emse.ai.adversarial.IterativeDeepeningAlphaBetaSearch;
import fr.emse.ai.adversarial.MinimaxSearch;

import java.util.List;
import java.util.Scanner;

public class TicGamePlay {

    public static void main(String[] args) {
        System.out.println("An exciting tic tac toe !");

        TicGame game = new TicGame();
        MinimaxSearch<List<Integer>, Integer, Integer> minimaxSearch = MinimaxSearch.createFor(game);
        AlphaBetaSearch<List<Integer>, Integer, Integer> alphabetaSearch = AlphaBetaSearch.createFor(game);
        IterativeDeepeningAlphaBetaSearch<List<Integer>, Integer, Integer> iterativeDeepeningAlphaBetaSearch = IterativeDeepeningAlphaBetaSearch.createFor(game, -1, 1, 10);
        List<Integer> state = game.getInitialState();
        while (!game.isTerminal(state)) {
            System.out.println("*************************");
            int action = -1;
            if (state.get(0) == 1) {
                //human
                List<Integer> actions = game.getActions(state);
                Scanner in = new Scanner(System.in);
                while (!actions.contains(action)) {
                    System.out.println("stupid ass, what is your action?");
                    action = in.nextInt();

                }
            } else {
                //machine
                System.out.println("AI, what is your action?");
                action = minimaxSearch.makeDecision(state);
                System.out.println("Metrics for Minimax : " + minimaxSearch.getMetrics());
                
            }
            System.out.println("Chosen action is " + action);
            state = game.getResult(state, action);
            game.printGameResult(state);
        }
        System.out.print("GAME OVER: ");
        if (game.getUtility(state,1) == -1)
            System.out.println("you wins!");
        else if (game.getUtility(state,1) == 1)
            System.out.println("you lose!");
        else { System.out.println("draw"); }

    }
}


