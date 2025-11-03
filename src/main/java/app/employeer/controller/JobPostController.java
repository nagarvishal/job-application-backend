package app.employeer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("job-post")
public class JobPostController {

    @PostMapping("/create")
    public ResponseEntity<?> createJobPost(){
        return null;
    }

    @GetMapping("/info")
    public ResponseEntity<?> fetchJobInfo(){
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateJobInfo(){
        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteJobPost(){
        return null;
    }
    


}
