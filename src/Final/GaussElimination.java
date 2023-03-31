package Final;

public class GaussElimination {
    double[][] upperTriangularMatrix;
    double[] answer;

    public GaussElimination(double[][] matrix){
        upperTriangularMatrix = matrix;
        answer = new double[matrix.length];
    }


    public void ForwardElimination(){
        for(int i = 0 ; i < upperTriangularMatrix.length-1 ; i++){ //loop pivot
            for(int j = i+1 ; j < upperTriangularMatrix.length ; j++){ //loop row
                double factor = upperTriangularMatrix[j][i] / upperTriangularMatrix[i][i];
                for(int k = i ; k < upperTriangularMatrix.length+1 ; k++){ //loop column
                    upperTriangularMatrix[j][k] -= factor * upperTriangularMatrix[i][k];
                }
            }
        }
    }

    //myself algorithm
    public void BackwardSubstitution(){
        //ans for last variable
        answer[answer.length-1] = upperTriangularMatrix[upperTriangularMatrix.length-1][upperTriangularMatrix.length] / upperTriangularMatrix[upperTriangularMatrix.length-1][upperTriangularMatrix.length-1];
        for(int i = upperTriangularMatrix.length-2 ; i >= 0 ; i--){
            double sum = 0;
            for(int j = i+1 ; j < upperTriangularMatrix.length ; j++){
                sum += upperTriangularMatrix[i][j] * answer[j];
            }
            answer[i] = (upperTriangularMatrix[i][upperTriangularMatrix.length] - sum) / upperTriangularMatrix[i][i];
        }
    }

    public void PrintAnswer(){
        System.out.println("Normal");
        for(int i = 0 ; i < answer.length ; i++){
            System.out.println("x" + (i+1) + " = " + answer[i]);
        }
    }
}
