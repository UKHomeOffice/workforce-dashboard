package gov.homeoffice.workforceDashboard.controller;

import gov.homeoffice.workforceDashboard.service.EmployeeService;
import gov.homeoffice.workforceDashboard.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            return "redirect:/fileUploadStatus";
        }

        try {

            uploadService.uploadFile(file);

            if(file.isEmpty()) {

                redirectAttributes.addFlashAttribute("message",
                        "There has been a problem loading this file. Please try again");

            } else {

                redirectAttributes.addFlashAttribute("message",
                        file.getOriginalFilename() + " has been uploaded successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
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
}
