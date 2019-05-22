package partslist.dao;

import partslist.model.Part;

import java.util.List;

public interface PartDAO {
    List<Part> allParts(int page);

    void add(Part part);
    void delete(Part part);
    void edit(Part part);

    Part getById(int id);

    int compsCount();
    int partsCount();

    List<Part> findByName(String name);

    List<Part> allTrueParts(int page);
    List<Part> allFalseParts(int page);

    boolean checkName(String name);

}
