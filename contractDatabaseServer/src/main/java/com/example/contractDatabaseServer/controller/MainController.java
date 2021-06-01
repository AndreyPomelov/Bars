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

@Controller
public class MainController {

    private final ContractsRepository repository;
    private List<Contract> contractList;
    private final int MILLIS_IN_DAY = 86400000;

    public MainController(ContractsRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String main(Model model) {
        contractList = repository.getContractsList();
        List<Contract> result = contractListProcessing(contractList);
        model.addAttribute("contracts", result);
        return "index";
    }

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
