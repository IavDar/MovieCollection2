package movieCollection;

import movieCollection.views.CLIView;

public class Main {
    public static void main(String[] args) {

        CLIView view = new CLIView();

       while (true){
           try {
               view.run();
           } catch (Exception e){
               System.out.println(e.getMessage());
           }
       }

    }
}


