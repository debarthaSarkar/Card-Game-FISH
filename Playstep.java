import java.util.*;

public class Playstep {
    Distribute obj;

    Playstep(Distribute obj) {
        this.obj = obj;
    }

    String checkStack()// to check the top most card in the stack
    {
        String card;
        card = obj.stack_cards.peek();
        System.out.println(card);
        obj.print();
        return card;
    }

    String released_card;

    String releaseCard(String topcard, String card)// to check the last released card
    {
        String chosencard = card;
        String target = chosencard;
        String newValue = topcard;

        for (int i = 0; i < obj.player_cards.length; i++) {
            if (obj.player_cards[i].equals(target)) {
                obj.player_cards[i] = newValue; // replace
                break;
            }
        }
        released_card = chosencard;
        return released_card;
    }
}
