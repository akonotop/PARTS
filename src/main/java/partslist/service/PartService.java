package partslist.service;

import partslist.model.Part;

import java.util.List;

public interface PartService {
    List<Part> allParts(int page);

    void add(Part part);
    void delete(Part part);
    void edit(Part part);

    Part getById(int id);

    int partsCount();
    int compsCount();



    boolean checkName(String name);

    List<Part> findByName(String name);

    List<Part> allTrueParts(int page);

    List<Part> allFalseParts(int page);
}
