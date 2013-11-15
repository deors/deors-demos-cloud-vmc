package deors.demos.cloud.vmc.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import deors.demos.cloud.vmc.entities.Codes;
import deors.demos.cloud.vmc.services.CodesService;

import java.util.Collection;

@Controller
public class CodesController
    implements ApplicationContextAware {

    protected final Log logger = LogFactory.getLog(getClass());

    private ApplicationContext applicationContext;

    private CodesService codesService;

    public CodesController() {

        super();
    }

    @RequestMapping("/CodesView.do")
    public String view(ModelMap model) {

        try {
            Collection<? extends Codes> list = codesService.selectAll();
            model.addAttribute("list", list);
        } catch (org.springframework.dao.DataAccessException dae) {
            model.addAttribute("message", "ERROR reading Codes table: " + dae.getMessage());
        }

        return "CodesView.jsp";
    }

    @RequestMapping("/CodesAdd.do")
    public String add(ModelMap model, @RequestParam("code") String code, @RequestParam("value") String value) {

        Codes newCode = applicationContext.getBean("codes", Codes.class);
        newCode.setCode(code);
        newCode.setValue(value);

        try {
            codesService.insert(newCode);
        } catch (org.springframework.dao.DataAccessException dae) {
            model.addAttribute("message", "ERROR adding new records to Codes table: " + dae.getMessage());
        }

        return "CodesView.do";
    }

    @RequestMapping("/CodesUpdate.do")
    public String update(ModelMap model, @RequestParam("code") String code, @RequestParam("value") String value) {

        Codes updateCode = applicationContext.getBean("codes", Codes.class);
        updateCode.setCode(code);
        updateCode.setValue(value);

        try {
            codesService.update(updateCode);
        } catch (org.springframework.dao.DataAccessException dae) {
            model.addAttribute("message", "ERROR updating Codes table: " + dae.getMessage());
        }

        return "CodesView.do";
    }

    @RequestMapping("/CodesDelete.do")
    public String delete(ModelMap model, @RequestParam("code") String code) {

        Codes deleteCode = applicationContext.getBean("codes", Codes.class);
        deleteCode.setCode(code);

        try {
            codesService.delete(deleteCode);
        } catch (org.springframework.dao.DataAccessException dae) {
            model.addAttribute("message", "ERROR deleting records from Codes table: " + dae.getMessage());
        }

        return "CodesView.do";
    }

    public void setApplicationContext(ApplicationContext applicationContext) {

        this.applicationContext = applicationContext;
    }

    public void setCodesService(CodesService codesService) {

        this.codesService = codesService;
    }
}
