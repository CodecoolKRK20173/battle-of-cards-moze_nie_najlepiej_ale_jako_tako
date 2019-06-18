package com.codecool.jakotako.battleofcards.parser;


import com.codecool.jakotako.battleofcards.Card;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.codecool.jakotako.battleofcards.CardRepository;


public class CardParser extends XMLParser{

    private CardRepository cardRepository;

    public CardParser{
        this.cardRepository = new CardRepository;
        loadXmlDocument("src/resources/cards.xml");
        parse();
    }

    private void parse(){
        NodeList nodeList = document.getElementsByTagName("Card");

        for(int i = 0;i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;

                String cardID = element.getAttribute("id");
                String cardDescription = element.getChildNodes().item(1).getAttributes().item(0).getTextContent();

                Card newCard = new Card(cardID, cardDescription); //TODO
                NodeList stats = element.getElementsByTagName("Stat");
                for (int j = 0; j < stats.getLength(); j++){
                    Element stat = (Element) stats.item(j);
                    String cardStatID = stat.getAttribute("id");
                    String cardStatValue = stat.getTextContent(); //change na getValue?
                    newCard.setCardValueById(cardStatID, Integer.valueOf(cardStatValue));
                }
                cardRepository.addCard(newCard);
            }
        }
    }
    public CardRepository getCardRepository(){
        return this.cardRepository;
    }
}

