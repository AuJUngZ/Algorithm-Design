import Final.GaussElimination;

public class Main {
    public static void main(String[] args) {
        double[][] matrix = new double[][]{
                {2, 3, 3, 5},
                {3, 2, -1, -4},
                {5, 4, 2, 3}
        };
        GaussElimination gaussElimination = new GaussElimination(matrix);
        gaussElimination.ForwardElimination();
        gaussElimination.BackwardSubstitution();
        gaussElimination.PrintAnswer();
    }
}
