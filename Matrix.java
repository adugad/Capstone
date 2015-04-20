public class Matrix
{
    public Matrix(double[] values, int rows, int cols)
    {
        double[][] matrix = new double[rows][cols];
        int counter = 0;
        if(values.length == rows * cols)
        {
            for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j < cols; j++)
                {
                    matrix[i][j] = values[counter];
                    counter++;
                }
            }
        }
        else
        {
            throw new ArithmeticException("The number of values does not match the size of the matrix.");
        }
    }
    
    public double[][] createMatrixSubset(double[][] matrix, int skipRow, int skipCol)
    {
        double[][] newMatrix = new double[matrix.length - 1][matrix[0].length - 1];
        for(int i = 0; i < newMatrix.length; i++)
        {
            for(int j = 0; j < newMatrix[0].length; j++)
            {
                for(int k = 0; k < matrix.length; k++)
                {
                    for(int l = 0; l < matrix[0].length; l++)
                    {
                        if(k != skipRow || l != skipCol || matrix[k][l] != null)
                        {
                            newMatrix[i][j] = matrix[k][l];
                            matrix[k][l] = null;
                            l = matrix[0].length;
                            k = matrix.length;
                        }
                    }
                }
            }
        }
    }
    
    public double getDet(double[][] matrix)
    {
        double det = 0;
        double total = 0;
        if (matrix.length == matrix[0].length)
        {
            if(matrix.length == 2)
            {
                int a = 0;
                int b = 0;
                int c = 0;
                int d = 0;
                for(int i = 0; i < 2; i++)
                {
                    for(int j = 0; j < 2; j++)
                    {
                        if( i == 0 && j == 0)
                        {
                            a = matrix[i][j];
                        }
                        else if(i == 1 && j == 1)
                        {
                            d = matrix[i][j];
                        }
                        else if(i == 0 && j == 1)
                        {
                            b = matrix[i][j];
                        }
                        else
                        {
                            c = matrix[i][j];
                        }
                    }
                }
                det = a*d - b*c;
                total += det;
            }
            else
            {
                //recursive
            }
        }
        else
        {
            throw new ArithmeticException("Matrix is not a square.");
        }
    }
    
    public double[][] getInv(double[][] matrix)
    {
        if(matrix.length == matrix[0].length)
        {
            
        }
        else
        {
            throw new ArithmeticException("Matrix is not a square.");
        }
    }
    
    public double[][] transpose(double[][] matrix)
    {
        int cols = matrix[0].length;
        int rows = matrix.length;
        double[][] newMatrix = new double[cols][rows];
        for(int r = 0; r < matrix.length; r++)
        {
            for(int c = 0; c < matrix[0].length; c++)
            {
                newMatrix[c][r] = matrix[r][c];
            }
        }
        return newMatrix;
    }
    
    public double trace(double[][] matrix)
    {
        double value = 0;
        if (matrix.length == matrix[0].length)
        {
            for(int i = 0; i < matrix.length; i++)
            {
                value += matrix[i][i];
            }
            return value;
        }
        else
        {
            throw new ArithmeticException("Matrix is not a square.");
        }
    }
    
    public double[][] mult(double[][] mat1, double[][] mat2)
    {
        double[][] matrix = new double[mat1.length][mat2[0].length];
        if(mat1[0].length == mat2.length)
        {
            for(int i = 0; i < mat1.length; i++)
            {
                for(int j = 0; j < mat2[0].length; j++)
                {
                    for(int k = 0; k < mat1.length; k++)
                    {
                        matrix[i][j] = mat1[i][k] * mat2[k][j];
                    }
                }
            }
            return matrix;
        }
        else
        {
            throw new ArithmeticException("Matrices cannot be multiplied together.");
        }
    }
}