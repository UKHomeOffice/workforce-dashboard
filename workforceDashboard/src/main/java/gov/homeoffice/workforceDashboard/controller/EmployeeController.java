package gov.homeoffice.workforceDashboard.controller;

import gov.homeoffice.workforceDashboard.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    private static String UPLOADED_FILE = "FILE_PATH";

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
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload. Click here to retry a href");
            return "redirect:/fileUploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            System.out.println(UPLOADED_FILE + file.getOriginalFilename());
            Path path = Paths.get(UPLOADED_FILE + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

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
}
