package com.mateus;
import java.util.*;

class Caretaker {
    private ArrayList<Memento> mementos;
    
    public Caretaker() {
    	mementos = new ArrayList<Memento>();
    }

    public void addMemento(Memento m) {
        mementos.add(m);
    }

    public Memento getLastState() {
        if (mementos.size() <= 0) {
            return new Memento(null);
        }
        Memento estadoSalvo = mementos.get(mementos.size() - 1);
        mementos.remove(mementos.size() - 1);
        return estadoSalvo;
    }
}