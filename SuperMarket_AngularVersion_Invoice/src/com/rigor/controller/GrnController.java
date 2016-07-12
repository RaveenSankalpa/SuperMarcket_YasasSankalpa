package com.rigor.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rigor.entity.Grn;
import com.rigor.service.GrnService;

@Controller
@RequestMapping("/")
public class GrnController {
	//private List<Grn> grn_list = new ArrayList<>();
	
	@Autowired
	private GrnService grnService;
	
	@RequestMapping(value = "/listGrn", method = RequestMethod.GET)
	public ModelAndView ListGrn() {
		return new ModelAndView("list-Grn", "grnList", grnService.getAllGrn());
		

	}
	
	
	@RequestMapping(value = "modifyGrn")
	public ModelAndView modifyGrn(Grn grnE,
			BindingResult result) {

		return new ModelAndView("list-Grn");

	}
	@RequestMapping(value = "/editGrn", method = RequestMethod.GET)
	public String editPage(ModelMap modelMap, HttpServletRequest request) {
		int grnId = Integer.parseInt(request.getParameter("id"));
		modelMap.addAttribute("grns", grnService.getGrn(grnId));
		modelMap.addAttribute("update", true);
		return "place-grn";
	}
	
	@RequestMapping(value = "/deleteGrn", method = RequestMethod.GET)
	public ModelAndView deleteGrn(HttpServletRequest request) {
		int grnId = Integer.parseInt(request.getParameter("id"));
		grnService.deleteGrn(grnId);
		return new ModelAndView("list-Grn", "grnList",
				grnService.getAllGrn());

	}


	@RequestMapping(value = "/addGrn", method = RequestMethod.GET)
	public String addGrn(ModelMap modelMap) {
		modelMap.addAttribute("grns", new Grn());
		modelMap.addAttribute("update", false);
		return "place-grn";

	}

	@RequestMapping(value = "/addGrn")
	public ModelAndView addGrn(Grn grnE, BindingResult result) {
		
		ModelAndView modelAndView = new ModelAndView("list-Grn");
		
		if (grnE.getGrnID() > 0) {
			// update
			grnService.update(grnE);
			
		} else {
			// add product
			grnService.saveGrn(grnE);
			
		}
		grnService.indexinit();
		modelAndView.addObject("grnList", grnService.getAllGrn());
		System.out.println(grnE.getGrnID());
		return modelAndView;
	}
	
	@RequestMapping(value = "/searchGRN", method = RequestMethod.GET)
	public ModelAndView searchPage(){
	   ModelAndView mav = new ModelAndView("list-Grn");
	   return mav;
	}
	
	@RequestMapping(value = "/GrnSearch", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("searchText")String searchText) throws Exception{
		List<Grn> allFound = grnService.searchForGrn(searchText);      
         
        for (Grn grn : allFound) {
            System.out.println(grn);
        } 

	      ModelAndView mav = new ModelAndView("list-Grn");
	      mav.addObject("foundGrn", allFound);
		  return mav;
	  }

}
