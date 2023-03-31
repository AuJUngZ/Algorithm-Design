package Final;

public class GaussEliminationPro {
    double[][] upperTriangularMatrix;
    double[] augmentedMatrix;
    double[] answer;

    public GaussEliminationPro(double[][] matrix , double[] augmentedMatrix){
        this.upperTriangularMatrix = matrix;
        this.augmentedMatrix = augmentedMatrix;
        this.answer = new double[matrix.length];
    }


    public void ForwardElimination(){
        for(int i = 0 ; i < upperTriangularMatrix.length ; i++){
            for(int j = i+1 ; j < upperTriangularMatrix.length ; j++){
                double factor = upperTriangularMatrix[j][i] / upperTriangularMatrix[i][i];
                for(int k = i ; k < upperTriangularMatrix.length ; k++){
                    upperTriangularMatrix[j][k] -= factor * upperTriangularMatrix[i][k];
                }
                augmentedMatrix[j] -= factor * augmentedMatrix[i];
            }
        }
    }

    public void BackSubstitution(){
       answer[answer.length-1] = augmentedMatrix[augmentedMatrix.length-1] / upperTriangularMatrix[upperTriangularMatrix.length-1][upperTriangularMatrix.length-1];
       for(int i = upperTriangularMatrix.length-1-1 ; i >= 0 ; i--){
           double sum = augmentedMatrix[i];
           for(int j = i+1 ; j < upperTriangularMatrix.length ; j++){
               sum -= upperTriangularMatrix[i][j] * answer[j];
           }
              answer[i] = sum / upperTriangularMatrix[i][i];
       }
    }

    public void PrintAnswer(){
        System.out.println("Pro");
        for(int i = 0 ; i < answer.length ; i++){
            System.out.println("x" + (i+1) + " = " + answer[i]);
        }
    }
}
