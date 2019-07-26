package gov.homeoffice.workforceDashboard.controller;

import gov.homeoffice.workforceDashboard.service.EmployeeService;
import gov.homeoffice.workforceDashboard.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

    private final UploadService uploadService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    public EmployeeController (UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @GetMapping("/")
    public String getIntro() {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/welcome")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload!");
            return "redirect:/welcome";
        }

        String extension;
        String fileName;
        fileName = file.getOriginalFilename();
        extension = fileName.substring(fileName.lastIndexOf('.')+ 1);

        //add file size error
        if (extension.equals("xlsx")) {

            try {
                uploadService.uploadFile(file);

                if (file.isEmpty()) {
                    redirectAttributes.addFlashAttribute("message",
                            "Error! There has been a problem loading this file. Please retry upload");
                } else {

                    redirectAttributes.addFlashAttribute("message",
                            file.getOriginalFilename() + " has been uploaded successfully");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            redirectAttributes.addFlashAttribute("message",
                     " Error! " + file.getOriginalFilename() + " is an incompatible file type. Please check file details and retry upload");
            return "redirect:/welcome";
        }
        return "redirect:/fileUploadStatus";
    }

    @GetMapping("/fileUploadStatus")
    public String fileUploadStatus() {
        return "fileUploadStatus";
    }

    @RequestMapping(value= "list", method= RequestMethod.GET)
    public String getEmployeeList(Model model) {
        employeeService.excelReader();
        model.addAttribute("lists", employeeService.findAll());
        return "list";
    }

    @GetMapping("/functionView")
    public String byFunction(Model model) {
        employeeService.excelReader();
        model.addAttribute("lists", employeeService.findByFunction());
        return "functionView";
    }

    @GetMapping("/selectedViews")
    public String selectedViews(Model model) {
        employeeService.excelReader();
        model.addAttribute("functions", employeeService.fieldSelect());
        return "selectedViews";
    }

    @PostMapping("/seeSelectedViews")
    public String seeSelectedViews (Model model, HttpServletRequest request) {
        String selection = request.getParameter("selectedOption");
        model.addAttribute("selection", selection);
        employeeService.excelReader();
        model.addAttribute("lists", employeeService.findBySelection(selection));
        return "functionView";
    }
}
