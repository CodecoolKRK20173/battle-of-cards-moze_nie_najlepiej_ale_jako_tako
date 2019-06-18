
public class CardParser extends XMLParser{

    private CardRepository cardRepository;

    public CardParser{
        this.cardRepository = new CardRepository;
        loadXmlDocument("src/cards.xml");

    }

    public CardRepository getCardRepository() {
        return cardRepository;
    }
}
