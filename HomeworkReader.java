/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PooCbTema1.InputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeworkReader {
    
    private BufferedReader bf;
    
    public HomeworkReader(String filename) {
        try {
            bf = new BufferedReader(new FileReader(new File(filename)));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeworkReader.class.getName()).log(Level
                    .SEVERE, null, ex);
        }
    }
    
    public Maze readData(){
        Maze result = null;
        
        try {  
            //Dimensiunea labirintului
            StringTokenizer st = new StringTokenizer(bf.readLine().trim());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            
            //Labirintul
            Cell[][] cells = new Cell[height][width];

            for (int i = 0; i < height; i++) {
                String[] str = bf.readLine().split("");
                for (int j = 0; j < width; ++j){
                    //creez instante ale fiecarui tip de celule
                    if (str[j].equals("I"))
                        cells[i][j] = new EntranceCell(str[j], i, j);
                    if (str[j].equals("O"))
                        cells[i][j] = new ExitCell(str[j], i, j);
                    if (str[j].equals("."))
                        cells[i][j] = new PathCell(str[j], i, j);
                    if (str[j].equals("#"))
                        cells[i][j] = new WallCell(str[j], i, j);
                }
            }
            result = new Maze(height, width, cells);
        } catch (IOException ex) {
            Logger.getLogger(HomeworkReader.class.getName()).log(Level
                    .SEVERE, null, ex);
        }
        return result;
    }
    
    public void close() {
        try {
            bf.close();
        } catch (IOException ex) {
            Logger.getLogger(HomeworkReader.class.getName()).log(Level
                    .SEVERE, null, ex);
        }
    }
}
