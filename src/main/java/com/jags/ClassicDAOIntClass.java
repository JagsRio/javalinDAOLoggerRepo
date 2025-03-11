package com.jags;
import java.util.*;

public interface ClassicDAOIntClass {
    public OfficeModel CreateOffice(OfficeModel newOffice);
    public boolean DeleteOffice(String officeCode);
    public List<OfficeModel> GetAllOffices();
    public OfficeModel GetOfficeById(String offcode);
}