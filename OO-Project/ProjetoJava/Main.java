package com.mateus;
import java.util.*;



public class Main {
	
	private int undoRedoPointer = -1;
    private Stack<Command> commandStack = new Stack<>();

    private void insertCommand()
    {
        deleteElementsAfterPointer(undoRedoPointer);
        Command command =
                new InsertCharacterCommand();
        command.execute();
        commandStack.push(command);
        undoRedoPointer++;
    }

    private void deleteElementsAfterPointer(int undoRedoPointer)
    {
        if(commandStack.size()<1)return;
        for(int i = commandStack.size()-1; i > undoRedoPointer; i--)
        {
            commandStack.remove(i);
        }
    }

    private void undo()
    {
        Command command = commandStack.get(undoRedoPointer);
        command.unExecute();
        undoRedoPointer--;
    }

    private void redo()
    {
        if(undoRedoPointer == commandStack.size() - 1)
            return;
        undoRedoPointer++;
        Command command = commandStack.get(undoRedoPointer);
        command.execute();
    }
	
	public static void main( String[] args) {
		
		System.out.println("Oiii");
		Funcionario mt = new Horista();
		mt.setNome("Mateusinhooooo");
		System.out.println("NOME : " + mt.getNome());
		mt.pagarFuncionario();
		
		
	}
	

}
