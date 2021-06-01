package com.example.contractDatabaseServer.contracts;

import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.*;

/** Класс-хранилище реестра договоров
 * @author Andrey Pomelov
 * @version 1.0
 */
@Repository
public class ContractsRepository {

    /** Список всех имеющихся договоров */
    private final List<Contract> contractsList = new ArrayList<>();

    /** Метод, запускающийся автоматически при старте сервера.
     * Заполняет базу данных первоначальными данными в демонстрационных целях.
     */
    @PostConstruct
    private void init() {
        contractsList.add(new Contract(1, "01.02.2021", "01.02.2021"));
        contractsList.add(new Contract(2, "01.05.2021", "01.05.2021"));
        contractsList.add(new Contract(3, "01.06.2021", "01.06.2021"));

    }

    /** Метод, возвращающий список всех договоров */
    public List<Contract> getContractsList() {
        return new ArrayList<>(contractsList);
    }
}
