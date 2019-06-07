package com.mateus;

public class Memento
{
    Funcionario myObject;

    public Funcionario getState()
    {
        return myObject;
    }

    public void setState(Funcionario myObject)
    {
        this.myObject = myObject;
    }
}