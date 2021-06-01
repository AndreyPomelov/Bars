package com.example.contractDatabaseServer.controller;

import com.example.contractDatabaseServer.contracts.Contract;
import com.example.contractDatabaseServer.contracts.ContractsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/** Класс-основной контролллер
 * @author Andrey Pomelov
 * @version 1.0
 */
@Controller
public class MainController {

    /** Ссылка на класс-хранилище списка договоров */
    private final ContractsRepository repository;
    /** Список договоров */
    private List<Contract> contractList;
    /** Переменная, содержащая количество миллисекунд в сутках */
    private final int MILLIS_IN_DAY = 86400000;

    /** Конструктор
     *
     * @param repository ссылка на класс-хранилище списка договоров
     */
    public MainController(ContractsRepository repository) {
        this.repository = repository;
    }

    /** Метод, обрабатывающий запрос, поступивший от клиента по http
     *
     * @param model в метод передаётся модель для возможности добавления
     *              в неё атрибутов (список договоров в данном методе)
     * @return имя макета генерируемой веб-страницы
     */
    @GetMapping
    public String main(Model model) {
        contractList = repository.getContractsList();
        List<Contract> result = contractListProcessing(contractList);
        model.addAttribute("contracts", result);
        return "index";
    }

    /** Метод, обрабатывающий список договоров.
     * Служит для вычисления разницы между текущей датой и
     * датой обновления договора.
     * Если разница составляет менее 60 дней, проставляет true в
     * поле setActual договора.
     * @see Contract
     * @param contractList список договоров до обработки
     * @return список договоров после обработки
     */
    private List<Contract> contractListProcessing(List<Contract> contractList) {
        for (Contract contract : contractList) {
            try {
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                Date date = df.parse(contract.getLastUpdate());
                Date currentDate = new Date();
                if ((currentDate.getTime() - date.getTime()) / MILLIS_IN_DAY < 60) contract.setActual(true);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return contractList;
    }
}
