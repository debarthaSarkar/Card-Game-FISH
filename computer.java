public class Computer {
    Distribute obj;
    String[] cards = new String[8];
    Fish fishobj = new Fish();
    Playstep plobj = new Playstep();
    Computer(Distribute obj)
    {
        this.obj = obj;
    }
    static String[] card_numbers = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
    String TrumpCard(/*Now it knows which one is the trump card*/ )
    {
        String tc= obj.trump_card;
        String[] trump_array = tc.split("");
        String card_number = trump_array[1];
        for(int i=0;i<=11;i++)
        {
            if (card_number.equals(card_numbers[i])) {
                card_number=card_numbers[i+1];
                break;
            }
        }
        if (card_number.equals("A")) {
                card_number="2";
            }
        String trump_card = trump_array[0]+card_number;
        return trump_card;
    }
    void makeDecision()
    {
        for(int i=0;i<8;i++)
        {
            String ccard=obj.computer_cards[0];
            if (!ccard.equals(TrumpCard())) {
                plobj.takeReleasedCard(ccard,obj.computer_cards);
                return;
            }
            else
            {
                continue;
            }
        }
    }
}
