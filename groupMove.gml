graph = argument0;
width = argument1;
height= argument2;
/*

        var counter = 1;
        for (var i = 0; i < height; i++) {
            for (var j = 0; j < width; j++) {
                if (graph[i, j] == "0") {
                    //System.out.println(Integer.toString(counter) + "         " + graph[i][j] + "         " + i + "  " + j + "   ");
                    newGraph[i, j] = counter;
                    //System.out.println(Integer.toString(counter) + "         " + graph[i][j] + "         " + i + "  " + j + "   " + newGraph[i][j]);
                    counter++;
                } else {
                    newGraph[i, j] = 0;
                }
            }
        }
        for (var i = 0; i < height; i++)
            for (var j = 0; j < width; j++)
                oldGraph[i, j] = newGraph[i, j];
               checked = true;
                while (checked) {
                    for (var i = 0; i < height; i++)
                    {
                        for (var j = 0; j < width; j++)
                        {
                            if (i > 0){
                                if(newGraph[i - 1, j] != 0 && newGraph[i - 1, j] < newGraph[i, j]){
                                    newGraph[i, j] = newGraph[i - 1, j];
                                }
                            }
                            if (i < height - 1) {
                                if(newGraph[i + 1, j] != 0 && newGraph[i + 1, j] < newGraph[i, j]){
                                    newGraph[i, j] = newGraph[i + 1, j];
                                }
                            }
                            if (j > 0){
                                if(newGraph[i, j - 1] != 0 && newGraph[i, j - 1] < newGraph[i, j]){
                                    newGraph[i, j] = newGraph[i, j - 1];
                                }
                            }
                            if (j < width - 1) {
                                if(newGraph[i, j + 1] != 0 && newGraph[i, j + 1] < newGraph[i, j]){
                                    newGraph[i, j] = newGraph[i, j + 1];
                                }
                            }
                        }
                    }
                    
                  
                     sameCheck = true;
                    for (var i = 0; i < height && sameCheck; i++){
                        for (var j = 0; j < width && sameCheck; j++){
                            if (oldGraph[i, j] != newGraph[i, j]){
                                sameCheck = false;
                               // System.out.println(oldGraph[i][j]+"   "+newGraph[i][j]);
                            }

                        }
                    }
                    //System.out.println(sameCheck);
                    if (sameCheck)
                        checked = false;
                        for (var i = 0; i < height ; i++){
                            for (var j = 0; j < width ; j++){
                                oldGraph[i, j] = newGraph[i ,j];
                            }
                        }
                }

         differentColors = ds_list_create()
        for (var i = 0; i < height ; i++){
            for (var j = 0; j < width ; j++){
                if (ds_list_find_index(differentColors,newGraph[i, j]) == -1&& newGraph[i,j] != 0){
                    ds_list_add( differentColors,newGraph[i,j]);
                }

            }
        }
         ends = "qwertyuioplkjhgfdsazxcvbnm";
       for (var color = 0; color < differentColors.size(); color++){
           for (var i = 0; i < height ; i++){
               for (var j = 0; j < width ; j++){
                   tempGraph[i, j] = graph[i, j];
               }
           }
            endColors = ds_list_create()
           for (var i = 0; i < height; i++){
               for (var j = 0; j < width; j++){
                   if (newGraph[i, j] == ds_list_find_value(differentColors,color){
                       if (i > 0){
                           if(ds_list_find_value(ends,tempGraph[i - 1,j])){
                              ds_list_add(endColors,tempGraph[i - 1, j]);
                               tempGraph[i - 1,j] = "0";
                           }
                       }
                       if (i < height - 1) {
                           if(ends.contains(tempGraph[i + 1][j])){
                              endColors.add(tempGraph[i + 1][j]);
                               tempGraph[i + 1,[j] = "0";
                           }
                       }
                       if (j > 0){
                           if(ends.contains(tempGraph[i][j - 1])){
                               endColors.add(tempGraph[i][j - 1]);
                               tempGraph[i,j - 1] = "0";
                           }
                       }
                       if (j < width - 1) {
                           if(ends.contains(tempGraph[i][j + 1])){
                              endColors.add(tempGraph[i][j + 1]);
                               tempGraph[i,j + 1] = "0";
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

            
       }
    }
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
/*
