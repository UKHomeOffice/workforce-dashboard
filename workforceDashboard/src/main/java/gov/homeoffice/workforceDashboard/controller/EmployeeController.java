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

    @Autowired
    EmployeeService employeeService;

    @Autowired
    UploadService uploadService;

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
            redirectAttributes.addFlashAttribute("message", "Error! No file found. Select a file to upload!");
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
                            "Error! There has been a problem loading file. Retry upload");
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
}
