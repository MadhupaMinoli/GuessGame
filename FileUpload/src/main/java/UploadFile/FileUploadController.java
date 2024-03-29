package UploadFile;

import java.io.IOException;
import java.util.stream.Collectors;

import UploadFile.WordRepository.Datasource;
import UploadFile.WordRepository.TextDatasource;
import UploadFile.storage.StorageFileNotFoundException;
import UploadFile.storage.StorageService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {

        this.storageService = storageService;
    }

    @GetMapping("/")
    public String DisplayUploadForm() throws IOException {
        return "uploadForm";
    }

    @GetMapping("/AllFiles")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "getFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));

        return "uploadFiles";
    }

    @GetMapping("/AllFiles/{filename:.+}")
    @ResponseBody

    public String getFile(@PathVariable String filename) {
        JSONArray jsonObject = new JSONArray();
        String path = ClassLoader.getSystemClassLoader().getResource("TxtFiles/"+filename).getPath();
        Datasource dataSource = new TextDatasource(path);

        for (String a:dataSource.getWordList()) {
            jsonObject.put(a);
        }

        return jsonObject.toString();
    }


    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("UploadMessage",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
