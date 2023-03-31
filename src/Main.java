import Final.GaussElimination;
import Final.GaussEliminationPro;

public class Main {
    public static void main(String[] args) {
        double[][] matrix = new double[][]{
                {3,0,-9,33},
                {7,-4,-1,-15},
                {4,6,5,-6}
        };
        GaussElimination gaussElimination = new GaussElimination(matrix);
        gaussElimination.ForwardElimination();
        gaussElimination.BackwardSubstitution();
        gaussElimination.PrintAnswer();

        double[][] matrix2 = new double[][]{
                {3,0,-9},
                {7,-4,-1},
                {4,6,5}
        };


        double[] augmentedMatrix = new double[]{33,-15,-6};
        GaussEliminationPro gaussEliminationPro = new GaussEliminationPro(matrix2,augmentedMatrix);
        gaussEliminationPro.ForwardElimination();
        gaussEliminationPro.BackSubstitution();
        gaussEliminationPro.PrintAnswer();
    }
}
