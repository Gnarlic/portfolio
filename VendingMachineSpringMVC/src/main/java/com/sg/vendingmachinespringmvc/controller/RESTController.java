/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Item;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Elnic
 */
@CrossOrigin
@Controller
public class RESTController {
    
    private VendingMachineDao dao;
    
    @Inject
    public RESTController(VendingMachineDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/getItems", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getAllItems() {
        return dao.getAllItems();
    }
    
    @RequestMapping(value="/vendItem/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem(@PathVariable("id") String id,
            @Valid @RequestBody Item item) {
        dao.updateItem(id);
    }
}
    

