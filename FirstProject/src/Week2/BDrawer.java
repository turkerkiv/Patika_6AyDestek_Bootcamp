package Week2;

public class BDrawer {
    public static void main(String[] args) {
        String[][] bDrawer = new String[6][4];

        for(int i = 0; i < bDrawer.length; i++)
        {
            for(int j = 0; j < bDrawer[i].length; j++)
            {
                if(i == 0 || i == 2 || i == 5 || j == 0 || j == 3) {
                    bDrawer[i][j] = "* ";
                }
                else {
                    bDrawer[i][j] = "  ";
                }
                if((i == 0 || i == 2 || i == 5) && j == 3 )
                {
                    bDrawer[i][j] = "  ";
                }
            }
        }

        for(String[] arr : bDrawer)
        {
            for(String str : arr)
            {
                System.out.print(str);
            }
            System.out.println();
        }

    }
}
