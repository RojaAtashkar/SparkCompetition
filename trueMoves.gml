graph = argument0;
width = argument1;
height= argument2;
ends = "qwertyuioplkjhgfdsazxcvbnm";
for (var i = 0; i < height + 2; i++)
            for (var j = 0; j < width + 2; j++)
                newGraph[i,j] ="X";
        for (var i = 1; i < height + 1; i++)
            for (var j = 1; j < width + 1; j++)
                newGraph[i,j] = graph[i - 1,j - 1];
      for (var i  = 1; i < height + 1 ; i++ )
        {
            for (var j = 1; j < width + 1 ; j++)
            {
                counter = 0;
                if (string_pos(newGraph[i,j],ends) != 0)
                {
                    for (var t  = 1; t < height + 1 ; t++ )
                    {
                        for (var k = 1; k < width + 1 ; k++)
                        {
                            if (newGraph[t,k] == newGraph[i,j])
                                counter++;
                        }
                    }
                    if (counter == 1)
                        newGraph[i,j] =string_upper(newGraph[i,j]);
                }
            }
        }
        ///
        ////
        ends = "qwertyuioplkjhgfdsazxcvbnm";
         for (var i = 1; i < height + 1; i++)
        {
            for (var j = 1; j < width + 1; j++)
            {
                if(string_pos(newGraph[i,j], ends) != 0)
                {
                        
                        if( ( newGraph[i + 1,j]=="0" || newGraph[i + 1, j] == newGraph[i, j])  && (newGraph[i - 1,j] != "0" && newGraph[i - 1, j] != newGraph[i,j]) &&
                        (newGraph[i,j + 1]!= "0" && newGraph[i, j + 1] != newGraph[i,j]) && (newGraph[i, j - 1] != "0" && newGraph[i, j - 1] != newGraph[i, j]))
                        {
                            newGraph[i + 1, j] = newGraph[i, j];
                            newGraph[i, j] = string_upper(newGraph[i,j]);
                        }

                        else if ( (newGraph[i + 1, j] != "0"  && newGraph[i + 1, j] != newGraph[i, j]) && (newGraph[i - 1, j]=="0" || newGraph[i - 1, j] == newGraph[i, j] ) &&
                         (newGraph[i, j + 1] != "0" && newGraph[i, j + 1] != newGraph[i, j]) && (newGraph[i, j - 1] != ("0") && newGraph[i, j - 1] != newGraph[i, j]) )
                        {
                            newGraph[i - 1, j] = newGraph[i, j];
                            newGraph[i, j] = string_upper(newGraph[i,j]);
                        }
                        else if ( (newGraph[i + 1, j] != "0" && newGraph[i + 1, j] != newGraph[i, j]) && (newGraph[i - 1, j] != "0"  && newGraph[i - 1, j] != newGraph[i, j]) &&
                                (newGraph[i, j + 1] == "0" || newGraph[i, j + 1] == newGraph[i, j] )  && (newGraph[i, j - 1] != "0" && newGraph[i, j - 1]!= newGraph[i, j]))
                        {
                            newGraph[i, j + 1] = newGraph[i, j];
                            newGraph[i, j] = string_upper(newGraph[i,j]);
                        }
                        else if ( (newGraph[i + 1, j] != "0" && newGraph[i + 1, j] != newGraph[i, j]) && (newGraph[i - 1, j] != "0" && newGraph[i - 1,j] != newGraph[i, j]) &&
                                (newGraph[i, j - 1]== "0" || newGraph[i, j - 1]== newGraph[i, j])  && (newGraph[i, j + 1] != "0" && newGraph[i, j + 1] != newGraph[i,j]))
                        {
                            newGraph[i, j - 1] = newGraph[i, j];
                            newGraph[i, j] = string_upper(newGraph[i,j]);
                        }
                    for (var m = 1; m < height + 1 ; m++ )
                    {
                        for (var n = 1; n < width + 1 ; n++)
                        {
                            var counter = 0;
                            if (string_pos(newGraph[m,n], ends) != 0 )
                            {
                                for (var t  = 1; t < height + 1 ; t++ )
                                {
                                    for (var k = 1; k < width + 1 ; k++)
                                    {
                                        if (newGraph[t, k] == newGraph[m, n])
                                            counter++;
                                    }
                                }
                                if (counter == 1)
                                    newGraph[m, n] = string_upper(newGraph[i,j]);
                            }
                        }
                    }
                  }
                }
            }
              for (var i = 1; i < height + 1; i++)
        {
            for (var j = 1; j < width + 1; j++)
            {
                graph[i - 1,j - 1] = newGraph[i,j];
            }
        }
        return graph;
