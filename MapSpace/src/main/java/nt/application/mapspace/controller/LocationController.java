/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nt.application.mapspace.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import nt.application.mapspace.dao.LocationDao;
import nt.application.mapspace.dao.LocationDaoDbImpl;
import nt.application.mapspace.dao.UserDao;
import nt.application.mapspace.model.Location;
import nt.application.mapspace.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.json.JSONArray;

/**
 *
 * @author Elnic
 */
@Controller
public class LocationController {

    @Inject
    LocationDao lDao;
    @Inject
    UserDao uDao;

    @RequestMapping(value = "/addLocation", method = RequestMethod.POST)
    public String addloc(@ModelAttribute("location") Location location, BindingResult rs, Model model, HttpServletRequest rq) {
        if (rs.hasErrors()) {
            model.addAttribute("location", new Location());
            return "/index";
        } else {
            User user = uDao.getUser(rq.getParameter("user"));
            lDao.addLocation(location, user.getId());
            model.addAttribute("location", new Location());
            return "redirect:/";
        }
    }
    
    @RequestMapping(value="/newLocation", method = RequestMethod.POST)
    @ResponseBody
    public Location newLocation(HttpServletRequest request, HttpServletResponse response) {
        Location location = new Location();
        JSONArray jArray = new JSONArray();
        return location;
    }

    @RequestMapping(value = "/displayAllLocations", method = RequestMethod.GET)
    public String showAll(HttpServletRequest rq, Model model) {
        User user = uDao.getUser(rq.getParameter("user"));
        model.addAttribute("locations", lDao.loadLocations(user.getId()));
        return "/index";
    }

    @RequestMapping(value = "/deleteLocation", method = RequestMethod.GET)
    public String deleteLocation(HttpServletRequest rq, Model model) {
        int id = Integer.parseInt(rq.getParameter("id"));
        Location location = lDao.loadLocation(id);

        lDao.deleteLocation(location);

        return "redirect:/";
    }

    @RequestMapping(value = "/loadLocation", method = RequestMethod.GET)
    public String locationDetails(HttpServletRequest rq, Model model) {
        model.addAttribute("location", lDao.loadLocation(Integer.parseInt(rq.getParameter("id"))));
        return "locations/locationinfo/locationInfo";
    }

    @RequestMapping(value = "/deleteMarker/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Location deleteMarker(@PathVariable("id") String id) {
        Location location = lDao.loadLocation(Integer.parseInt(id));
        lDao.deleteLocation(location);
        return location;
    }
}
