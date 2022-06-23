package ru.rsreu._0204vanyukov.datalayer.oracledb;

import ru.rsreu._0204vanyukov.datalayer.IDAO.DocumentsDAO;
import ru.rsreu._0204vanyukov.model.Documents;
import ru.rsreu._0204vanyukov.model.Users;
import ru.rsreu._0204vanyukov.resource.SQLQueriesManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleDocumentsDAO implements DocumentsDAO {

    private Connection connection;

    public OracleDocumentsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Documents> getDocuments() {
        List<Documents> documentsList = new ArrayList<>();
        Documents document = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.documents");
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                document = new Documents(resultSet.getInt("id"),
                        resultSet.getString("document_number"),
                        resultSet.getInt("country_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("docyment_type"),
                        resultSet.getBoolean("document_correct"));
                documentsList.add(document);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documentsList;
    }

    @Override
    public List<Documents> getUserDocuments(Users user) {
        List<Documents> documentsList = new ArrayList<>();
        Documents document = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.user_documents");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                document = new Documents(resultSet.getInt("id"),
                        resultSet.getString("document_number"),
                        resultSet.getInt("country_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("docyment_type"),
                        resultSet.getBoolean("document_correct"));
                documentsList.add(document);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documentsList;
    }

    @Override
    public void addDocument(Documents document) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.add.documents");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, document.getUser_id());
            preparedStatement.setString(2, document.getDocument_number());
            preparedStatement.setString(3, document.getDocyment_type());
            preparedStatement.setInt(4, document.getCountry_id());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDocument(Documents document) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.documents");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, document.getUser_id());
            preparedStatement.setString(2, document.getDocument_number());
            preparedStatement.setString(3, document.getDocyment_type());
            preparedStatement.setInt(4, document.getCountry_id());
            preparedStatement.setInt(5, document.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDocument(Documents document) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.delete.documents");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, document.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void documentCorrect(Documents document) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.document_correct_status");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, document.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void documentIncorrect(Documents document) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.document_correct_status");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, document.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
