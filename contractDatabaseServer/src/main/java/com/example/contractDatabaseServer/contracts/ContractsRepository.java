package com.example.contractDatabaseServer.contracts;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ContractsRepository {

    private final List<Contract> contractsList = new ArrayList<>();

    @PostConstruct
    private void init() {
        contractsList.add(new Contract(1, "01.02.2021", "01.02.2021"));
        contractsList.add(new Contract(2, "01.05.2021", "01.05.2021"));
        contractsList.add(new Contract(3, "01.06.2021", "01.06.2021"));

    }

    public List<Contract> getContractsList() {
        return new ArrayList<>(contractsList);
    }
}
