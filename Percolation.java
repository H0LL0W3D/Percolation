/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {



    // ------- ATTRIBUTES --------
    private int[][] matrix; //visual graph we are representing
    private WeightedQuickUnionUF site; //backend quick union array for manipulation
    private int bottomPhantom; //variable just to make things easier
    private int topPhantom; //variable just to make things easier
    // ------- ATTRIBUTES --------


    public Percolation(int N)  {
        // create N-by-N grid, with all sites initially blocked


        if (N > 0) {

            //initializations
            bottomPhantom = N * N + 1;
            topPhantom = 0;
            this.site = new WeightedQuickUnionUF(N * N + 2); //+1 bottom, +1 top
            this.matrix = new int[N][N];
            //Phantom Nodes 0 and N^2 + 2


            //assign values for the grid. All values = indexes
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {

                    matrix[y][x] = 0;

                    //if top row, root to top phantom node
                    if ( y == 0 )
                        this.site.union( topPhantom, x + 1 );//need to skip 0


                    //if bot row, root bot phantom node to the row
                    else if ( y == N - 1 ) {
                        int position = y * matrix[y].length + x;
                        site.union( bottomPhantom, position );//is this correct?
                    }

                }//end of each individual loop
            }//end of construction double loop

        }//end of N > 0 conditional


        //error prevention: if N <= 0
        else if (N <= 0) {
            System.out.println("Error, invalid size: " + N + "\n");
        }//end of dummy check
    }





    public void open(int row, int col) {

        if ( matrixCoordinateValidate(row, col) ) {

            //if site closed
            if ( !isOpen(row, col) ) {
                matrix[col][row] = 1;
                System.out.println("-OPENED-\t" + col + ":" + row);

                //make pointing at site positions easier
                int sitePosition = col * matrix[col].length + row;
                int positionAbove = sitePosition - matrix[col].length;
                int positionBelow = sitePosition + matrix[col].length;
                int positionLeft = sitePosition - 1;
                int positionRight = sitePosition + 1;


                if ( isOpen(row, col - 1) ) { //if position above is 1
                    site.union(sitePosition, positionAbove);
                    System.out.print("-CONNECTED- " + col + ":" + row);
                    System.out.print(" " + (col - 1) + ":" + row + "\n");
                }

                if (isOpen(row, col + 1) ) { //if position below is 1
                    site.union(sitePosition, positionBelow);
                    System.out.print("-CONNECTED- " + col + ":" + row);
                    System.out.print(" " + (col + 1) + ":" + row + "\n");
                }


                if (isOpen(row - 1, col) ) { //if position left is 1
                    site.union(sitePosition, positionLeft);
                    System.out.print("-CONNECTED- " + col + ":" + row);
                    System.out.print(" " + col + ":" + (row - 1) + "\n");
                }


                if (isOpen(row + 1, col) ) { //if position right is 1
                    site.union(sitePosition, positionRight);
                    System.out.print("-CONNECTED- " + col + ":" + row);
                    System.out.print(" " + col + ":" + (row + 1) + "\n");
                }
                System.out.println(""); //DISPLAY NEWLINE AFTER EACH ACTION


                //check if it percolates after opening
                percolates();
            }//end of opening process


            //if site already open
            else if (isOpen(row, col) == true) {
                System.out.print("-REDUNDANT- ");
                System.out.print(col + ":" + row + "\n");
            }


        }//end of valid coordinates conditional

        else { //IF OUT OF VALID COORDINATES

            if ( col >= matrix.length || col < 0 ) { //if too far above or below
                System.out.println("-OUT OF BOUNDS- " + col + ":" + row);
            }

            else if ( row >= matrix[col].length || row < 0 ) { //if too left or right
                System.out.println("-OUT OF BOUNDS- " + row + ":" + col);
            }
        }//end of out of bounds conditional


    }





    public boolean isOpen(int row, int col) {
        // is the site (row, col) open?
        boolean open = false;

        if ( matrixCoordinateValidate(row, col) )
            if (matrix[col][row] == 1)
                open = true;


        return open;
    }




    public boolean isFull(int row, int col) {
        // is the site (row, col) full?
        return ( matrix[col][row] == 0 );
    }




    public int numberOfOpenSites() {
        // number of open sites
        int count = 0;

        for (int i = 0; i < matrix.length; i++ ) {
            for (int j = 0; j < matrix[i].length; j++ ) {

                //check all indexes if open
                if ( isOpen(j, i) )
                    count++;

            }//end of inter loop
        }//end of outer loop

        return count;
    }




    public boolean percolates() {
        // does the system percolate?
        boolean percolation = false;

        //is bottom phantom connected to top phantom?
        if (site.connected(bottomPhantom, topPhantom) ) {
            percolation = true;
            System.out.println("-PERCOLATES-"); //DISPLAY
        }

        return percolation;
    }




    public int[] getSite() {
        int[] auxillery = new int[bottomPhantom];

        for (int i = 0; i <= bottomPhantom; i++)
            auxillery[i] = site.find(i);


        return auxillery;
    }




    //INTERNALS - - - - - - - - -
    private boolean matrixCoordinateValidate(int row, int col) {
        boolean bool = true;

        try { if ( matrix[col][row] == 1 ); }
        catch (ArrayIndexOutOfBoundsException a) { bool = false; }

        return bool;
    }



    // - - - - - - MAIN - - - - - - -
    public static void main(String[] args) {
        // unit testing (suggested)

        /*
        Percolation localNetwork = new Percolation(3);


        System.out.println( localNetwork.numberOfOpenSites() ); //0

        localNetwork.open(0, 0);
        localNetwork.open(0, 1);
        localNetwork.open(1,1);
        localNetwork.open(1,2);

        localNetwork.percolates();


         */

    }
}