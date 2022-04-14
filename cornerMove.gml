graph = argument0;
width = argument1;
height= argument2;

        ends = "qwertyuioplkjhgfdsazxcvbnm";
        if (string_pos(graph[height - 2, 0],ends) != 0 && graph[height - 1, 0]=="0" ){
            graph[height - 1, 0] = graph[height - 2, 0];
            graph[height - 2, 0] =  string_upper(graph[height - 2, 0]);
        }
        else if ( string_pos(graph[height - 1, 1],ends) != 0 && graph[height - 1, 0] == "0" ){
            graph[height - 1, 0] = graph[height - 1,1];
            graph[height - 1, 1] = string_upper(graph[height - 1,1]);
        }
        else if (string_pos(graph[1, 0], ends) != 0 && graph[0, 0] == "0" ){
            graph[0, 0] = graph[1, 0];
            graph[1, 0] = string_upper(graph[1,0]);
        }
        else if (string_pos(graph[0, 1], ends) && graph[0,0 ]== "0" ){
            graph[0, 0] = graph[0, 1];
            graph[0,1] =  string_upper(graph[0, 1]);
        }
        else if (string_pos(graph[0,height - 2] , ends)!= 0 && graph[0,height - 1]=="0" ){
            graph[0,height - 1] = graph[0,height - 2];
            graph[0,height - 2] = string_upper(graph[0,height - 2]);
        }
        else if (string_pos(graph[1,height - 1], ends)!= 0 && graph[0, height - 1]=="0"){
            graph[0, height - 1] = graph[1, height - 1];
            graph[1, height - 1] =  string_upper(graph[1, height - 1]);
        }
        else if (string_pos(graph[height - 2,height - 1], ends)!=  0  && graph[height - 1, height - 1] =="0" ){
            graph[height - 1, height - 1] = graph[height - 2, height - 1];
            graph[height - 2, height - 1] = string_upper(graph[height - 2, height - 1]);
        }
        else if (string_pos(graph[height - 1, height - 2], ends)!= 0  && graph[height - 1, height - 2]== "0" ){
            graph[height - 1, height - 1] = graph[height - 1, height - 2];
            graph[height - 1, height - 2] = string_upper(graph[height - 1, height - 2]);
        }
       return graph;
