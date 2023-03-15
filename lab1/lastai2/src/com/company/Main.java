package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Random;


public class Main {

    public static void main(String[] args) throws IOException {

        int numberofnodes=0;

        String[] numbers;

        try {
            File myObj = new File("test_xlarge.dag");
            Scanner myReader = new Scanner(myObj);
            System.out.println(myObj.getAbsolutePath());

            int counter=0;

            numberofnodes =Integer.parseInt(myReader.nextLine());
            Double [] cost =new Double[numberofnodes];
            int [][] neighboors1 =new int[numberofnodes][numberofnodes];

            //Get weights
            for (int i = 0; i <numberofnodes;i++) {
                cost[i]=Double.parseDouble(myReader.nextLine());
            }

            //Get neighboors
            for (int i = 0; i <numberofnodes ; i++) {
                String input = myReader.nextLine();    // get the entire line after the prompt
                numbers = input.split(" ");
                for (int j = 0; j <numbers.length ; j++) {
                    neighboors1[i][j]=Integer.parseInt(numbers[j]);
                }
            }

            myReader.close();


            Node[] arr = new Node[numberofnodes];
            double first=cost[0];
            Node start =new Node("S",0,0);
            Node finish =new Node("F",0,0);


            int constant=0;

            for (int i = 0; i <numberofnodes ; i++) {
                arr[i]=new Node("A",0,0);

            }


            start.addNeighbor(new Edge(arr[0],cost[0]));





            for (int i = 0; i <arr.length; i++) {
                for (int j = 0; j < neighboors1[i].length; j++) {

                    if(neighboors1[i][j]==0)
                    {
                        break;
                    }
                    else{
                        if (neighboors1[i][j]==-1)
                        {
                            arr[i].addNeighbor(new Edge(finish, 0));
                        }
                        else {
                            constant = (neighboors1[i][j]);
                      //      System.out.println("Arr[" + i + "]" + ".addNeighbor(new Edge(arr[" + constant + "]," + cost[constant] + ")");
                            arr[i].addNeighbor(new Edge(arr[constant], cost[constant]));
                        }
                    }
                }
              //  System.out.println(); //change line on console as row comes to end in the matrix.
            }
            AStarSearch search = new AStarSearch(start,finish);
            search.run();
            search.printSolutionPath();

        }

        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
