/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author guest1Day
 */
abstract public class Human {
    protected ArrayList<Integer> myCards = new ArrayList<Integer>();
    abstract protected int open();
    abstract protected void setCard(ArrayList<Integer> list);
    abstract protected boolean checkSum();
    
}