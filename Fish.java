import java.util.*;
// chcp 65001
class Fish {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Distribute distributeobj = new Distribute();
        distributeobj.distributeCards();
        distributeobj.print();
        Playstep plobj = new Playstep(distributeobj);
        String c,top_stack_card="NULL";
        while (true) {
            // try {
            //     Thread.sleep(5000);//5 second delay
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            System.out.println("What to do:");
            c = sc.nextLine();
            switch (c) {
                case "1"://check what is in the top most card of the stack
                    top_stack_card=plobj.checkStack();
                    break;

                case "2"://interchange the card with the top card of stack
                    System.out.println("Choose the card:");
                    String card;
                    card = sc.nextLine();
                    plobj.releaseCard(top_stack_card,card);
                    distributeobj.print();
                    break;

                case "3":
                    System.exit(1);
                    break;

                default:
                    break;
            }
        }

    }
}
