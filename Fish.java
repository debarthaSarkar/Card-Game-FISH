import java.util.*;

// git init
// git add README.md
// git commit -m "first commit"
// git branch -M main
// git remote add origin https://github.com/debarthaSarkar/Card-Game-FISH.git
// git push -u origin main
class Fish {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Distribute distributeobj = new Distribute();
        Playstep plobj = new Playstep(distributeobj);
        Computer comobj = new Computer(distributeobj);
        distributeobj.distributeCards();
        // Playstep plobj = new Playstep();
        String c, top_stack_card = "NULL";
        int i = 0;
        String card;
        System.out.println("Player Cards:");
        for (String p : distributeobj.player_cards)
            System.out.print(p + ", ");
        System.out.println("\nTrump card:" + distributeobj.trump_card);
        distributeobj.player_cards = plobj.arrangeCards(distributeobj.player_cards);
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
                plobj.releaseCard(top_stack_card, card, distributeobj.player_cards);
                distributeobj.print();
                // comobj.makeDecision();
            }
            System.out.println("What to do:");
            c = sc.nextLine();
            switch (c) {
                case "1":// check what is in the top most card of the stack
                    top_stack_card = plobj.checkStack();
                    System.out.println("Choose the card to release:");
                    card = sc.nextLine();
                    plobj.releaseCard(top_stack_card, card, distributeobj.player_cards);
                    distributeobj.print();
                    System.out.println(plobj.released_card);
                    break;

                case "2":// interchange the card with the last released card
                    System.out.println("Choose the card to release:");
                    card = sc.nextLine();
                    plobj.takeReleasedCard(card, distributeobj.player_cards);
                    distributeobj.print();
                    break;

                case "3":
                    System.exit(1);
                    break;

                default:
                    break;
            }
            comobj.makeDecision();
            i++;
        }

    }
}
