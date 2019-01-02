/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.dao.InsufficientInventoryException;
import com.sg.vendingmachinespringmvc.dao.InvalidItemException;
import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.dao.VendingMachineDaoInMemImpl;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import com.sg.vendingmachinespringmvc.service.InsufficientFundsException;
import com.sg.vendingmachinespringmvc.service.ServiceLayer;
import com.sg.vendingmachinespringmvc.service.ServiceLayerImpl;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Elnic
 */
@Controller
public class VendingMachineController {

    ServiceLayer service;

    @Inject
    public VendingMachineController(ServiceLayerImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayItems(HttpServletRequest request, Model model) {
        List<Item> items = service.getAllItems();
        BigDecimal funds = service.getFunds();
        String id = service.getItemId();
        String messages = service.getMessages();
        model.addAttribute("showChange", request.getParameter("showChange"));
        if (request.getParameter("showChange") != null) {
            if (request.getParameter("showChange").equals("y")) {
                model.addAttribute("changeReturn", service.getChange());
                service.clearFunds();
                funds = service.getFunds();
            }
        }
        model.addAttribute("errorMessage", request.getParameter("errorMessage"));
        model.addAttribute("items", items);
        model.addAttribute("funds", funds);
        model.addAttribute("itemId", id);
        model.addAttribute("messages", messages);

        return "vendingmachine";
    }

    @RequestMapping(value = "/purchaseItem", method = RequestMethod.GET)
    public String purchaseItem(HttpServletRequest request, Model model) {

        String id = request.getParameter("itemId");
        try {
            service.purchaseItem(id);
            model.addAttribute("showChange", "y");
        } catch (InvalidItemException | InsufficientFundsException | InsufficientInventoryException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/selectItem", method = RequestMethod.GET)
    public String selectItem(HttpServletRequest request, Model model) {
        String id = request.getParameter("itemId");
        service.setItemId(id);
        model.addAttribute("showChange", "n");
        return "redirect:/";
    }

    @RequestMapping(value = "/returnChange", method = RequestMethod.POST)
    public String returnChange(HttpServletRequest request, Model model) {
        service.clearMessages();
        model.addAttribute("showChange", "y");
        return "redirect:/";
    }

    @RequestMapping(value = "/addMoney", method = RequestMethod.GET)
    public String addMoney(HttpServletRequest request, Model model) {

        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        service.clearMessages();
        service.addFunds(amount);
        model.addAttribute("showChange", "n");

        return "redirect:/";
    }

}
