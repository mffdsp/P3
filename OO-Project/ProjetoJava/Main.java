package com.mateus;
import java.util.*;



public class Main {
	
//	private int undoRedoPointer = -1;
//    private Stack<Command> commandStack = new Stack<>();
//
//    private void insertCommand()
//    {
//        deleteElementsAfterPointer(undoRedoPointer);
//        Command command =
//                new InsertCharacterCommand();
//        command.execute();
//        commandStack.push(command);
//        undoRedoPointer++;
//    }
//
//    private void deleteElementsAfterPointer(int undoRedoPointer)
//    {
//        if(commandStack.size()<1)return;
//        for(int i = commandStack.size()-1; i > undoRedoPointer; i--)
//        {
//            commandStack.remove(i);
//        }
//    }
//
//    private void undo()
//    {
//        Command command = commandStack.get(undoRedoPointer);
//        command.unExecute();
//        undoRedoPointer--;
//    }
//
//    private void redo()
//    {
//        if(undoRedoPointer == commandStack.size() - 1)
//            return;
//        undoRedoPointer++;
//        Command command = commandStack.get(undoRedoPointer);
//        command.execute();
//    }
//	
//	public static void main( String[] args) {
//		
//		System.out.println("Oiii");
//		Funcionario mt = new Horista();
//		mt.setNome("Mateusinhooooo");
//		System.out.println("NOME : " + mt.getNome());
//		mt.pagarFuncionario();
//		
//		
//	}
//	 public static void main(String[] args) {
//		 	Funcionario mt = new Horista();
//		 	
//	        Caretaker caretaker = new Caretaker();
//	        Originator originator = new Originator();
//	      
//	        mt.setNome("CARLOS");
//	        originator.setState(mt);
//	        
//	        caretaker.addMemento( originator.save() );
//	        
//	        mt.setNome("JUAU");
//	        originator.setState(mt);
//	        caretaker.addMemento( originator.save() );
//
//	        originator.restore( caretaker.getMemento() );
//
//	        
//	        System.out.println("Atual name = " + mt.getNome());
//	    }
//	
	public static void main(String[] args) {
	    Funcionario texto = new Horista();
	    texto.setNome("Primeira linha do texto\n");
	    texto.setNome("Segunda linha do texto\n");
	    texto.setNome("Terceira linha do texto\n");
	    texto.showName();
	    texto.undo();
	    texto.showName();
	    texto.undo();
	    texto.showName();
	    texto.undo();
	    texto.showName();
	    texto.undo();
	    texto.showName();
	}

}
