/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 0186779
 */
public class Coordenadas implements Comparable<Coordenadas>{
    public int x, y;

    public Coordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Coordenadas right(){
        return new Coordenadas(x+1, y);
    }
    public Coordenadas left(){
        return new Coordenadas(x-1, y);
    }
    public Coordenadas top(){
        return new Coordenadas(x, y-1);
    }
    public Coordenadas bot(){
        return new Coordenadas(x, y+1);
    }

    @Override
    public boolean equals(Object obj) {
        Coordenadas coord = (Coordenadas) obj;
        return coord.x == this.x && coord.y == this.y;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.x;
        hash = 53 * hash + this.y;
        return hash;
    }

    
    @Override
    public int compareTo(Coordenadas coord) {
        if(this.y < coord.y) return -1;
        if(this.y > coord.y) return +1;
        if(this.x < coord.x) return -1;
        if(this.x > coord.x) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return x + " " + y; 
    }
    
    
    
}
