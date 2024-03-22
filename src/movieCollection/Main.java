package movieCollection;

import movieCollection.views.CLIView;

public class Main {
    public static void main(String[] args) {

        CLIView view = new CLIView();

// пришлось убрать while (true), т.к. получался бесконечный цикл
           try {
               view.run(args[0]);
           } catch (Exception e){
               System.out.println(e.getMessage());
           }
       }


}


