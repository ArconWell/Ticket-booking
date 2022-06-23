package ru.rsreu._0204vanyukov.datalayer.oracledb;

import ru.rsreu._0204vanyukov.datalayer.IDAO.TicketsDAO;
import ru.rsreu._0204vanyukov.model.Documents;
import ru.rsreu._0204vanyukov.model.Tickets;
import ru.rsreu._0204vanyukov.resource.SQLQueriesManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleTicketsDAO implements TicketsDAO {

    private Connection connection;

    public OracleTicketsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Tickets> getTickets() {
        List<Tickets> ticketsList = new ArrayList<>();
        Tickets ticket = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.tickets");
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ticket = new Tickets(resultSet.getInt("id"),
                        resultSet.getInt("document_id"),
                        resultSet.getInt("flight_id"),
                        resultSet.getBoolean("departure_allowed"),
                        resultSet.getBoolean("ticket_paid"));
                ticketsList.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketsList;
    }

    @Override
    public List<Tickets> getDocumentTickets(Documents document) {
        List<Tickets> ticketsList = new ArrayList<>();
        Tickets ticket = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.select.document_tickets");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, document.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ticket = new Tickets(resultSet.getInt("id"),
                        resultSet.getInt("document_id"),
                        resultSet.getInt("flight_id"),
                        resultSet.getBoolean("departure_allowed"),
                        resultSet.getBoolean("ticket_paid"));
                ticketsList.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketsList;
    }

    @Override
    public void addTicket(Tickets ticket) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.add.tickets");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ticket.getDocument_id());
            preparedStatement.setInt(2, ticket.getFlight_id());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTicket(Tickets ticket) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.tickets");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ticket.getDocument_id());
            preparedStatement.setInt(2, ticket.getFlight_id());
            preparedStatement.setInt(3, ticket.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTicket(Tickets ticket) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.delete.tickets");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ticket.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void departureAllowed(Tickets ticket) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.ticket_departure_allowed_status");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, ticket.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void departureNotAllowed(Tickets ticket) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.ticket_departure_allowed_status");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, ticket.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ticketPaid(Tickets ticket) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.ticket_paid_status");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, ticket.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tickedNotPaid(Tickets ticket) {
        PreparedStatement preparedStatement = null;

        try {
            String query = SQLQueriesManager.getProperty("sql.update.ticket_paid_status");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, ticket.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
