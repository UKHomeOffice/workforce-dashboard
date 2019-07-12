package gov.homeoffice.workforceDashboard.controller;

import gov.homeoffice.workforceDashboard.service.EmployeeService;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    private static String UPLOADED_FILE = "";

    @GetMapping("/")
    public String getIntro() {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/welcome") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload!");
            return "redirect:/fileUploadStatus";
        }

        try {

            // Get the file and save it into classpath
            byte[] bytes = file.getBytes();
            System.out.println(UPLOADED_FILE + file.getOriginalFilename());
            Path path = Paths.get(UPLOADED_FILE + file.getOriginalFilename());
            Files.write(path, bytes);

            if(file.isEmpty()) {

                redirectAttributes.addFlashAttribute("message",
                        "There has been a problem loading this file. Please try again");

            } else {

                redirectAttributes.addFlashAttribute("message",
                        file.getOriginalFilename() + " has been uploaded successfully");
            }

        } catch (IOException e) {
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

    @GetMapping("/functionView")
    public String byFunction(Model model) {
        employeeService.excelReader();
        model.addAttribute("lists", employeeService.findByFunction());
        return "functionView";
    }
}
