graph = argument0;
width = argument1;
height= argument2;
 for (var i = 0; i < height ; i++)
            for  (var j = 0; j < width ; j++)
                orgGraph [i,j] = graph[i,j];
  graph = trueMoves(graph,width,height);
        checked = true;
        for (var i = 0; i < height && checked; i++)
        {
            for  (var j = 0; j < width && checked; j++)
            {
                if ( graph[i,j] != orgGraph[i,j])
                    checked = false;
            }
        }
       if(!checked)
       {
           freeFlowSolver(graph,width,height);
       }
       ///2
       for (var i = 0; i < height ; i++)
            for  (var j = 0; j < width ; j++)
                orgGraph [i,j] = graph[i,j];
  graph = cornerMove(graph,width,height);
        checked1 = true;
        for (var i = 0; i < height && checked1; i++)
        {
            for  (var j = 0; j < width && checked1; j++)
            {
                if ( graph[i,j] != orgGraph[i,j])
                    checked1 = false;
            }
        }
       if(!checked1)
       {
           freeFlowSolver(graph,width,height);
       }
       show_debug_message("****************************************");
     for ( var i = 0; i < height; i++){
graphLines[i] = "";
for ( var j = 0; j < width; j++){
graphLines[i] += graph[i,j]
 }
 show_debug_message(graphLines[i] + "    ");
}
        
