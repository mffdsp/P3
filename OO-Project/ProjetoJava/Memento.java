package com.mateus;

public class Memento
{
    String myObject;

    public String getState()
    {
        return myObject;
    }

    public Memento(String myObject)
    {
        this.myObject = myObject;
    }
}


