package pl.coderslab.applicationtomanagetheclaimsprecess.dto;

import lombok.Data;

import java.util.List;
@Data
public class ComplaintDTO {
    private List<String> typeOfDamage;

    public List<String> getTypeOfDamage() {
        return typeOfDamage;
    }

    public void setTypeOfDamage(List<String> typeOfDamage) {
        this.typeOfDamage = typeOfDamage;
    }
}
