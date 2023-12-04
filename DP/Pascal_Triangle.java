package DP;

class Pascal_Triangle {
    public static void main(String[] args) {
        int n = 4;
        printLastRowPascal(n);
    }

    public static void printLastRowPascal(int n) {
        // An array to store the last row of the Pascal's Triangle
        int[] lastRow = new int[n];

        // Initialize the first value in the last row
        lastRow[0] = 1;

        // Calculate the last row values
        for (int i = 1; i < n; i++) {
            // Values in the last row are calculated based on the previous row
            lastRow[i] = (lastRow[i - 1] * (n - i)) / i;
        }

        // Print the last row with spaces
        for (int i = 0; i < n; i++) {
            System.out.print(lastRow[i] + " ");
        }
    }
}
