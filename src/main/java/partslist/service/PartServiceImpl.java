package partslist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import partslist.dao.PartDAO;
import partslist.model.Part;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {
    private PartDAO partDAO;

    @Autowired
    public void setPartDAO(PartDAO partDAO) {
        this.partDAO = partDAO;
    }

    @Override
    @Transactional
    public List<Part> allParts(int page) {
        return partDAO.allParts(page);
    }

    @Override
    @Transactional
    public void add(Part part) {
        partDAO.add(part);
    }

    @Override
    @Transactional
    public void delete(Part part) {
        partDAO.delete(part);
    }

    @Override
    @Transactional
    public void edit(Part part) {
        partDAO.edit(part);
    }

    @Override
    @Transactional
    public Part getById(int id) {
        return partDAO.getById(id);
    }

    @Override
    @Transactional
    public int partsCount() {
        return partDAO.partsCount();
    }

    @Override
    @Transactional
    public int compsCount() {
        return partDAO.compsCount();
    }



    @Override
    @Transactional
    public boolean checkName(String name) {
        return partDAO.checkName(name);
    }

    @Override
    @Transactional
    public List<Part> findByName(String name) {
        return partDAO.findByName(name);
    }

    @Override
    @Transactional
    public List<Part> allTrueParts(int page) {
        return partDAO.allTrueParts(page);
    }

    @Override
    @Transactional
    public List<Part> allFalseParts(int page) {
        return partDAO.allFalseParts(page);
    }
}
