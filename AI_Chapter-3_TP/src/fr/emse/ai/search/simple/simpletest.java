package fr.emse.ai.search.simple;

import fr.emse.ai.search.solver.BreadthFirstGraphSearch;
import fr.emse.ai.search.solver.BreadthFirstTreeSearch;
import fr.emse.ai.search.solver.DepthFirstGraphSearch;
import fr.emse.ai.search.solver.DepthFirstTreeSearch;

public class SimpleTest {

    public static void main(String[] args) {


        MissionariesCannibalsProblem p1= new MissionariesCannibalsProblem();
        System.out.println("Solution to problem MissionariesCannibalsProblem: ");
        System.out.println(new BreadthFirstGraphSearch().solve(p1).pathToString());

        FarmerProblem p2= new FarmerProblem();
        System.out.println("Solution to problem FarmerProblem: ");
        System.out.println(new BreadthFirstGraphSearch().solve(p2).pathToString());

        CanProblem p3 = new CanProblem();
        System.out.println("Solution to problem CanProblem : ");
        System.out.println(new BreadthFirstGraphSearch().solve(p3).pathToString());
    }
}
