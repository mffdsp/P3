package com.mateus;

public abstract class Command{
    Funcionario myObject;
    Memento memento;

    public abstract void execute();

    public abstract void unExecute();
}