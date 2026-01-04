import java.util.*;
//Computer er part ta banate hobe next nahole "check what is in the top most card of the stack" thik kore work korche na
// chcp 65001
class Fish {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Distribute distributeobj = new Distribute();
        distributeobj.distributeCards();
        
        Playstep plobj = new Playstep(distributeobj);
        // Playstep plobj = new Playstep();
        String c, top_stack_card = "NULL";
        int i = 0;
        String card;
        distributeobj.player_cards=plobj.arrangeCards(distributeobj.player_cards);
        while (i < 35) {
            distributeobj.print();
            // try {
            // Thread.sleep(5000);//5 second delay
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
            if (i == 0 || plobj.released_card == null) {
                top_stack_card = plobj.checkStack();
                System.out.println("Choose the card to release:");
                card = sc.nextLine();
                plobj.releaseCard(top_stack_card, card);
                distributeobj.print();
            }
            System.out.println("What to do:");
            c = sc.nextLine();
            switch (c) {
                case "1":// check what is in the top most card of the stack
                    top_stack_card = plobj.checkStack();
                    System.out.println("Choose the card to release:");
                    card = sc.nextLine();
                    plobj.releaseCard(top_stack_card, card);
                    distributeobj.print();
                    System.out.println(plobj.released_card);
                    break;

                case "2":// interchange the card with the top card of released card
                    System.out.println("Choose the card to release:");
                    card = sc.nextLine();
                    plobj.takeReleasedCard(card);

                    distributeobj.print();
                    break;

                case "3":
                    System.exit(1);
                    break;

                default:
                    break;
            }
            i++;
        }

    }
}
