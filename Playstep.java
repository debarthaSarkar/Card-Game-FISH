import java.util.*;
public class Playstep {
    Scanner sc=new Scanner(System.in);
    Distribute obj;
    Playstep() {
        
    }

    Playstep(Distribute obj) {
        this.obj = obj;
    }

    String[] arrangeCards(String cards[])
    {
        // obj.print();
        System.out.println("Enter the cards in order and put a ',' and leave 'space' after each card name:");
        String input = sc.nextLine();
        String[] arrangedCard = input.split(", ");
        boolean duplicate;
        int i=0;
        do {
                duplicate = false;
                String card = arrangedCard[i];

                for (int j = 0; j < 8; j++) {
                    if (!card.equals(cards[j])) {
                        duplicate = true;
                        break;
                    }
                }
                i++;
            } while (duplicate && i<8);
        return arrangedCard;
    }

    String checkStack()// to check the top most card in the stack
    {
        String card;
        card = obj.stack_cards.peek();
        System.out.println("The top card from the stack is:" + card);
        obj.stack_cards.pop();
        // obj.print();
        return card;
    }

    String released_card;

    void releaseCard(String topcard, String card, String[] turn)// to swap one of your card with topcard
    {
        if (topcard.equals(card)) {
            released_card = topcard;
            return;
        } else {
            String chosencard = card;
            String target = chosencard;
            String newValue = topcard;

            for (int i = 0; i < turn.length; i++) {
                if (turn[i].equals(target)) {
                    turn[i] = newValue; // replace
                    break;
                }
            }
            released_card = chosencard;
        }
    }
    void takeReleasedCard(String card,String[] turn){//to swap one of your card with last released card
        String target = card;
        String newValue = released_card;

        for (int i = 0; i < turn.length; i++) {
            if (turn[i].equals(target)) {
                turn[i] = newValue; // replace
                break;
            }
        }
        released_card = card;
    }
}
