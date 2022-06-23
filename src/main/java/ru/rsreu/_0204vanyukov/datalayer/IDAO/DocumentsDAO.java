package ru.rsreu._0204vanyukov.datalayer.IDAO;

import ru.rsreu._0204vanyukov.model.Documents;
import ru.rsreu._0204vanyukov.model.Users;

import java.util.List;

public interface DocumentsDAO {
    List<Documents> getDocuments();
    List<Documents> getUserDocuments(Users user);
    void addDocument(Documents document);
    void updateDocument(Documents document);
    void deleteDocument(Documents document);
    void documentCorrect(Documents document);
    void documentIncorrect(Documents document);
}
