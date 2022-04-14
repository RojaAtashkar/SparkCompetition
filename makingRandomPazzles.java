import java.util.Random;
import java.util.Scanner;

public class makingRandomPazzles {
    public static int [] endPointsWidth = new int[100];
    public static int [] endPointsHeight = new int[100];
    public static int [] startPointsWidth = new int[100];
    public static int [] startPointsHeight = new int[100];
    public static void main(String[] args) {
        int t_width, t_height, routes;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        t_width = scanner.nextInt();
        t_height = scanner.nextInt();
        routes = scanner.nextInt();
        System.out.println(routes);
        int[][] puzzle = new  int[t_height][t_width];
        /*
        int [] endPointsWidth = new int[routes];
        int [] endPointsHeight = new int[routes];
        int [] startPointsWidth = new int[routes];
        int [] startPointsHeight = new int[routes];
         */
        int [] length = new int[routes];
        int counter = 0;
        int moves = Math.abs(random.nextInt(100))+10000;
        int l = (t_height * t_width) / routes;
        int tempX = 0,tempY = 0;
        int s = 1;
        for (int i = 0 ; i < t_height; i++)
            for (int j = 0 ; j < t_width; j++)
                puzzle[i][j] = -1;
        for(int i = 0; i < routes - 1; i++)
            length[i] = l;
        length[routes - 1] = (t_height * t_width) - routes * l;
        for (int i = 0; i < routes - 1; i++)
        {
            int temp = 0;
            startPointsHeight[counter] = tempY;
            startPointsWidth[counter] = tempX;
            while(temp < l )
            {
                puzzle[tempY][tempX] = counter;
                endPointsHeight[counter] = tempY;
                endPointsWidth[counter] = tempX;
                temp++;
                tempY += s;
                if(tempY > t_height - 1 )
                {
                    tempX++;
                    s *= -1;
                    tempY = t_height - 1;

                }
                if(tempY < 0)
                {
                    tempX++;
                    s *= -1;
                    tempY = 0;
                }
            }
            counter++;
        }
    for (int i = tempX; i  < t_width; i++)
        for (int j = 0; j < t_height; j++)
        {
            if ( puzzle[j][i] == -1)
                puzzle[j][i] = counter;
        }
        System.out.println(1);
        for (int i = 0; i < t_height ; i++){
            for (int j = 0; j < t_width; j ++)
                System.out.print(puzzle[i][j]+ "   ");
            System.out.println(" ");
        }
        for (int i = 0; i < t_height ; i++){
                System.out.println(i + "start  " +startPointsWidth[i] +"  "+startPointsHeight[i]+"   end      " + endPointsWidth[i]+"  " +endPointsHeight[i]);
            }
/*
        int[][] newPuzzle = new int [t_height + 2][t_width + 2];
        for (int i = 0; i < t_height + 2; i++)
            for (int j = 0; j < t_width + 2; j++)
                newPuzzle[i][j] = -1;
        for (int i = 1; i < t_height + 1; i++)
            for (int j = 1; j < t_width + 1; j++)
                newPuzzle[i][j] = puzzle[i - 1][j - 1];
        for (int i = 0; i < t_height+2 ; i++){
            for (int j = 0; j < t_width+2; j ++)
                System.out.print(newPuzzle[i][j]+ "   ");
            System.out.println(" ");
        }
 */
          for( int k = 0; k < moves; k++)
          {
              int randomIndex = Math.abs(random.nextInt(routes));
              System.out.println("randomIndex    " + randomIndex);
              int possiblePath = 0;
             System.out.println(0);
              if(length[randomIndex] > 3){
                  //System.out.println(1);
                  if( startPointsWidth[randomIndex] + 1 < t_width && find(startPointsWidth[randomIndex] + 1, startPointsHeight[randomIndex],routes))
                  {
                      //System.out.println(2);
                      puzzle[startPointsHeight[randomIndex]][startPointsWidth[randomIndex] + 1] = puzzle[startPointsHeight[randomIndex]][startPointsWidth[randomIndex]];
                  }
                   if( startPointsWidth[randomIndex] - 1 > -1 && find(startPointsWidth[randomIndex] - 1, startPointsHeight[randomIndex],routes))
                  {
                      //System.out.println(3);
                      puzzle[startPointsHeight[randomIndex]][startPointsWidth[randomIndex] - 1] = puzzle[startPointsHeight[randomIndex]][startPointsWidth[randomIndex]];
                  }
                  if( startPointsHeight[randomIndex] + 1 < t_height && find(startPointsWidth[randomIndex] , startPointsHeight[randomIndex] + 1,routes))
                  {
                     // System.out.println(4);
                      puzzle[startPointsHeight[randomIndex] + 1][startPointsWidth[randomIndex]] = puzzle[startPointsHeight[randomIndex]][startPointsWidth[randomIndex]];
                  }
                   if( startPointsHeight[randomIndex] - 1 > 0 && find(startPointsWidth[randomIndex], startPointsHeight[randomIndex] - 1,routes))
                  {
                      //System.out.println(5);
                      puzzle[startPointsHeight[randomIndex] - 1][startPointsWidth[randomIndex]] =puzzle[startPointsHeight[randomIndex]][startPointsWidth[randomIndex]];
                  }

                  for (int i = 0; i < t_height ; i++){
                      for (int j = 0; j < t_width; j ++)
                          System.out.print(puzzle[i][j]+ "   ");
                      System.out.println(" ");
                  }
              }
          }
        for (int i = 0; i < t_height ; i++){
            for (int j = 0; j < t_width; j ++)
                System.out.print(puzzle[i][j]+ "   ");
            System.out.println(" ");
        }
    }
    public static boolean  find (int w, int h, int routes)
    {
        boolean check = false;
        int c = -1;
        for (int i = 0; i < routes && !check; i ++)
        {
            if( w == startPointsWidth[i])
            {
                if ( h == startPointsHeight[i])
                {
                    c++;
                    check = true;
                }
            }
            else  if( w == endPointsWidth[i])
            {
                if ( h == endPointsHeight[i])
                {
                    c++;
                    check = true;
                }
            }
        }
        System.out.println(check);
        return check;
    }


}

