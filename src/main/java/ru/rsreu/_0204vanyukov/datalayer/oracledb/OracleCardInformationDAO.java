package ru.rsreu._0204vanyukov.datalayer.oracledb;

import ru.rsreu._0204vanyukov.datalayer.IDAO.CardInformationDAO;
import ru.rsreu._0204vanyukov.model.CardInformation;
import ru.rsreu._0204vanyukov.model.Users;
import ru.rsreu._0204vanyukov.resource.SQLQueriesManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleCardInformationDAO implements CardInformationDAO {

    private Connection connection;

    public OracleCardInformationDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<CardInformation> getCardsInformation() {
        List<CardInformation> cardInformationList = new ArrayList<>();
        CardInformation cardInformation = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.cards_information");
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                cardInformation = new CardInformation(resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("card_number"),
                        resultSet.getDate("card_date"),
                        resultSet.getInt("card_cvv"));
                cardInformationList.add(cardInformation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardInformationList;
    }

    @Override
    public List<CardInformation> getUserCardsInformation(Users user) {
        List<CardInformation> cardInformationList = new ArrayList<>();
        CardInformation cardInformation = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.user_cards_information");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                cardInformation = new CardInformation(resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("card_number"),
                        resultSet.getDate("card_date"),
                        resultSet.getInt("card_cvv"));
                cardInformationList.add(cardInformation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardInformationList;
    }

    @Override
    public void addCardInformation(CardInformation cardInformation) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.add.card_information");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cardInformation.getUser_id());
            preparedStatement.setString(2, cardInformation.getCard_number());
            preparedStatement.setDate(3, (Date) cardInformation.getCard_date());
            preparedStatement.setInt(4, cardInformation.getCard_cvv());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCardInformation(CardInformation cardInformation) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.card_information");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cardInformation.getUser_id());
            preparedStatement.setString(2, cardInformation.getCard_number());
            preparedStatement.setDate(3, (Date) cardInformation.getCard_date());
            preparedStatement.setInt(4, cardInformation.getCard_cvv());
            preparedStatement.setInt(5, cardInformation.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCardInformation(CardInformation cardInformation) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.delete.card_information");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cardInformation.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
