package ru.rsreu._0204vanyukov.datalayer.IDAO;

import ru.rsreu._0204vanyukov.model.CardInformation;
import ru.rsreu._0204vanyukov.model.Users;

import java.util.List;

public interface CardInformationDAO {
    List<CardInformation> getCardsInformation();
    List<CardInformation> getUserCardsInformation(Users user);
    void addCardInformation(CardInformation cardInformation);
    void updateCardInformation(CardInformation cardInformation);
    void deleteCardInformation(CardInformation cardInformation);
}
