import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class freeFlow {
    //public static String[][] graph = new String[20][20];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t_width, t_height;
        System.out.println("t_width  :");
        t_width = scanner.nextInt();
        System.out.println("t_height  :");
        t_height = scanner.nextInt();
        System.out.println(t_width);
        System.out.println(t_height);
         String[][] graph = new String[t_height][t_width];
         boolean[][] check = new boolean[t_height][t_width];
        for (int i = 0; i < t_height; i++)
        {
            for (int j = 0; j < t_width; j++)
            {
                graph[i][j] = scanner.next();
                if(!graph[i][j].equals("0"))
                    check[i][j] = true;
                else
                    check[i][j] = false;
            }

        }
        //grouping(graph,t_height,t_width);
        Generate_FF_puzzle(graph,t_width,t_height,check);
        for (int i = 0; i < t_height; i++)
        {
            for (int j = 0; j < t_width; j++)
            {
                System.out.print(graph[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("--------------");
        System.out.println(graph);
    }
    public static void Generate_FF_puzzle(String[][] graph, int width, int height, boolean[][] check)
    {
       String[][] orgGraph = new  String[height + 1][width + 1];
       //first Solver
        for (int i = 0; i < height ; i++)
            for  (int j = 0; j < width ; j++)
                orgGraph [i][j] = graph[i][j];
       trueMoves(graph,width,height,check);
       boolean checked = true;
        for (int i = 0; i < height && checked; i++)
        {
            for  (int j = 0; j < width && checked; j++)
            {
                if ( !graph[i][j].equals(orgGraph[i][j]))
                    checked = false;
            }
        }
       if(!checked)
       {
           Generate_FF_puzzle(graph,width,height,check);
       }
       //second Solver
        for (int i = 0; i < height ; i++)
            for  (int j = 0; j < width ; j++)
                orgGraph [i][j] = graph[i][j];
        cornerMove(graph,width,height);
        boolean checked2 = true;
        for (int i = 0; i < height && checked2; i++)
        {
            for  (int j = 0; j < width && checked2; j++)
            {
                if ( !graph[i][j].equals(orgGraph[i][j]))
                    checked2 = false;
            }
        }
        if(!checked2)
        {
            Generate_FF_puzzle(graph,width,height,check);
        }
        //third Solver
        for (int i = 0; i < height ; i++)
            for  (int j = 0; j < width ; j++)
                orgGraph [i][j] = graph[i][j];
        grouping(graph,width,height);
        boolean checked3 = true;
        for (int i = 0; i < height && checked3; i++)
        {
            for  (int j = 0; j < width && checked3; j++)
            {
                if ( !graph[i][j].equals(orgGraph[i][j]))
                    checked3 = false;
            }
        }
        if(!checked3)
        {
            Generate_FF_puzzle(graph,width,height,check);
        }
        /*
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                System.out.print(graph[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("--------------");

         */

    }
    public static void trueMoves(String[][] graph, int width, int height, boolean[][] check)
    {
        String[][] newGraph = new String[height + 2][width + 2];
        String alpha = "qwertyuioplkjhgfdsazxcvbnm";
        for (int i = 0; i < height + 2; i++)
            for (int j = 0; j < width + 2; j++)
                newGraph[i][j] ="X";
        for (int i = 1; i < height + 1; i++)
            for (int j = 1; j < width + 1; j++)
                newGraph[i][j] = graph[i - 1][j - 1];
        for (int i  = 1; i < height + 1 ; i++ )
        {
            for (int j = 1; j < width + 1 ; j++)
            {
                int counter = 0;
                if (alpha.contains(newGraph[i][j]))
                {
                    for (int t  = 1; t < height + 1 ; t++ )
                    {
                        for (int k = 1; k < width + 1 ; k++)
                        {
                            if (newGraph[t][k].equals(newGraph[i][j]))
                                counter++;
                        }
                    }
                    if (counter == 1)
                        newGraph[i][j] = newGraph[i][j].toUpperCase();
                }
            }
        }
        for (int i = 1; i < height + 1; i++)
        {
            for (int j = 1; j < width + 1; j++)
            {
                if(alpha.contains(newGraph[i][j]))
                {
                        if( ( newGraph[i + 1][j].equals("0") || newGraph[i + 1][j].equals(newGraph[i][j]))  && (!newGraph[i - 1][j].equals("0") && !newGraph[i - 1][j].equals(newGraph[i][j])) &&
                        (!newGraph[i][j + 1].equals("0") && !newGraph[i][j + 1].equals(newGraph[i][j])) && (!newGraph[i][j - 1].equals("0") && !newGraph[i][j - 1].equals(newGraph[i][j])))
                        {
                            newGraph[i + 1][j] = newGraph[i][j];
                            newGraph[i][j] = newGraph[i][j].toUpperCase();
                        }

                        else if ( (!newGraph[i + 1][j].equals("0") && !newGraph[i + 1][j].equals(newGraph[i][j])) && (newGraph[i - 1][j].equals("0") || newGraph[i - 1][j].equals(newGraph[i][j])) &&
                         (!newGraph[i][j + 1].equals("0") && !newGraph[i][j + 1].equals(newGraph[i][j])) && (!newGraph[i][j - 1].equals("0") && !newGraph[i][j - 1].equals(newGraph[i][j])) )
                        {
                            newGraph[i - 1][j] = newGraph[i][j];
                            newGraph[i][j] = newGraph[i][j].toUpperCase();
                        }
                        else if ( (!newGraph[i + 1][j].equals("0") && !newGraph[i + 1][j].equals(newGraph[i][j])) && (!newGraph[i - 1][j].equals("0") && !newGraph[i - 1][j].equals(newGraph[i][j])) &&
                                (newGraph[i][j + 1].equals("0") || newGraph[i][j + 1].equals(newGraph[i][j] ))  && (!newGraph[i][j - 1].equals("0") && !newGraph[i][j - 1].equals(newGraph[i][j])))
                        {
                            newGraph[i][j + 1] = newGraph[i][j];
                            newGraph[i][j] = newGraph[i][j].toUpperCase();
                        }
                        else if ( (!newGraph[i + 1][j].equals("0") && !newGraph[i + 1][j].equals(newGraph[i][j])) && (!newGraph[i - 1][j].equals("0") && !newGraph[i - 1][j].equals(newGraph[i][j])) &&
                                (newGraph[i][j - 1].equals("0") || newGraph[i][j - 1].equals(newGraph[i][j] ))  && (!newGraph[i][j + 1].equals("0") && !newGraph[i][j + 1].equals(newGraph[i][j])))
                        {
                            newGraph[i][j - 1] = newGraph[i][j];
                            newGraph[i][j] = newGraph[i][j].toUpperCase();
                        }
                        ///
                    for (int m = 1; m < height + 1 ; m++ )
                    {
                        for (int n = 1; n < width + 1 ; n++)
                        {
                            int counter = 0;
                            if (alpha.contains(newGraph[m][n]))
                            {
                                for (int t  = 1; t < height + 1 ; t++ )
                                {
                                    for (int k = 1; k < width + 1 ; k++)
                                    {
                                        if (newGraph[t][k].equals(newGraph[m][n]))
                                            counter++;
                                    }
                                }
                                if (counter == 1)
                                    newGraph[m][n] = newGraph[m][n].toUpperCase();
                            }
                        }
                    }
                  }
                }
            }

        for (int i = 1; i < height + 1; i++)
        {
            for (int j = 1; j < width + 1; j++)
            {
                graph[i - 1][j - 1] = newGraph[i][j];
            }
        }


       /*
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                System.out.print(check[i][j] + "   ");
            }
            System.out.println("");
        }
        */
       // System.out.println("--------------");
    }

   public static void wertyuioplkjhgfdsazxcvbnm";
        if (lowerCase.contains(graph[height - 2][0]) && graph[height - 1][0].equals("0") ){
            graph[height - 1][0] = graph[height - 2][0];
            graph[height - 2][0] = graph[height - 2][0].toUpperCase();
        }
        else if (lowerCase.contains(graph[height - 1][1]) && graph[height - 1][0].equals("0") ){
            graph[height - 1][0] = graph[height - 1][1];
            graph[height - 1][1] = graph[height - 1][1].toUpperCase();
        }
        else if (lowerCase.contains(graph[1][0]) && graph[0][0].equals("0") ){
            graph[0][0] = graph[1][0];cornerMove (String[][] graph, int width, int height){
                String lowerCase = "q
            graph[1][0] = graph[1][0].toUpperCase();
        }
        else if (lowerCase.contains(graph[0][1]) && graph[0][0].equals("0") ){
            graph[0][0] = graph[0][1];
            graph[0][1] =  graph[0][1].toUpperCase();
        }
        else if (lowerCase.contains(graph[0][height - 2]) && graph[0][height - 1].equals("0") ){
            graph[0][height - 1] = graph[0][height - 2];
            graph[0][height - 2] = graph[0][height - 2].toUpperCase();
        }
        else if (lowerCase.contains(graph[1][height - 1]) && graph[0][height - 1].equals("0")){
            graph[0][height - 1] = graph[1][height - 1];
            graph[1][height - 1] =  graph[1][height - 1].toUpperCase();
        }
        else if (lowerCase.contains(graph[height - 2][height - 1]) && graph[height - 1][height - 1].equals("0") ){
            graph[height - 1][height - 1] = graph[height - 2][height - 1];
            graph[height - 2][height - 1] = graph[height - 2][height - 1].toUpperCase();
        }
        else if (lowerCase.contains(graph[height - 1][height - 2]) && graph[height - 1][height - 2].equals("0") ){
            graph[height - 1][height - 1] = graph[height - 1][height - 2];
            graph[height - 1][height - 2] = graph[height - 1][height - 2].toUpperCase();
        }
        /*
       for (int i = 0; i < height; i++)
       {
           for (int j = 0; j < width; j++)
           {
               System.out.print(graph[i][j] + "   ");
           }
           System.out.println("");
       }
       System.out.println("--------------");

         */
    }
    public static void grouping (String[][] graph, int width, int height) {
        int[][] newGraph = new int[height][width];
        int[][] oldGraph = new int[height][width];
        int counter = 1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (graph[i][j].equals("0")) {
                    //System.out.println(Integer.toString(counter) + "         " + graph[i][j] + "         " + i + "  " + j + "   ");
                    newGraph[i][j] = counter;
                    //System.out.println(Integer.toString(counter) + "         " + graph[i][j] + "         " + i + "  " + j + "   " + newGraph[i][j]);
                    counter++;
                } else {
                    newGraph[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                oldGraph[i][j] = newGraph[i][j];
                boolean checked = true;
                while (checked) {
                    for (int i = 0; i < height; i++)
                    {
                        for (int j = 0; j < width; j++)
                        {
                            if (i > 0){
                                if(newGraph[i - 1][j] != 0 && newGraph[i - 1][j] < newGraph[i][j]){
                                    newGraph[i][j] = newGraph[i - 1][j];
                                }
                            }
                            if (i < height - 1) {
                                if(newGraph[i + 1][j] != 0 && newGraph[i + 1][j] < newGraph[i][j]){
                                    newGraph[i][j] = newGraph[i + 1][j];
                                }
                            }
                            if (j > 0){
                                if(newGraph[i][j - 1] != 0 && newGraph[i][j - 1] < newGraph[i][j]){
                                    newGraph[i][j] = newGraph[i][j - 1];
                                }
                            }
                            if (j < width - 1) {
                                if(newGraph[i][j + 1] != 0 && newGraph[i][j + 1] < newGraph[i][j]){
                                    newGraph[i][j] = newGraph[i][j + 1];
                                }
                            }
                        }
                    }
                    /*
                    for (int i = 0; i < height; i++)
                    {
                        for (int j = 0; j < width; j++)
                        {
                            System.out.print(newGraph[i][j] + "   ");
                        }
                        System.out.println();
                    }

                     */
                   // System.out.println("------------------ new" );
                    /*
                    for (int i = 0; i < height; i++)
                    {
                        for (int j = 0; j < width; j++)
                        {
                            System.out.print(oldGraph[i][j] + "   ");
                        }
                        System.out.println();
                    }

                     */
                   // System.out.println("------------------ old");
                    boolean sameCheck = true;
                    for (int i = 0; i < height && sameCheck; i++){
                        for (int j = 0; j < width && sameCheck; j++){
                            if (oldGraph[i][j] != newGraph[i][j]){
                                sameCheck = false;
                               // System.out.println(oldGraph[i][j]+"   "+newGraph[i][j]);
                            }

                        }
                    }
                    //System.out.println(sameCheck);
                    if (sameCheck)
                        checked = false;
                        for (int i = 0; i < height ; i++){
                            for (int j = 0; j < width ; j++){
                                oldGraph[i][j] = newGraph[i][j];
                            }
                        }
                }

        ArrayList<Integer> differentColors = new ArrayList<>();
        for (int i = 0; i < height ; i++){
            for (int j = 0; j < width ; j++){
                if (!differentColors.contains(newGraph[i][j]) && newGraph[i][j] != 0){
                    differentColors.add(newGraph[i][j]);
                }

            }
        }
        String ends = "qwertyuioplkjhgfdsazxcvbnm";
       for (int color = 0; color < differentColors.size(); color++){
           String[][] tempGraph = new String[height][width];
           for (int i = 0; i < height ; i++){
               for (int j = 0; j < width ; j++){
                   tempGraph[i][j] = graph[i][j];
               }
           }
           ArrayList<String> endColors = new ArrayList<>();
           for (int i = 0; i < height; i++){
               for (int j = 0; j < width; j++){
                   if (newGraph[i][j] == differentColors.get(color)){
                       if (i > 0){
                           if(ends.contains(tempGraph[i - 1][j])){
                               endColors.add(tempGraph[i - 1][j]);
                               tempGraph[i - 1][j] = "0";
                           }
                       }
                       if (i < height - 1) {
                           if(ends.contains(tempGraph[i + 1][j])){
                              endColors.add(tempGraph[i + 1][j]);
                               tempGraph[i + 1][j] = "0";
                           }
                       }
                       if (j > 0){
                           if(ends.contains(tempGraph[i][j - 1])){
                               endColors.add(tempGraph[i][j - 1]);
                               tempGraph[i][j - 1] = "0";
                           }
                       }
                       if (j < width - 1) {
                           if(ends.contains(tempGraph[i][j + 1])){
                              endColors.add(tempGraph[i][j + 1]);
                               tempGraph[i][j + 1] = "0";
                           }
                       }

                   }

               }
           }
           //System.out.println("end"+endColors);
           ArrayList<String> two_ends = new ArrayList<>();
           for (int i = 0 ; i < endColors.size(); i++){
               for (int j = 0; j < endColors.size(); j++ ){
                   if (j != i && endColors.get(i).equals(endColors.get(j))){
                       two_ends.add(endColors.get(i));
                       String co = endColors.get(i);
                       endColors.remove(co);
                       //System.out.println(endColors);
                   }
               }
           }
          // System.out.println("two" + two_ends);
           if (two_ends.size() == 1){
              // System.out.println(two_ends.size());
               for (int i = 0 ; i < height; i++){
                   for (int j = 0; j < width; j++ ){
                       //System.out.println(differentColors.get(color));
                       if (newGraph[i][j] == differentColors.get(color))
                           graph[i][j] = two_ends.get(0);
                   }
               }
           }
           /*
           for (int i = 0 ; i < height; i++){
               for (int j = 0; j < width; j++ ){
                   if (graph[i][j] == two_ends.get(0))
                       graph[i][j] = graph[i][j].toUpperCase();
               }
           }

            */
       }
    }/*


    void bruteForce(String[][] graph, int width, int height){
        String ends = "qwertyuioplkjhgfdsazxcvbnm";
    for (int i = 0; i < height; i++){
        for (int j = 0; j < width; j++)
        {
            if (ends.contains(graph[i][j])){
                if (i > 0){
                    if(graph[i - 1][j].equals(graph[i][j])){
                        graph[i - 1][j] = graph[i][j];
                        graph[i][j] = graph[i][j].toUpperCase();
                    }
                }
               if (i < height - 1) {
                    if(graph[i + 1][j].equals(graph[i][j])){
                        graph[i + 1][j] = graph[i][j];
                        graph[i][j] = graph[i][j].toUpperCase();
                    }
                }
               if (j > 0){
                    if(graph[i][j - 1].equals(graph[i][j])){
                        graph[i][j - 1] = graph[i][j];
                        graph[i][j] = graph[i][j].toUpperCase();
                    }
                }
                if (j < width - 1) {
                    if(graph[i][j + 1].equals(graph[i][j])){
                        graph[i][j + 1] = graph[i][j];
                        graph[i][j] = graph[i][j].toUpperCase();
                    }
                }
            }
        }
    }
        //if (solved(graph,width, height)){
           // return;
       // }
          //  else
        //{

       // }

    }
    */
/*
    ArrayList<String[][]> allPossibleBoards (String[][] graph, int height, int width){
        String ends = "qwertyuioplkjhgfdsazxcvbnm";
        ArrayList<String[][]> boards = new ArrayList<>();
        for (int i = 0; i < height; i++){
            for (int j = 0;  j < width; j++) {
                String[][] temp = new  String[height][width];
                if (i > 0) {
                    if (graph[i - 1][j].equals("0") ){
                        for (int t = 0; t < height; t++)
                            for (int k = 0;  k < width; k++)
                                temp[t][k] = graph[t][k];
                        temp[i - 1][j] = graph[i][j];
                        temp[i][j] = temp[i][j].toUpperCase();
                        boards.add(temp);
                    }
                }
                if (i < height - 1) {
                    if (graph[i + 1][j].equals("0") ){
                        for (int t = 0; t < height; t++)
                            for (int k = 0;  k < width; k++)
                                temp[t][k] = graph[t][k];
                        temp[i + 1][j] = graph[i][j];
                        temp[i][j] = temp[i][j].toUpperCase();
                        boards.add(temp);
                    }
                }
                if (j > 0) {
                    if (graph[i][j - 1].equals("0") ){
                        for (int t = 0; t < height; t++)
                            for (int k = 0;  k < width; k++)
                                temp[t][k] = graph[t][k];
                        temp[i][j - 1] = graph[i][j];
                        temp[i][j] = temp[i][j].toUpperCase();
                        boards.add(temp);
                    }
                }
                if (j < width - 1) {
                    if (graph[i][j + 1].equals("0") ){
                        for (int t = 0; t < height; t++)
                            for (int k = 0;  k < width; k++)
                                temp[t][k] = graph[t][k];
                        temp[i][j + 1] = graph[i][j];
                        temp[i][j] = temp[i][j].toUpperCase();
                        boards.add(temp);
                    }
                }

            }
        }
        return boards;
    }
    boolean solved (String[][] graph, int height, int width){
        String ends = "qwertyuioplkjhgfdsazxcvbnm";
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++)
                if (graph[i][j].equals("0"))
                    return  false;
        }

    }
*/

}

